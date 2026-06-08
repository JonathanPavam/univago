package com.univago.service;

import com.univago.model.Comment;
import com.univago.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
}
