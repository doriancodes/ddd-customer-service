package ddd_bootcamp.threetier.controller.resource

import java.util.UUID

data class CustomerResource(
    val customerId: UUID,
    val addressData: AddressData,
    val accountDataList: List<AccountData>
) {
    companion object
}