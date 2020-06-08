package pm.gnosis.safe.sdk.network.api

import pm.gnosis.safe.sdk.network.models.TransactionDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionServiceApi {

    @POST("v1/safes/{address}/transactions/")
    suspend fun submitTransactions(
        @Path("address") address: String,
        @Body transactionDto: TransactionDto
    ): TransactionDto

    companion object {
        const val BASE_URL = "https://safe-transaction.staging.gnosisdev.com/api/"
    }
}