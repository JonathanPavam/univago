package com.univago.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private final String id;
    private String title;
    private String content;
    private final User authorId;
}
