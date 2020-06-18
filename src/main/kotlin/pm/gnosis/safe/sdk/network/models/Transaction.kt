package pm.gnosis.safe.sdk.network.models

import pm.gnosis.model.Solidity
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


data class TransactionDto(val nonce: BigInteger?)