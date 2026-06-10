package com.univago.controller;

import com.univago.dto.PostDto;
import com.univago.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> findbyid(@PathVariable Long id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @RequestMapping
    public ResponseEntity<List<PostDto>> findAll(){
        List<PostDto> list = postService.findALl();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/")
    public ResponseEntity <PostDto> post (@RequestBody PostDto Post){
        return ResponseEntity.ok().body(postService.create(Post));
    }

    @PutMapping("/{id}")
    public ResponseEntity <PostDto> update (@PathVariable Long id,@RequestBody PostDto dto){
        dto = postService.put(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
