package ddd_bootcamp.threetier.repository

import ddd_bootcamp.domain.Customer
import ddd_bootcamp.domain.CustomerId
import org.springframework.stereotype.Repository

//Customer Repository or Data Access Layer
//Using in-memory map instead of db for demo

@Repository
class CustomerRepository {
    private val customerMap: MutableMap<CustomerId, Customer> = HashMap()
    fun save(customer: Customer): Customer {
        println("in Repository customer = $customer")
        customerMap[customer.customerId] = customer
        return customer
    }

    fun find(customerId: CustomerId): Customer? {
        return customerMap[customerId]
    }
}