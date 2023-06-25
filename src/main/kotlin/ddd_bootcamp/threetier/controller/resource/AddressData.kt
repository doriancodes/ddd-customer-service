package ddd_bootcamp.threetier.controller.resource

import ddd_bootcamp.domain.Address

class AddressData {
    var city: String? = null

    companion object {
        fun from(address: Address): AddressData {
            val addressData = AddressData()
            addressData.city = address.city
            return addressData
        }
    }
}