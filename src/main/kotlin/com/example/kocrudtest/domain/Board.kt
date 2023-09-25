package com.example.kocrudtest.domain

import com.example.kocrudtest.dto.BoardFormDto
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var writer: String, //작성자
    var password: String, //비밀번호
    var title: String, //제목
    var content: String //내용
) {

    fun updatePost(boardFormDto: BoardFormDto) { //수정
        writer = boardFormDto.writer
        title = boardFormDto.title
        password = boardFormDto.password
        content = boardFormDto.content
    }
}