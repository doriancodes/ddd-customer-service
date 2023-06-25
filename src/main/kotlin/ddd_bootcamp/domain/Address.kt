package ddd_bootcamp.domain

class Address(val city: String) : ValueObject<Address> {

    override fun toString(): String {
        return "Address{" +
            "city='" + city + '\'' +
            '}'
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val address = other as Address
        return city == address.city
    }

    override fun hashCode(): Int {
        return city.hashCode()
    }

    override fun sameValueAs(other: Address): Boolean {
        if (this === other) return true
        return if (javaClass != other.javaClass) false else city == other.city
    }
}
