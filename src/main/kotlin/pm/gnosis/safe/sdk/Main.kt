package pm.gnosis.safe.sdk

import org.koin.core.context.startKoin
import pm.gnosis.safe.sdk.di.networkModules
import pm.gnosis.safe.sdk.transactions.TransactionBuilder
import java.io.File

fun main() {
    startKoin {
        printLogger()
        modules(networkModules)
    }
    with(TransactionBuilder()) {
        val (seed, safe) = File(".env.private_key").let { file ->
            file.useLines {
                it.windowed(2, 2, false).first().let {
                    it[0] to it[1]
                }
            }
        }

        println("Seed: $seed")
        println("Safe: $safe")
        sign(seed)
    }
}

