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
        val key = KeyPair.fromPrivate(environment.privateKey.hexToByteArray())
        println(key.address.toHex()) // public ethereum address of the EOA

        val safe = "0xd6f5Bef6bb4acD235CF85c0ce196316d10785d67".asEthereumAddress()!!


        val nonce = SafeAbi.Nonce.decode(
            ethereumRepository.request(
                EthCall(transaction = Transaction(safe, data = SafeAbi.Nonce.encode()))
            ).result()!!
        ).param0.value
        println(nonce)


        val tx = SafeTransaction(
            to = "0xBe8C10Dbf4c6148f9834C56C3331f8191f355552".asEthereumAddress()!!,
            value = BigInteger.TEN,
            data = "0x",
            nonce = nonce
        )
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

        transactionRespository.submitTransaction(confirmation, safe)
    }

    private fun ECDSASignature.toSignatureString() =
        r.toString(16).padStart(64, '0').substring(0, 64) +
                s.toString(16).padStart(64, '0').substring(0, 64) +
                v.toString(16).padStart(2, '0')
}