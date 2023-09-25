package com.example.kocrudtest.dto

data class MemberDtoRequest(
    val id: Long?,
    val loginId: String,
    val password: String,
    val name: String,
    val gender: String,
)