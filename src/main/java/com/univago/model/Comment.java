package com.univago.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private final Long id;
    private String content;
    private final Post post;
    private User user;
}
