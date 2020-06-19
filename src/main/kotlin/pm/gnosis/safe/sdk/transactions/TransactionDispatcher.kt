package pm.gnosis.safe.sdk.transactions

import org.koin.core.KoinComponent
import org.koin.core.inject
import pm.gnosis.ethereum.EthCall
import pm.gnosis.ethereum.EthereumRepository
import pm.gnosis.model.Solidity
import pm.gnosis.safe.sdk.Environment
import pm.gnosis.safe.sdk.contracts.SafeAbi
import pm.gnosis.safe.sdk.crypto.ECDSASignature
import pm.gnosis.safe.sdk.crypto.KeyPair
import pm.gnosis.safe.sdk.crypto.utils.asBigInteger
import pm.gnosis.safe.sdk.crypto.utils.asEthereumAddress
import pm.gnosis.safe.sdk.network.models.SafeTransaction
import pm.gnosis.safe.sdk.network.models.ServiceTransaction
import pm.gnosis.safe.sdk.network.models.Transaction
import pm.gnosis.safe.sdk.network.repositories.TransactionRepository
import pm.gnosis.safe.sdk.safe.SafeManager
import pm.gnosis.utils.hexToByteArray
import pm.gnosis.utils.toHex
import java.math.BigInteger

class TransactionDispatcher : KoinComponent {

    private val ethereumRepository by inject<EthereumRepository>()
    private val transactionRespository by inject<TransactionRepository>()
    private val environment by inject<Environment>()

    suspend fun submit() {

        // We use an EOA account that has been setup as an owner of a safe before running the code
        // We used in this case metamask to obtain the private key:
        //  - open browser extension
        //  - go to "Account details"
        //  - Press "Export Private Key"
        //  - Copy the value into the first line of .env.private_key
        val key = KeyPair.fromPrivate(environment.privateKey.hexToByteArray())

        // Public Ethereum address of the EOA should match with what you see in metamask
        println(key.address.toHex())


        // We keep a reference to the public address of the safe to which our EOA is an owner of
        val safe = environment.safeAddress.asEthereumAddress()!!

        // We request via JSON RPC the current nonce of our safe, we need to know this nonce before submitting to
        // the safe transaction service. If we submit a transaction with a safe smaller than the the current safe
        // nonce, the transaction would be invalid (or cancel a transaction that is awaiting execution with the same
        // nonce
        val nonce = SafeAbi.Nonce.decode(
            ethereumRepository.request(
                EthCall(transaction = Transaction(safe, data = SafeAbi.Nonce.encode()))
            ).result()!!
        ).param0.value
        println(nonce)

        // We define the transaction we want to submit to the safe transaction service. This transaction will transfer
        // 10 Wei to our EOA account. We use the current nonce of the safe. Note: most default values are 0 but, the ones
        // we define are the bare minimum for having a valid transaction.
        val tx = SafeTransaction(
            to = "0xBe8C10Dbf4c6148f9834C56C3331f8191f355552".asEthereumAddress()!!,
            value = BigInteger.TEN,
            data = "0x",
            nonce = nonce
        )

        // We need to calculate the hash of the data we want submit to the safe transaction service. We do this on-chain,
        // By using the `GetTransactionHash`. We will later sign this hash with the private key of our EOA.
        // This is a safe transaction signature.
        val transactionHash = SafeAbi.GetTransactionHash.decode(
            ethereumRepository.request(
                EthCall(
                    transaction = Transaction(
                        safe,
                        data = SafeAbi.GetTransactionHash.encode(
                            tx.to,
                            Solidity.UInt256(tx.value),
                            Solidity.Bytes(tx.data.hexToByteArray()),
                            Solidity.UInt8(tx.operation),
                            Solidity.UInt256(tx.safeTxGas),
                            Solidity.UInt256(tx.baseGas),
                            Solidity.UInt256(tx.gasPrice),
                            tx.gasToken,
                            tx.refundReceiver,
                            Solidity.UInt256(tx.nonce)
                        )
                    )
                )
            ).result()!!
        ).param0.byteArray
        println(transactionHash.toHex())

        val signature = key.sign(transactionHash)

        // Our safe transaction hash or contract transactionHash, corresponds to the hash we have signed with our
        // private key. We submit it along with the address of the signer (called sender in our class), which is our EOA.
        val confirmation = ServiceTransaction(
            to = tx.to,
            value = tx.value,
            data = tx.data,
            operation = tx.operation,
            gasToken = tx.gasToken,
            safeTxGas = tx.safeTxGas,
            baseGas = tx.baseGas,
            gasPrice = tx.gasPrice,
            refundReceiver = tx.refundReceiver,
            nonce = tx.nonce,
            contractTransactionHash = transactionHash.toHex(),
            sender = Solidity.Address(key.address.asBigInteger()),
            signature = signature.toSignatureString()
        )

        // After successfully submitting the transaction, this should be visible already in the safe app after a short delay
        transactionRespository.submitTransaction(confirmation, safe)
    }

    private fun ECDSASignature.toSignatureString() =
        r.toString(16).padStart(64, '0').substring(0, 64) +
                s.toString(16).padStart(64, '0').substring(0, 64) +
                v.toString(16).padStart(2, '0')
}
