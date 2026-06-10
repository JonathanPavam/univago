package com.univago.service;

import com.univago.dto.PostDto;
import com.univago.mapper.PostMapper;
import com.univago.model.Post;
import com.univago.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;


    public PostDto create (PostDto dto){
        Post post = postMapper.toEntity(dto);
        post = postRepository.save(post);
        return postMapper.toDto(post);
    }

    public PostDto put (Long id, PostDto dto){
        Post post = postRepository.findById(id).orElseThrow();
        dtoToEntity(post, dto);
        post = postRepository.save(post);
        return postMapper.toDto(post);
    }

    public List<PostDto> findALl(){
        return postRepository.findAll().stream().map(postMapper::toDto).collect(Collectors.toList());
    }

    public PostDto findById(Long id){
        return postRepository.findById(id).map(postMapper::toDto).orElseThrow();
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }

    public void dtoToEntity (Post entity, PostDto dto){
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
    }
}
