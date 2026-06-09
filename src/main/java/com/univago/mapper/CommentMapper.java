package com.univago.mapper;

import com.univago.dto.CommentDto;
import com.univago.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment toEntity(CommentDto dto);
    CommentDto toDto(Comment comment);
}
