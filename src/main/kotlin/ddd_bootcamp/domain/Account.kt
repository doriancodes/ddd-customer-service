package ddd_bootcamp.domain

import java.util.UUID

class Account : Entity<Account> {
    val accountId: AccountId
    private lateinit var address: Address

    init {
        accountId = AccountId(UUID.randomUUID())
    }

    fun updateAddress(address: Address) {
        this.address = address
    }

    fun getAddress(): Address {
        return address
    }

    val accountIdAsString: String
        get() = accountId.accountId.toString()

    override fun hasSameIdentityAs(other: Account): Boolean {
        if (this === other) return true
        return if (javaClass != other.javaClass) false else accountId == other.accountId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val account = other as Account
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