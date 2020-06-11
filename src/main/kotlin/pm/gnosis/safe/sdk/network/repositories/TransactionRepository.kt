package pm.gnosis.safe.sdk.network.repositories

import pm.gnosis.model.Solidity
import pm.gnosis.safe.sdk.network.api.TransactionServiceApi
import pm.gnosis.safe.sdk.network.models.TransactionDto

class TransactionRepository(
    private val transactionServiceApi: TransactionServiceApi
) {
//
//    suspend fun submitTransaction(
//        safe: Solidity.Address,
//        transaction: TransactionDto
//    ) = transactionServiceApi.submitTransactions()
}