package pm.gnosis.safe.sdk.contracts

import java.math.BigInteger
import kotlin.String
import kotlin.collections.List
import pm.gnosis.model.Solidity
import pm.gnosis.model.SolidityBase
import pm.gnosis.utils.BigIntegerUtils

class SafeAbi {
    object NAME {
        const val METHOD_ID: String = "a3f4df7e"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = Solidity.String.DECODER.decode(source.subData(arg0Offset))

            return Return(arg0)
        }

        data class Return(
            val param0: Solidity.String
        )
    }

    object VERSION {
        const val METHOD_ID: String = "ffa1ad74"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = Solidity.String.DECODER.decode(source.subData(arg0Offset))

            return Return(arg0)
        }

        data class Return(
            val param0: Solidity.String
        )
    }

    object AddOwnerWithThreshold {
        const val METHOD_ID: String = "0d582f13"

        fun encode(owner: Solidity.Address, _threshold: Solidity.UInt256): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(owner,
                _threshold)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)

            return Arguments(arg0, arg1)
        }

        data class Arguments(
            val owner: Solidity.Address,
            val _threshold: Solidity.UInt256
        )
    }

    object ApprovedHashes {
        const val METHOD_ID: String = "7d832974"

        fun encode(arg1: Solidity.Address, arg2: Solidity.Bytes32): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(arg1,
                arg2)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.UInt256.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.Bytes32.DECODER.decode(source)

            return Arguments(arg0, arg1)
        }

        data class Return(
            val param0: Solidity.UInt256
        )

        data class Arguments(
            val param0: Solidity.Address,
            val param1: Solidity.Bytes32
        )
    }

    object ChangeMasterCopy {
        const val METHOD_ID: String = "7de7edef"

        fun encode(_masterCopy: Solidity.Address): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(_masterCopy)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Arguments(
            val _mastercopy: Solidity.Address
        )
    }

    object ChangeThreshold {
        const val METHOD_ID: String = "694e80c3"

        fun encode(_threshold: Solidity.UInt256): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(_threshold)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.UInt256.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Arguments(
            val _threshold: Solidity.UInt256
        )
    }

    object DisableModule {
        const val METHOD_ID: String = "e009cfde"

        fun encode(prevModule: Solidity.Address, module: Solidity.Address): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(prevModule,
                module)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0, arg1)
        }

        data class Arguments(
            val prevmodule: Solidity.Address,
            val module: Solidity.Address
        )
    }

    object DomainSeparator {
        const val METHOD_ID: String = "f698da25"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bytes32.DECODER.decode(source)

            return Return(arg0)
        }

        data class Return(
            val param0: Solidity.Bytes32
        )
    }

    object EnableModule {
        const val METHOD_ID: String = "610b5925"

        fun encode(module: Solidity.Address): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(module)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Arguments(
            val module: Solidity.Address
        )
    }

    object ExecTransactionFromModule {
        const val METHOD_ID: String = "468721a7"

        fun encode(
            to: Solidity.Address,
            value: Solidity.UInt256,
            data: Solidity.Bytes,
            operation: Solidity.UInt8
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(to,
                value, data, operation)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bool.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg2 = Solidity.Bytes.DECODER.decode(source.subData(arg2Offset))
            val arg3 = Solidity.UInt8.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2, arg3)
        }

        data class Return(
            val success: Solidity.Bool
        )

        data class Arguments(
            val to: Solidity.Address,
            val value: Solidity.UInt256,
            val data: Solidity.Bytes,
            val operation: Solidity.UInt8
        )
    }

    object ExecTransactionFromModuleReturnData {
        const val METHOD_ID: String = "5229073f"

        fun encode(
            to: Solidity.Address,
            value: Solidity.UInt256,
            data: Solidity.Bytes,
            operation: Solidity.UInt8
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(to,
                value, data, operation)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bool.DECODER.decode(source)
            val arg1Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg1 = Solidity.Bytes.DECODER.decode(source.subData(arg1Offset))

            return Return(arg0, arg1)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg2 = Solidity.Bytes.DECODER.decode(source.subData(arg2Offset))
            val arg3 = Solidity.UInt8.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2, arg3)
        }

        data class Return(
            val success: Solidity.Bool,
            val returndata: Solidity.Bytes
        )

        data class Arguments(
            val to: Solidity.Address,
            val value: Solidity.UInt256,
            val data: Solidity.Bytes,
            val operation: Solidity.UInt8
        )
    }

    object GetModules {
        const val METHOD_ID: String = "b2494df3"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = SolidityBase.Vector.Decoder(Solidity.Address.DECODER).decode(source.subData(arg0Offset))

            return Return(arg0)
        }

        data class Return(
            val param0: SolidityBase.Vector<Solidity.Address>
        )
    }

    object GetModulesPaginated {
        const val METHOD_ID: String = "cc2f8452"

        fun encode(start: Solidity.Address, pageSize: Solidity.UInt256): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(start,
                pageSize)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = SolidityBase.Vector.Decoder(Solidity.Address.DECODER).decode(source.subData(arg0Offset))
            val arg1 = Solidity.Address.DECODER.decode(source)

            return Return(arg0, arg1)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)

            return Arguments(arg0, arg1)
        }

        data class Return(
            val array: SolidityBase.Vector<Solidity.Address>,
            val next: Solidity.Address
        )

        data class Arguments(
            val start: Solidity.Address,
            val pagesize: Solidity.UInt256
        )
    }

    object GetOwners {
        const val METHOD_ID: String = "a0e67e2b"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = SolidityBase.Vector.Decoder(Solidity.Address.DECODER).decode(source.subData(arg0Offset))

            return Return(arg0)
        }

        data class Return(
            val param0: SolidityBase.Vector<Solidity.Address>
        )
    }

    object GetThreshold {
        const val METHOD_ID: String = "e75235b8"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.UInt256.DECODER.decode(source)

            return Return(arg0)
        }

        data class Return(
            val param0: Solidity.UInt256
        )
    }

    object IsModuleEnabled {
        const val METHOD_ID: String = "2d9ad53d"

        fun encode(module: Solidity.Address): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(module)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bool.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Return(
            val param0: Solidity.Bool
        )

        data class Arguments(
            val module: Solidity.Address
        )
    }

    object IsOwner {
        const val METHOD_ID: String = "2f54bf6e"

        fun encode(owner: Solidity.Address): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(owner)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bool.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Return(
            val param0: Solidity.Bool
        )

        data class Arguments(
            val owner: Solidity.Address
        )
    }

    object Nonce {
        const val METHOD_ID: String = "affed0e0"

        fun encode(): String {
            return "0x" + METHOD_ID
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.UInt256.DECODER.decode(source)

            return Return(arg0)
        }

        data class Return(
            val param0: Solidity.UInt256
        )
    }

    object RemoveOwner {
        const val METHOD_ID: String = "f8dc5dd9"

        fun encode(
            prevOwner: Solidity.Address,
            owner: Solidity.Address,
            _threshold: Solidity.UInt256
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(prevOwner,
                owner, _threshold)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.Address.DECODER.decode(source)
            val arg2 = Solidity.UInt256.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2)
        }

        data class Arguments(
            val prevowner: Solidity.Address,
            val owner: Solidity.Address,
            val _threshold: Solidity.UInt256
        )
    }

    object SetFallbackHandler {
        const val METHOD_ID: String = "f08a0323"

        fun encode(handler: Solidity.Address): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(handler)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Arguments(
            val handler: Solidity.Address
        )
    }

    object SignedMessages {
        const val METHOD_ID: String = "5ae6bd37"

        fun encode(arg1: Solidity.Bytes32): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(arg1)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.UInt256.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bytes32.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Return(
            val param0: Solidity.UInt256
        )

        data class Arguments(
            val param0: Solidity.Bytes32
        )
    }

    object SwapOwner {
        const val METHOD_ID: String = "e318b52b"

        fun encode(
            prevOwner: Solidity.Address,
            oldOwner: Solidity.Address,
            newOwner: Solidity.Address
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(prevOwner,
                oldOwner, newOwner)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.Address.DECODER.decode(source)
            val arg2 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2)
        }

        data class Arguments(
            val prevowner: Solidity.Address,
            val oldowner: Solidity.Address,
            val newowner: Solidity.Address
        )
    }

    object Setup {
        const val METHOD_ID: String = "b63e800d"

        fun encode(
            _owners: SolidityBase.Vector<Solidity.Address>,
            _threshold: Solidity.UInt256,
            to: Solidity.Address,
            data: Solidity.Bytes,
            fallbackHandler: Solidity.Address,
            paymentToken: Solidity.Address,
            payment: Solidity.UInt256,
            paymentReceiver: Solidity.Address
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(_owners,
                _threshold, to, data, fallbackHandler, paymentToken, payment, paymentReceiver)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = SolidityBase.Vector.Decoder(Solidity.Address.DECODER).decode(source.subData(arg0Offset))
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2 = Solidity.Address.DECODER.decode(source)
            val arg3Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg3 = Solidity.Bytes.DECODER.decode(source.subData(arg3Offset))
            val arg4 = Solidity.Address.DECODER.decode(source)
            val arg5 = Solidity.Address.DECODER.decode(source)
            val arg6 = Solidity.UInt256.DECODER.decode(source)
            val arg7 = Solidity.Address.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7)
        }

        data class Arguments(
            val _owners: SolidityBase.Vector<Solidity.Address>,
            val _threshold: Solidity.UInt256,
            val to: Solidity.Address,
            val data: Solidity.Bytes,
            val fallbackhandler: Solidity.Address,
            val paymenttoken: Solidity.Address,
            val payment: Solidity.UInt256,
            val paymentreceiver: Solidity.Address
        )
    }

    object ExecTransaction {
        const val METHOD_ID: String = "6a761202"

        fun encode(
            to: Solidity.Address,
            value: Solidity.UInt256,
            data: Solidity.Bytes,
            operation: Solidity.UInt8,
            safeTxGas: Solidity.UInt256,
            baseGas: Solidity.UInt256,
            gasPrice: Solidity.UInt256,
            gasToken: Solidity.Address,
            refundReceiver: Solidity.Address,
            signatures: Solidity.Bytes
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(to,
                value, data, operation, safeTxGas, baseGas, gasPrice, gasToken, refundReceiver,
                signatures)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bool.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg2 = Solidity.Bytes.DECODER.decode(source.subData(arg2Offset))
            val arg3 = Solidity.UInt8.DECODER.decode(source)
            val arg4 = Solidity.UInt256.DECODER.decode(source)
            val arg5 = Solidity.UInt256.DECODER.decode(source)
            val arg6 = Solidity.UInt256.DECODER.decode(source)
            val arg7 = Solidity.Address.DECODER.decode(source)
            val arg8 = Solidity.Address.DECODER.decode(source)
            val arg9Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg9 = Solidity.Bytes.DECODER.decode(source.subData(arg9Offset))

            return Arguments(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
        }

        data class Return(
            val success: Solidity.Bool
        )

        data class Arguments(
            val to: Solidity.Address,
            val value: Solidity.UInt256,
            val data: Solidity.Bytes,
            val operation: Solidity.UInt8,
            val safetxgas: Solidity.UInt256,
            val basegas: Solidity.UInt256,
            val gasprice: Solidity.UInt256,
            val gastoken: Solidity.Address,
            val refundreceiver: Solidity.Address,
            val signatures: Solidity.Bytes
        )
    }

    object RequiredTxGas {
        const val METHOD_ID: String = "c4ca3a9c"

        fun encode(
            to: Solidity.Address,
            value: Solidity.UInt256,
            data: Solidity.Bytes,
            operation: Solidity.UInt8
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(to,
                value, data, operation)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.UInt256.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg2 = Solidity.Bytes.DECODER.decode(source.subData(arg2Offset))
            val arg3 = Solidity.UInt8.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2, arg3)
        }

        data class Return(
            val param0: Solidity.UInt256
        )

        data class Arguments(
            val to: Solidity.Address,
            val value: Solidity.UInt256,
            val data: Solidity.Bytes,
            val operation: Solidity.UInt8
        )
    }

    object ApproveHash {
        const val METHOD_ID: String = "d4d9bdcd"

        fun encode(hashToApprove: Solidity.Bytes32): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(hashToApprove)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bytes32.DECODER.decode(source)

            return Arguments(arg0)
        }

        data class Arguments(
            val hashtoapprove: Solidity.Bytes32
        )
    }

    object SignMessage {
        const val METHOD_ID: String = "85a5affe"

        fun encode(_data: Solidity.Bytes): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(_data)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = Solidity.Bytes.DECODER.decode(source.subData(arg0Offset))

            return Arguments(arg0)
        }

        data class Arguments(
            val _data: Solidity.Bytes
        )
    }

    object IsValidSignature {
        const val METHOD_ID: String = "20c13b0b"

        fun encode(_data: Solidity.Bytes, _signature: Solidity.Bytes): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(_data,
                _signature)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bytes4.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = Solidity.Bytes.DECODER.decode(source.subData(arg0Offset))
            val arg1Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg1 = Solidity.Bytes.DECODER.decode(source.subData(arg1Offset))

            return Arguments(arg0, arg1)
        }

        data class Return(
            val param0: Solidity.Bytes4
        )

        data class Arguments(
            val _data: Solidity.Bytes,
            val _signature: Solidity.Bytes
        )
    }

    object GetMessageHash {
        const val METHOD_ID: String = "0a1028c4"

        fun encode(message: Solidity.Bytes): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(message)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bytes32.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = Solidity.Bytes.DECODER.decode(source.subData(arg0Offset))

            return Arguments(arg0)
        }

        data class Return(
            val param0: Solidity.Bytes32
        )

        data class Arguments(
            val message: Solidity.Bytes
        )
    }

    object EncodeTransactionData {
        const val METHOD_ID: String = "e86637db"

        fun encode(
            to: Solidity.Address,
            value: Solidity.UInt256,
            data: Solidity.Bytes,
            operation: Solidity.UInt8,
            safeTxGas: Solidity.UInt256,
            baseGas: Solidity.UInt256,
            gasPrice: Solidity.UInt256,
            gasToken: Solidity.Address,
            refundReceiver: Solidity.Address,
            _nonce: Solidity.UInt256
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(to,
                value, data, operation, safeTxGas, baseGas, gasPrice, gasToken, refundReceiver,
                _nonce)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg0 = Solidity.Bytes.DECODER.decode(source.subData(arg0Offset))

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg2 = Solidity.Bytes.DECODER.decode(source.subData(arg2Offset))
            val arg3 = Solidity.UInt8.DECODER.decode(source)
            val arg4 = Solidity.UInt256.DECODER.decode(source)
            val arg5 = Solidity.UInt256.DECODER.decode(source)
            val arg6 = Solidity.UInt256.DECODER.decode(source)
            val arg7 = Solidity.Address.DECODER.decode(source)
            val arg8 = Solidity.Address.DECODER.decode(source)
            val arg9 = Solidity.UInt256.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
        }

        data class Return(
            val param0: Solidity.Bytes
        )

        data class Arguments(
            val to: Solidity.Address,
            val value: Solidity.UInt256,
            val data: Solidity.Bytes,
            val operation: Solidity.UInt8,
            val safetxgas: Solidity.UInt256,
            val basegas: Solidity.UInt256,
            val gasprice: Solidity.UInt256,
            val gastoken: Solidity.Address,
            val refundreceiver: Solidity.Address,
            val _nonce: Solidity.UInt256
        )
    }

    object GetTransactionHash {
        const val METHOD_ID: String = "d8d11f78"

        fun encode(
            to: Solidity.Address,
            value: Solidity.UInt256,
            data: Solidity.Bytes,
            operation: Solidity.UInt8,
            safeTxGas: Solidity.UInt256,
            baseGas: Solidity.UInt256,
            gasPrice: Solidity.UInt256,
            gasToken: Solidity.Address,
            refundReceiver: Solidity.Address,
            _nonce: Solidity.UInt256
        ): String {
            return "0x" + METHOD_ID + pm.gnosis.model.SolidityBase.encodeFunctionArguments(to,
                value, data, operation, safeTxGas, baseGas, gasPrice, gasToken, refundReceiver,
                _nonce)
        }

        fun decode(data: String): Return {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Bytes32.DECODER.decode(source)

            return Return(arg0)
        }

        fun decodeArguments(data: String): Arguments {
            val source = SolidityBase.PartitionData.of(data)

            // Add decoders
            val arg0 = Solidity.Address.DECODER.decode(source)
            val arg1 = Solidity.UInt256.DECODER.decode(source)
            val arg2Offset = BigIntegerUtils.exact(BigInteger(source.consume(), 16))
            val arg2 = Solidity.Bytes.DECODER.decode(source.subData(arg2Offset))
            val arg3 = Solidity.UInt8.DECODER.decode(source)
            val arg4 = Solidity.UInt256.DECODER.decode(source)
            val arg5 = Solidity.UInt256.DECODER.decode(source)
            val arg6 = Solidity.UInt256.DECODER.decode(source)
            val arg7 = Solidity.Address.DECODER.decode(source)
            val arg8 = Solidity.Address.DECODER.decode(source)
            val arg9 = Solidity.UInt256.DECODER.decode(source)

            return Arguments(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9)
        }

        data class Return(
            val param0: Solidity.Bytes32
        )

        data class Arguments(
            val to: Solidity.Address,
            val value: Solidity.UInt256,
            val data: Solidity.Bytes,
            val operation: Solidity.UInt8,
            val safetxgas: Solidity.UInt256,
            val basegas: Solidity.UInt256,
            val gasprice: Solidity.UInt256,
            val gastoken: Solidity.Address,
            val refundreceiver: Solidity.Address,
            val _nonce: Solidity.UInt256
        )
    }

    object Events {
        object AddedOwner {
            const val EVENT_ID: String =
                "9465fa0c962cc76958e6373a993326400c1c94f8be2fe3a952adfa7f60b2ea26"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Address.DECODER.decode(source)
                return Arguments(arg0)
            }

            data class Arguments(
                val owner: Solidity.Address
            )
        }

        object ApproveHash {
            const val EVENT_ID: String =
                "f2a0eb156472d1440255b0d7c1e19cc07115d1051fe605b0dce69acfec884d9c"

            fun decode(topics: List<String>): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")
                val source1 = SolidityBase.PartitionData.of(topics[1])
                val t1 = Solidity.Bytes32.DECODER.decode(source1)
                val source2 = SolidityBase.PartitionData.of(topics[2])
                val t2 = Solidity.Address.DECODER.decode(source2)
                return Arguments(t1, t2)
            }

            data class Arguments(
                val approvedhash: Solidity.Bytes32,
                val owner: Solidity.Address
            )
        }

        object ChangedMasterCopy {
            const val EVENT_ID: String =
                "75e41bc35ff1bf14d81d1d2f649c0084a0f974f9289c803ec9898eeec4c8d0b8"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Address.DECODER.decode(source)
                return Arguments(arg0)
            }

            data class Arguments(
                val mastercopy: Solidity.Address
            )
        }

        object ChangedThreshold {
            const val EVENT_ID: String =
                "610f7ff2b304ae8903c3de74c60c6ab1f7d6226b3f52c5161905bb5ad4039c93"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.UInt256.DECODER.decode(source)
                return Arguments(arg0)
            }

            data class Arguments(
                val threshold: Solidity.UInt256
            )
        }

        object DisabledModule {
            const val EVENT_ID: String =
                "aab4fa2b463f581b2b32cb3b7e3b704b9ce37cc209b5fb4d77e593ace4054276"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Address.DECODER.decode(source)
                return Arguments(arg0)
            }

            data class Arguments(
                val module: Solidity.Address
            )
        }

        object EnabledModule {
            const val EVENT_ID: String =
                "ecdf3a3effea5783a3c4c2140e677577666428d44ed9d474a0b3a4c9943f8440"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Address.DECODER.decode(source)
                return Arguments(arg0)
            }

            data class Arguments(
                val module: Solidity.Address
            )
        }

        object ExecutionFailure {
            const val EVENT_ID: String =
                "23428b18acfb3ea64b08dc0c1d296ea9c09702c09083ca5272e64d115b687d23"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Bytes32.DECODER.decode(source)
                val arg1 = Solidity.UInt256.DECODER.decode(source)
                return Arguments(arg0, arg1)
            }

            data class Arguments(
                val txhash: Solidity.Bytes32,
                val payment: Solidity.UInt256
            )
        }

        object ExecutionFromModuleFailure {
            const val EVENT_ID: String =
                "acd2c8702804128fdb0db2bb49f6d127dd0181c13fd45dbfe16de0930e2bd375"

            fun decode(topics: List<String>): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")
                val source1 = SolidityBase.PartitionData.of(topics[1])
                val t1 = Solidity.Address.DECODER.decode(source1)
                return Arguments(t1)
            }

            data class Arguments(
                val module: Solidity.Address
            )
        }

        object ExecutionFromModuleSuccess {
            const val EVENT_ID: String =
                "6895c13664aa4f67288b25d7a21d7aaa34916e355fb9b6fae0a139a9085becb8"

            fun decode(topics: List<String>): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")
                val source1 = SolidityBase.PartitionData.of(topics[1])
                val t1 = Solidity.Address.DECODER.decode(source1)
                return Arguments(t1)
            }

            data class Arguments(
                val module: Solidity.Address
            )
        }

        object ExecutionSuccess {
            const val EVENT_ID: String =
                "442e715f626346e8c54381002da614f62bee8d27386535b2521ec8540898556e"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Bytes32.DECODER.decode(source)
                val arg1 = Solidity.UInt256.DECODER.decode(source)
                return Arguments(arg0, arg1)
            }

            data class Arguments(
                val txhash: Solidity.Bytes32,
                val payment: Solidity.UInt256
            )
        }

        object RemovedOwner {
            const val EVENT_ID: String =
                "f8d49fc529812e9a7c5c50e69c20f0dccc0db8fa95c98bc58cc9a4f1c1299eaf"

            fun decode(topics: List<String>, data: String): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")

                // Decode data
                val source = SolidityBase.PartitionData.of(data)
                val arg0 = Solidity.Address.DECODER.decode(source)
                return Arguments(arg0)
            }

            data class Arguments(
                val owner: Solidity.Address
            )
        }

        object SignMsg {
            const val EVENT_ID: String =
                "e7f4675038f4f6034dfcbbb24c4dc08e4ebf10eb9d257d3d02c0f38d122ac6e4"

            fun decode(topics: List<String>): Arguments {
                // Decode topics
                if (topics.first().removePrefix("0x") != EVENT_ID) throw IllegalArgumentException("topics[0] does not match event id")
                val source1 = SolidityBase.PartitionData.of(topics[1])
                val t1 = Solidity.Bytes32.DECODER.decode(source1)
                return Arguments(t1)
            }

            data class Arguments(
                val msghash: Solidity.Bytes32
            )
        }
    }
}
