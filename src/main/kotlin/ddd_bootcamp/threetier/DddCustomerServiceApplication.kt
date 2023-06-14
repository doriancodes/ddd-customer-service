package ddd_bootcamp.threetier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DddCustomerServiceApplication

fun main(args: Array<String>) {
	runApplication<DddCustomerServiceApplication>(*args)
}
