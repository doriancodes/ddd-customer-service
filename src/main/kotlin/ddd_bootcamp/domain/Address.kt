package ddd_bootcamp.domain

data class Address(val city: String): ValueObject<Address> {
    override fun sameValueAs(o: Address): Boolean {
        if (this === o) return true
        return if (o == null || javaClass != o.javaClass) false else city == o.city
    }
}
