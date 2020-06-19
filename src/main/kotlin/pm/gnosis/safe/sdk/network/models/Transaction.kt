package pm.gnosis.safe.sdk.network.models

import com.squareup.moshi.JsonClass
import pm.gnosis.model.Solidity
import pm.gnosis.safe.sdk.network.DecimalNumber
import java.math.BigInteger

data class Transaction(
    val address: Solidity.Address,
    val value: Wei? = null,
    var gas: BigInteger? = null,
    var gasPrice: BigInteger? = null,
    val data: String? = null,
    var nonce: BigInteger? = null,
    val chainId: Int = CHAIN_ID_ANY
) {
    fun signable() = nonce != null && gas != null && gasPrice != null

    companion object {
        const val CHAIN_ID_ANY = 0
    }
}

data class SafeTransaction(
    val to: Solidity.Address,
    val value: BigInteger,
    val data: String,
    val nonce: BigInteger,
    val operation: BigInteger = BigInteger.ZERO,
    val safeTxGas: BigInteger = BigInteger.ZERO,
    val baseGas: BigInteger = BigInteger.ZERO,
    val gasPrice: BigInteger = BigInteger.ZERO,
    val gasToken: Solidity.Address = Solidity.Address(BigInteger.ZERO),
    val refundReceiver: Solidity.Address = Solidity.Address(BigInteger.ZERO)
)

@JsonClass(generateAdapter = true)
data class ServiceTransaction(
    val to: Solidity.Address,
    @DecimalNumber val value: BigInteger,
    val data: String,
    @DecimalNumber val nonce: BigInteger,
    @DecimalNumber val operation: BigInteger,
    @DecimalNumber val safeTxGas: BigInteger,
    @DecimalNumber val baseGas: BigInteger,
    @DecimalNumber val gasPrice: BigInteger,
    val gasToken: Solidity.Address,
    val refundReceiver: Solidity.Address,
    val contractTransactionHash: String,
    val sender: Solidity.Address,
    val signature: String
)