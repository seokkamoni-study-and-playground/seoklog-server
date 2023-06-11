package com.example.seoklog.service;

import com.example.seoklog.controller.dto.CreateRequestDto;
import com.example.seoklog.controller.dto.UpdateRequestDto;
import com.example.seoklog.domain.Post;
import com.example.seoklog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long createPost(CreateRequestDto createRequestDto) {
        Post post = Post.builder()
                .title(createRequestDto.getTitle())
                .content(createRequestDto.getContent())
                .date(new Date())
                .build();
        return postRepository.save(post).getId();
    }

    @Transactional
    public Long updatePost(UpdateRequestDto updateRequestDto) {
        Post post = postRepository.findById(updateRequestDto.getId())
                .orElseThrow(IllegalAccessError::new);
        post.UpdatePost(updateRequestDto);
        
        return updateRequestDto.getId();
    }
}
