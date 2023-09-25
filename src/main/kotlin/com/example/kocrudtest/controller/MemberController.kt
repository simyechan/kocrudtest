package com.example.kocrudtest.controller

import com.example.kocrudtest.dto.MemberDtoRequest
import com.example.kocrudtest.service.MemberService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/member")
@RestController
class MemberController(
    private val memberService: MemberService
) {
    // 회원가입
    @PostMapping("/signup")
    fun signup(@RequestBody memberDtoRequest: MemberDtoRequest): String {
        return memberService.signUp(memberDtoRequest)
    }
}