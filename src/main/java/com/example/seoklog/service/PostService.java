package com.example.seoklog.service;

import com.example.seoklog.controller.dto.CreateRequestDto;
import com.example.seoklog.domain.Post;
import com.example.seoklog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    public Long createPost(CreateRequestDto createRequestDto) {
        Post post = Post.builder()
                .title(createRequestDto.getTitle())
                .content(createRequestDto.getContent())
                .date(new Date())
                .build();
        return postRepository.save(post).getId();
    }
}
