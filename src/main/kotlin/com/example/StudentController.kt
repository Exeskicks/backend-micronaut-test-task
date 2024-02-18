package com.example

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Inject
@Serdeable
@Controller("/api/v1")
class StudentController {
	@Inject
	lateinit var studentService: StudentService

	@Post
	fun addStudent(@Body student: Student) {
		return studentService.save(student)
	}
}