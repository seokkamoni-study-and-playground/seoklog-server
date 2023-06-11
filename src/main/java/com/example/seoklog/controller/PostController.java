package com.example.seoklog.controller;

import com.example.seoklog.controller.dto.CreateRequestDto;
import com.example.seoklog.controller.dto.UpdateRequestDto;
import com.example.seoklog.controller.dto.PostResponseDto;
import com.example.seoklog.domain.Post;
import com.example.seoklog.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    @PostMapping("/post")
    public Long createPost(@RequestBody CreateRequestDto createRequestDto) {
        return postService.createPost(createRequestDto);
    }

    @PutMapping("/post")
    public PostResponseDto updatePost(@RequestBody UpdateRequestDto updateRequestDto) {
        return postService.updatePost(updateRequestDto);
    }

    @GetMapping("/post")
    public List<PostResponseDto> getPost() {
        return postService.getPost();
    }

    @GetMapping("/post/{id}")
    public PostResponseDto getPostDetail(@PathVariable Long id) {
        return postService.getPostDetail(id);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
