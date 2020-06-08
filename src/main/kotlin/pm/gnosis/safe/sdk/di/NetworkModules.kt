package pm.gnosis.safe.sdk.di

import org.koin.dsl.module
import pm.gnosis.safe.sdk.network.api.TransactionServiceApi
import pm.gnosis.safe.sdk.network.repositories.TransactionRepository
import retrofit2.Retrofit

val networkModules = module {
    single {
        Retrofit.Builder()
            .baseUrl(TransactionServiceApi.BASE_URL)
            .build()
            .create(TransactionServiceApi::class.java)
    }

    single {
        TransactionRepository(get())
    }
}