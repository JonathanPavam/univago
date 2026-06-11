package com.univago.mapper;

import com.univago.dto.CommentDto;
import com.univago.model.Comment;
import com.univago.model.Post;
import com.univago.model.User;
import com.univago.repository.PostRepository;
import com.univago.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    public abstract Comment toEntity(CommentDto dto);

    @Mapping(target = "post", source = "post.id")
    @Mapping(target = "user", source = "user.id")
    public abstract CommentDto toDto(Comment comment);

    protected Post mapPost(Long postId) {
        if (postId == null) return null;
        return postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found: " + postId));
    }

    protected User mapUser(Long userId) {
        if (userId == null) return null;
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + userId));
    }
}

