import org.koin.core.KoinComponent
import org.koin.core.inject
import pm.gnosis.safe.sdk.network.repositories.TransactionRepository

class TransactionDispatcher : KoinComponent {

    private val transactionRepository by inject<TransactionRepository>()

    init {
        transactionRepository.test()
    }
}