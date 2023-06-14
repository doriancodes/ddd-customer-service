package ddd_bootcamp.threetier.applicationservice

import ddd_bootcamp.domain.Account
import ddd_bootcamp.domain.Address
import ddd_bootcamp.domain.Customer

import ddd_bootcamp.domain.CustomerId
import ddd_bootcamp.threetier.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerAppService(customerRepository: CustomerRepository) {
    private val customerRepository: CustomerRepository

    init {
        this.customerRepository = customerRepository
    }

    //@Transactional
    fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    //@Transactional
    fun updateAddress(customerId: CustomerId, address: Address): Customer {
        val customer: Customer? = customerRepository.find(customerId)
        customer!!.updateAddress(address) //todo throw exception
        return customerRepository.save(customer)
    }

    //@Transactional
    fun addAccount(customerId: CustomerId, account: Account): Customer {
        val customer: Customer? = customerRepository.find(customerId)
        customer!!.addAccount(account) //todo throw exception
        return customerRepository.save(customer)
    }
}