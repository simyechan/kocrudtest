package com.example.kocrudtest.controller

import com.example.kocrudtest.dto.BoardFormDto
import com.example.kocrudtest.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController //REST API
@RequestMapping("board")
class BoardController @Autowired constructor(val boardService: BoardService) {

    //게시글 작성
    @PostMapping
    fun addPost(@RequestBody boardFormDto: BoardFormDto): ResponseEntity<Any> {
        val save = boardService.save(boardFormDto)
        return ResponseEntity.ok().body(save)
    }

    //게시글 읽기
    @GetMapping("/{id}")
    fun getPost(@PathVariable id: Long): ResponseEntity<Any> {
        val post = boardService.getPost(id)
        return ResponseEntity.ok().body(post)
    }

    //게시글 삭제
    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): ResponseEntity<Any> {
        boardService.deletePost(id)
        return ResponseEntity.ok().body(true)
    }

    //게시글 수정
    @PutMapping("/{id}")
    fun updatePost(@PathVariable @RequestBody id: Long, boardFormDto: BoardFormDto): ResponseEntity<Any> {
        val post = boardService.updatePost(id, boardFormDto)
        return ResponseEntity.ok().body(post)
    }

    //게시글 목록
    @GetMapping("/list")
    fun listPost(): ResponseEntity<Any> {
        return ResponseEntity.ok().body(boardService.getPostList())
    }
}