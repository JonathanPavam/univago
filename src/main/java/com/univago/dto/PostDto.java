package com.univago.dto;

import lombok.Data;

@Data
public class PostDto {
    private String title;
    private String content;
    private UserDto authorId;
}
