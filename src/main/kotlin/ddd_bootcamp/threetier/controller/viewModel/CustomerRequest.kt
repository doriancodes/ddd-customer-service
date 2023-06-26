package ddd_bootcamp.threetier.controller.viewModel

class CustomerRequest {
    //needed for spring framework
    //needed for spring framework
    var addressRequest: AddressRequest? = null
    var accountRequest: AccountRequest? = null

    override fun toString(): String {
        return "CustomerRequest{" +
            "addressRequest=" + addressRequest +
            ", accountRequest=" + accountRequest +
            '}'
    }
}