package com.univago.dto;

import com.univago.model.Post;
import com.univago.model.User;
import lombok.Data;

@Data
public class CommentDto {
    private String content;
    private Post post;
    private User user;
}
