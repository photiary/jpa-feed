package com.example.feed.service;

import com.example.feed.entity.Comment;
import com.example.feed.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        commentList.forEach(System.out::println);
        return commentList;
    }
}
