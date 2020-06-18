package pm.gnosis.safe.sdk

import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin
import pm.gnosis.safe.sdk.di.networkModules
import pm.gnosis.safe.sdk.transactions.TransactionDispatcher

fun main() {
    startKoin {
        printLogger()
        modules(networkModules)
    }

    runBlocking {
        TransactionDispatcher().submit()
    }
}

