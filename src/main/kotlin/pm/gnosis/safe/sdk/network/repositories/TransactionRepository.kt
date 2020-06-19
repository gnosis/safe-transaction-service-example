package pm.gnosis.safe.sdk.network.repositories

import pm.gnosis.ethereum.EthereumRepository
import pm.gnosis.model.Solidity
import pm.gnosis.safe.sdk.crypto.utils.asEthereumAddressChecksumString
import pm.gnosis.safe.sdk.network.api.TransactionServiceApi
import pm.gnosis.safe.sdk.network.models.SafeTransaction
import pm.gnosis.safe.sdk.network.models.ServiceTransaction

class TransactionRepository(
    private val transactionServiceApi: TransactionServiceApi,
    private val ethereumRepository: EthereumRepository
) {

    suspend fun submitTransaction(
        data: ServiceTransaction,
        address: Solidity.Address
    ) = transactionServiceApi.submitTransactions(address.asEthereumAddressChecksumString(), data)

    suspend fun submitSomething(safe: Solidity.Address) = ethereumRepository.getBalance(safe)
}