package ddd_bootcamp.domain

import java.util.UUID

class Account : Entity<Account> {
    val accountId: AccountId
    private var address: Address? = null

    init {
        accountId = AccountId(UUID.randomUUID())
    }

    fun updateAddress(address: Address?) {
        this.address = address
    }

    fun getAddress(): Address? {
        return address
    }

    val accountIdAsString: String
        get() = accountId.accountId.toString()

    override fun hasSameIdentityAs(other: Account): Boolean {
        if (this === other) return true
        return if (other == null || javaClass != other.javaClass) false else accountId == other.accountId
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val account = o as Account
        return accountId == account.accountId
    }

    override fun hashCode(): Int {
        return accountId.hashCode()
    }

    override fun toString(): String {
        return "Account{" +
            "accountId=" + accountId +
            ", address=" + address +
            '}'
    }

}