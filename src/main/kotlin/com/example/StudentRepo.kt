package com.example

import io.micronaut.context.annotation.Executable
import io.micronaut.core.annotation.Introspected
import io.micronaut.data.repository.CrudRepository
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
interface StudentRepo : CrudRepository<Student, Int> { // (2)
	@Executable
	fun find(title: String): Student
}