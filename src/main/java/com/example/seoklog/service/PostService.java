package com.example.seoklog.service;

import com.example.seoklog.controller.dto.CreateRequestDto;
import com.example.seoklog.controller.dto.UpdateRequestDto;
import com.example.seoklog.controller.dto.PostResponseDto;
import com.example.seoklog.domain.Post;
import com.example.seoklog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public PostResponseDto updatePost(UpdateRequestDto updateRequestDto, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
        post.UpdatePost(updateRequestDto);

        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getPost() {
        List<PostResponseDto> result = new ArrayList<>();
        List<Post> post = postRepository.findAll();
        for(Post p : post){
            result.add(new PostResponseDto(p));
        }
        return result;
    }

    public PostResponseDto getPostDetail(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);
        return new PostResponseDto(post);
    }

    public void deletePost(Long id) {
         postRepository.deleteById(id);
    }
}
