package pm.gnosis.safe.sdk.network.repositories

import pm.gnosis.ethereum.EthereumRepository
import pm.gnosis.model.Solidity
import pm.gnosis.safe.sdk.crypto.utils.asEthereumAddressChecksumString
import pm.gnosis.safe.sdk.network.api.TransactionServiceApi
import pm.gnosis.safe.sdk.network.models.TransactionDto

class TransactionRepository(
    private val transactionServiceApi: TransactionServiceApi,
    private val ethereumRepository: EthereumRepository
) {

    suspend fun submitTransaction(
        safe: Solidity.Address,
        transaction: TransactionDto
    ) = transactionServiceApi.submitTransactions(safe.asEthereumAddressChecksumString(), transaction)
}