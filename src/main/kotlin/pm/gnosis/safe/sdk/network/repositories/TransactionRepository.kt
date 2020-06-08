package pm.gnosis.safe.sdk.network.repositories

import pm.gnosis.safe.sdk.network.TransactionServiceApi

class TransactionRepository(
    private val transactionServiceApi: TransactionServiceApi
) {
    fun test() = print("TransactionRepository")
}