package com.univago.mapper;

import com.univago.dto.PostDto;
import com.univago.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostDto dto);
    PostDto toDto(Post post);
}
