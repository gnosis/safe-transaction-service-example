package pm.gnosis.safe.sdk

import TransactionDispatcher
import org.koin.core.context.startKoin
import pm.gnosis.safe.sdk.di.networkModules

fun main() {
    startKoin {
        modules(networkModules)
    }
    TransactionDispatcher()
}

