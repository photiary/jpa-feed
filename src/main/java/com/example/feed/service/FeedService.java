package com.example.feed.service;

import com.example.feed.entity.Feed;
import com.example.feed.entity.User;
import com.example.feed.repository.FeedRepository;
import com.example.feed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedService {
    private final FeedRepository feedRepository;

    private final UserRepository userRepository;

    @Autowired
    public FeedService(FeedRepository feedRepository, UserRepository userRepository) {
        this.feedRepository = feedRepository;
        this.userRepository = userRepository;
    }

    public void save(Feed feed) {
        feedRepository.save(feed);
    }

    public void save(Feed feed, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        feed.setAuthor(user);
        user.getFeedList().add(feed);
//        user.addFeed(feed);
        this.save(feed);
    }

    public List<Feed> findAll() {
        List<Feed> feedList = feedRepository.findAll();
        feedList.forEach(System.out::println);
        return feedList;
    }
}
