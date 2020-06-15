package pm.gnosis.safe.sdk.transactions

import okio.ByteString.Companion.decodeHex
import pm.gnosis.safe.sdk.crypto.KeyGenerator

class TransactionBuilder {

    fun sign() {
        val masterNode = KeyGenerator.masterNode("".decodeHex())
        val derivedAccount = masterNode.derive("m/44'/60'/0'")
        val derivedBip32 = masterNode.derive("m/44'/60'/0'/0")


    }
}