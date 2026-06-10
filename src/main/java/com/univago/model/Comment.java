package com.univago.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private Instant instant;
    private String content;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private final Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
