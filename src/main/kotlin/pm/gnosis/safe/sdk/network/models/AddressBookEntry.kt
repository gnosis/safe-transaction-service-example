package pm.gnosis.safe.sdk.network.models

import pm.gnosis.model.Solidity

data class AddressBookEntry(val address: Solidity.Address, val name: String, val description: String)
