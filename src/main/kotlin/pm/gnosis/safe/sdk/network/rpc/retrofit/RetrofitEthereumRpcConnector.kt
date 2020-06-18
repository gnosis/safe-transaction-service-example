package pm.gnosis.safe.sdk.network.rpc.retrofit

import pm.gnosis.safe.sdk.network.rpc.EthereumRpcConnector
import pm.gnosis.ethereum.rpc.models.*
import pm.gnosis.safe.sdk.network.rpc.retrofit.RetrofitEthereumRpcApi

class RetrofitEthereumRpcConnector(private val api: RetrofitEthereumRpcApi) : EthereumRpcConnector {

    override suspend fun receipt(jsonRpcRequest: JsonRpcRequest): JsonRpcTransactionReceiptResult {
        return api.receipt(jsonRpcRequest)
    }

    override suspend fun block(jsonRpcRequest: JsonRpcRequest): JsonRpcBlockResult {
        return api.block(jsonRpcRequest)
    }

    override suspend fun transaction(jsonRpcRequest: JsonRpcRequest): JsonRpcTransactionResult {
        return api.transaction(jsonRpcRequest)
    }

    override suspend fun post(jsonRpcRequest: JsonRpcRequest): JsonRpcResult {
        return api.post(jsonRpcRequest)
    }

    override suspend fun post(jsonRpcRequest: Collection<JsonRpcRequest>): Collection<JsonRpcResult> {
        return api.post(jsonRpcRequest)
    }

}
