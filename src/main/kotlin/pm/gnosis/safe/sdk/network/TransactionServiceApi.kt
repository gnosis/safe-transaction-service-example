package pm.gnosis.safe.sdk.network

import pm.gnosis.safe.sdk.network.models.Page
import pm.gnosis.safe.sdk.network.models.TransactionDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TransactionServiceApi {

    @GET("v1/safes/{address}/all-transactions/")
    suspend fun loadTransactions(@Path("address") address: String): Page<TransactionDto>

    companion object {
        const val BASE_URL = "https://safe-transaction.staging.gnosisdev.com/api/"
    }
}