package pm.gnosis.safe.sdk.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pm.gnosis.ethereum.EthereumRepository
import pm.gnosis.safe.sdk.Environment
import pm.gnosis.safe.sdk.network.MoshiBuilderFactory
import pm.gnosis.safe.sdk.network.rpc.RpcEthereumRepository
import pm.gnosis.safe.sdk.network.api.TransactionServiceApi
import pm.gnosis.safe.sdk.network.repositories.TransactionRepository
import pm.gnosis.safe.sdk.network.rpc.EthereumRpcConnector
import pm.gnosis.safe.sdk.network.rpc.retrofit.RetrofitEthereumRpcApi
import pm.gnosis.safe.sdk.network.rpc.retrofit.RetrofitEthereumRpcConnector
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

val networkModules = module {

    single {
        val (seed, safe, infura) = File(".env.private_key").let { file ->
            file.useLines {
                it.windowed(3, 3, false).first().let {
                    Triple(it[0], it[1], it[2])
                }
            }
        }
        Environment(safe, seed, infura)
    }

    single {
        val client = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            ).build()

        Retrofit.Builder()
            .client(client)
            .baseUrl(TransactionServiceApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
            .create(TransactionServiceApi::class.java)
    }

    single { TransactionRepository(get(), get()) }

    single<EthereumRepository> { RpcEthereumRepository(get()) }

    single<EthereumRpcConnector> { RetrofitEthereumRpcConnector(get()) }

    single<RetrofitEthereumRpcApi> {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://rinkeby.infura.io/v3/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
            .create(RetrofitEthereumRpcApi::class.java)
    }

    single {
        MoshiBuilderFactory
            .makeMoshiBuilder().build()
    }

    single {
        OkHttpClient.Builder().apply {
            addInterceptor {
                val request = it.request()
                val builder = request.url().newBuilder()
                val url = builder.addPathSegment(get<Environment>().infuraKey).build()
                it.proceed(request.newBuilder().url(url).build())
            }
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }.build()
    }
}