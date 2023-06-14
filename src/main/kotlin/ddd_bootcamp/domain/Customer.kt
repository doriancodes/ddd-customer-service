package ddd_bootcamp.domain

import java.util.UUID
import java.util.function.Consumer

class Customer(address: Address) : Aggregate {
    val customerId: CustomerId = CustomerId(UUID.randomUUID())
    private var address: Address
    private val accounts: MutableList<Account> = ArrayList()

    init {
        this.address = address
    }

    fun getAddress() = this.address

    fun addAccount(account: Account) {
        accounts.add(account)
        account.updateAddress(address)
    }

    fun updateAddress(address: Address) {
        this.address = address
        accounts.forEach(Consumer { account: Account ->
            account.updateAddress(
                address
            )
        })
    }

    val customerIdAsString: String
        get() = customerId.id.toString()

    fun getAccounts(): List<Account> {
        return accounts
    }

    override fun toString(): String {
        return "Customer{" +
            "customerId=" + customerId +
            ", address=" + address +
            ", accounts=" + accounts +
            '}'
    }
}