package ddd_bootcamp.domain

interface Entity<T> {
    fun hasSameIdentityAs(other: T): Boolean
}