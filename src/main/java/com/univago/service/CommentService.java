package com.univago.service;

import com.univago.dto.CommentDto;
import com.univago.mapper.CommentMapper;
import com.univago.model.Comment;
import com.univago.model.Comment;
import com.univago.repository.CommentRepository;
import com.univago.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;


    public CommentDto create (CommentDto dto){
        Comment Comment = commentMapper.toEntity(dto);
        Comment = commentRepository.save(Comment);
        return commentMapper.toDto(Comment);
    }

    public CommentDto put (Long id, CommentDto dto){
        Comment Comment = commentRepository.findById(id).orElseThrow();
        dtoToEntity(Comment, dto);
        Comment = commentRepository.save(Comment);
        return commentMapper.toDto(Comment);
    }

    public List<CommentDto> findALl(){
        return commentRepository.findAll().stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    public CommentDto findById(Long id){
        return commentRepository.findById(id).map(commentMapper::toDto).orElseThrow();
    }

    public void delete(Long id){
        commentRepository.deleteById(id);
    }

    public void dtoToEntity (Comment entity, CommentDto dto){
        entity.setContent(dto.getContent());
    }
}
