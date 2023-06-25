package ddd_bootcamp.threetier.controller.resource

import ddd_bootcamp.domain.Account
import ddd_bootcamp.domain.Customer
import java.util.UUID

class CustomerResource {
    var customerId: UUID? = null
    var addressData: AddressData? = null
    var accountDataList: List<AccountData>? = null

    companion object {
        fun from(customer: Customer): CustomerResource {
            val customerResource = CustomerResource()
            customerResource.customerId = customer.customerId.id
            customerResource.addressData = AddressData.from(customer.getAddress())
            val accountDataList: List<AccountData> = customer.getAccounts()
                .map { account: Account? -> AccountData.from(account!!) }
            customerResource.accountDataList = accountDataList
            return customerResource
        }
    }
}