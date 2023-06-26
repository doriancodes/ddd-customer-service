package ddd_bootcamp.threetier.controller

import ddd_bootcamp.domain.Account
import ddd_bootcamp.domain.Address
import ddd_bootcamp.domain.Customer
import ddd_bootcamp.domain.CustomerId
import ddd_bootcamp.threetier.applicationservice.CustomerAppService
import ddd_bootcamp.threetier.controller.resource.CustomerResource
import ddd_bootcamp.threetier.controller.viewModel.AccountRequest
import ddd_bootcamp.threetier.controller.viewModel.AddressRequest
import ddd_bootcamp.threetier.controller.viewModel.CustomerRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CustomerController(private val customerAppService: CustomerAppService) {
    @PostMapping("/customers")
    fun create(@RequestBody request: CustomerRequest): CustomerResource {
        println("request = $request")
        val customer = customerAppService.createCustomer(
            Customer(Address(request.addressRequest?.city!!))
        )
        return CustomerResource.from(customer)
    }

    @PutMapping("/customers/{customerId}/accounts")
    fun createAccount(@RequestBody request: AccountRequest, @PathVariable customerId: String): CustomerResource {
        println("request = $request")
        println("PathVariable = $customerId")
        val customer = customerAppService.addAccount(CustomerId(UUID.fromString(customerId)), Account())
        return CustomerResource.from(customer)
    }

    @PutMapping("/customers/{customerId}/address")
    fun updateAddress(@RequestBody request: AddressRequest, @PathVariable customerId: String): CustomerResource {
        println("request = $request")
        println("PathVariable = $customerId")
        val customer = customerAppService.updateAddress(
            CustomerId(UUID.fromString(customerId)),
            Address(request.city!!)
        )
        return CustomerResource.from(customer)
    }
}
