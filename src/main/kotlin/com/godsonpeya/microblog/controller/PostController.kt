package com.godsonpeya.microblog.controller

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.service.PostService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PostController private constructor(private val postService: PostService){

    @GetMapping("/posts")
    fun getPostList(): List<Post> = postService.getPosts()

    @GetMapping("/posts/by-user/{userId}")
    fun getPostsByUserId(@PathVariable userId: Long): List<Post> = postService.getPostByUserId(userId)

    @GetMapping("/posts/{id}")
    fun getPostById(@PathVariable id: Long): Post = postService.getOne(id)

    @PostMapping("/posts") //TODO why @Valid doesn't work
    fun createPost(@Valid @RequestBody  post: Post): Post = postService.savePost(post)

    @PutMapping("/posts/{id}")
    fun updatePost(@Valid @RequestBody  post: Post, @PathVariable id: Long): Post = postService.updatePost(id, post)

    @DeleteMapping("/posts/{id}")
    fun deletePost(@PathVariable id: Long): String = postService.deletePost(id)
}