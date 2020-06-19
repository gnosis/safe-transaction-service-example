package pm.gnosis.safe.sdk.network.api

import pm.gnosis.safe.sdk.network.models.ServiceTransaction
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionServiceApi {

    @POST("v1/safes/{address}/transactions/")
    suspend fun submitTransactions(
        @Path("address") address: String,
        @Body data: ServiceTransaction
    )

    companion object {
        const val BASE_URL = "https://safe-transaction.rinkeby.gnosis.io/api/"
    }
}