package com.example

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*;
@Serdeable
@Table(name = "students")
@Entity
data class Student (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	var studentId: Int = 0,
	@Column(name = "firstname")
	var firstname: String = "",
	@Column(name = "age")
	var age: Int = 0
)
