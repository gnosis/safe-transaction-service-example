package pm.gnosis.safe.sdk.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import pm.gnosis.ethereum.EthereumRepository
import pm.gnosis.safe.sdk.Environment
import pm.gnosis.safe.sdk.network.rpc.RpcEthereumRepository
import pm.gnosis.safe.sdk.network.api.TransactionServiceApi
import pm.gnosis.safe.sdk.network.repositories.TransactionRepository
import pm.gnosis.safe.sdk.network.rpc.EthereumRpcConnector
import pm.gnosis.safe.sdk.network.rpc.retrofit.RetrofitEthereumRpcApi
import pm.gnosis.safe.sdk.network.rpc.retrofit.RetrofitEthereumRpcConnector
import retrofit2.Retrofit
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
        println("Seed: $seed")
        println("Safe: $safe")
        println("Infura: $infura")
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
            .build()
            .create(TransactionServiceApi::class.java)
    }

    single { TransactionRepository(get(), get()) }

    single<EthereumRepository> { RpcEthereumRepository(get()) }

    single<EthereumRpcConnector> { RetrofitEthereumRpcConnector(get()) }

    single<RetrofitEthereumRpcApi> {
        val environment: Environment = get()
        val client = OkHttpClient.Builder().apply {
            addInterceptor {
                val request = it.request()
                val builder = request.url().newBuilder()
                val url = builder.addPathSegment(environment.infuraKey).build()
                it.proceed(request.newBuilder().url(url).build())
            }
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }.build()

        Retrofit.Builder()
            .client(client)
            .baseUrl("https://rinkeby.infura.io/v3/")
//                .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(RetrofitEthereumRpcApi::class.java)
    }
}