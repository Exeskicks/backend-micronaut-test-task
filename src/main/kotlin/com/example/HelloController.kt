package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/hello") // (1)
class HelloController {

	@Get(produces = [MediaType.TEXT_PLAIN]) // (2)
	fun index(): String {
		return "Hello World" // (3)
	}
}