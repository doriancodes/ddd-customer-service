package ddd_bootcamp.threetier.controller.resource

import ddd_bootcamp.domain.Account

class AccountData {
    var accountId: String? = null
    var addressData: AddressData? = null

    companion object {
        fun from(account: Account): AccountData {
            val accountData = AccountData()
            accountData.accountId = account.accountIdAsString
            accountData.addressData = AddressData.from(account.getAddress())
            return accountData
        }
    }
}