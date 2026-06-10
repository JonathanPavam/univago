package com.univago.controller;

import com.univago.dto.CommentDto;
import com.univago.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDto> findbyid(@PathVariable Long id){
        return ResponseEntity.ok().body(commentService.findById(id));
    }

    @RequestMapping
    public ResponseEntity<List<CommentDto>> findAll(){
        List<CommentDto> list = commentService.findALl();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/")
    public ResponseEntity <CommentDto> post (@RequestBody CommentDto Comment){
        return ResponseEntity.ok().body(commentService.create(Comment));
    }

    @PutMapping("/{id}")
    public ResponseEntity <CommentDto> update (@PathVariable Long id,@RequestBody CommentDto dto){
        dto = commentService.put(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
