package com.example.seoklog.controller.dto;


import lombok.Getter;

@Getter
public class UpdateRequestDto {
    private Long id;
    private String title;
    private String content;
}
