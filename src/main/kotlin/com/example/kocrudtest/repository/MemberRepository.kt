package com.example.kocrudtest.repository

import com.example.kocrudtest.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByLoginId(LoginId: String): Member?
}