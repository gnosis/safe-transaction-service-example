package pm.gnosis.safe.sdk.network.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson
import pm.gnosis.safe.sdk.network.models.Operation

class OperationEnumAdapter {
    @ToJson
    fun toJson(operation: Operation): String = operation.id.toString()

    @FromJson
    fun fromJson(operation: String): Operation =
        when (operation) {
            "0" -> Operation.CALL
            "1" -> Operation.DELEGATE
            else -> throw JsonDataException("Unsupported operation value: \"$operation\"")
        }
}
