package pm.gnosis.safe.sdk.transactions

import okio.ByteString.Companion.decodeHex
import pm.gnosis.safe.sdk.crypto.KeyGenerator
import pm.gnosis.safe.sdk.crypto.utils.toHexString

class TransactionBuilder {

    fun sign(seed: String) {
        val masterNode = KeyGenerator.masterNode(seed.decodeHex())
        println(masterNode.keyPair.pubKey.toHexString())
        val derivedAccount = masterNode.derive("m/44'/60'/0'")
        val derivedBip32 = masterNode.derive("m/44'/60'/0'/0")
    }
}