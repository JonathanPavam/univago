package com.univago.dto;
import lombok.Data;
import java.time.Instant;

@Data
public class CommentDto {
    private String content;
    private Long post;
    private Long user;
    private Instant instant;
}
