package pm.gnosis.safe.sdk.network.models

import java.math.BigInteger
import pm.gnosis.model.Solidity

data class TransactionDto(
    val safe: Solidity.Address,
    val to: Solidity.Address? = null,
    val value: BigInteger,
    val data: String? = null,
    val operation: Operation,
    val gasToken: Solidity.Address? = null,
    val safeTxGas: BigInteger,
    val baseGas: BigInteger,
    val gasPrice: BigInteger,
    val refundReceiver: Solidity.Address? = null,
    val nonce: BigInteger? = null,
    val contractTransactionHash: String,
    val sender: Solidity.Address,
    val signature: String? = null,
    val origin: String? = null
)

enum class Operation(val id: Int) {
    CALL(0),
    DELEGATE(1)
}