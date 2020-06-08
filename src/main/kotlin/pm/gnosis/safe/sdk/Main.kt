package pm.gnosis.safe.sdk

import pm.gnosis.safe.sdk.transactions.TransactionDispatcher
import org.koin.core.context.startKoin
import pm.gnosis.safe.sdk.di.networkModules
import pm.gnosis.safe.sdk.transactions.TransactionBuilder

fun main() {
    startKoin {
        printLogger()
        modules(networkModules)
    }
    val transaction = TransactionBuilder()
    TransactionDispatcher()
}

