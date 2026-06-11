package com.univago.mapper;

import com.univago.dto.PostDto;
import com.univago.model.Post;
import com.univago.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "authorId", source = "authorId")
    Post toEntity(PostDto dto);

    @Mapping(target = "authorId", source = "authorId.id")
    PostDto toDto(Post post);

    default User mapAuthorIdToUser(Long authorId) {
        if (authorId == null) return null;
        User user = new User();
        user.setId(authorId);
        return user;
    }
}
