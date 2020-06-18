package pm.gnosis.safe.sdk.transactions

import org.koin.core.KoinComponent
import org.koin.core.inject
import pm.gnosis.safe.sdk.crypto.utils.asEthereumAddress
import pm.gnosis.safe.sdk.network.repositories.TransactionRepository
import pm.gnosis.safe.sdk.safe.SafeManager

class TransactionDispatcher : KoinComponent {

    private val transactionRepository by inject<TransactionRepository>()
    private val safeManager by inject<SafeManager>()

    suspend fun submit() {
        transactionRepository
    }
}