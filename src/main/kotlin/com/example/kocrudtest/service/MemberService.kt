package com.example.kocrudtest.service

import com.example.kocrudtest.domain.Member
import com.example.kocrudtest.dto.MemberDtoRequest
import com.example.kocrudtest.repository.MemberRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class MemberService(
    private val memberRepository: MemberRepository,
) {

    // 회원가입
    fun signUp(memberDtoRequest: MemberDtoRequest): String {
        var member: Member? = memberRepository
            .findByLoginId(memberDtoRequest.loginId)
        if (member != null) {
            return "이미 등록된 ID 입니다."
        }

        member = Member(
            null,
            memberDtoRequest.loginId,
            memberDtoRequest.password,
            memberDtoRequest.name,
            memberDtoRequest.gender
        )

        memberRepository.save(member)

        return "회원가입이 완료 되었습니다."
    }
}