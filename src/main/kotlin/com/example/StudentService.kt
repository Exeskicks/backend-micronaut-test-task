package com.example

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject
import oracle.jdbc.proxy.annotation.Signature
import jakarta.inject.Singleton
@Singleton
@Serdeable
@Introspected
class StudentService {
	@Inject
	lateinit var StudentRepo:StudentRepo
	fun save(student: Student) {
		StudentRepo.save(student)
	}
}