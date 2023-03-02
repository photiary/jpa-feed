package com.example.feed.service;

import com.example.feed.entity.Comment;
import com.example.feed.entity.Feed;
import com.example.feed.entity.User;
import com.example.feed.repository.CommentRepository;
import com.example.feed.repository.FeedRepository;
import com.example.feed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final FeedRepository feedRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, FeedRepository feedRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.feedRepository = feedRepository;
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void save(Comment comment, Long userId, Long feedId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.getCommentList().add(comment);

        Feed feed = feedRepository.findById(feedId).orElseThrow();
        feed.getCommentList().add(comment);
        
        comment.setAuthor(user);
        this.save(comment);
    }

    public List<Comment> findAll() {
        List<Comment> commentList = commentRepository.findAll();
        commentList.forEach(System.out::println);
        return commentList;
    }
}
