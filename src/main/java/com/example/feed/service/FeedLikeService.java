package com.example.feed.service;

import com.example.feed.entity.Feed;
import com.example.feed.entity.FeedLike;
import com.example.feed.entity.User;
import com.example.feed.repository.FeedLikeRepository;
import com.example.feed.repository.FeedRepository;
import com.example.feed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedLikeService {
    private final FeedLikeRepository feedLikeRepository;

    private final UserRepository userRepository;
    private final FeedRepository feedRepository;

    @Autowired
    public FeedLikeService(FeedLikeRepository feedLikeRepository, UserRepository userRepository, FeedRepository feedRepository) {
        this.feedLikeRepository = feedLikeRepository;
        this.userRepository = userRepository;
        this.feedRepository = feedRepository;
    }

    public void save(FeedLike feedLike) {
        feedLikeRepository.save(feedLike);
    }

    public void save(Long userId, Long feedId) {
        FeedLike feedLike = FeedLike.builder().build();

        User user = userRepository.findById(userId).orElseThrow();
        user.getFeedLikeList().add(feedLike);

        Feed feed = feedRepository.findById(feedId).orElseThrow();
        feed.getFeedLikeList().add(feedLike);

        feedLike.setAuthor(user);
        feedLikeRepository.save(feedLike);
    }

    public List<FeedLike> findAll() {
        List<FeedLike> feedLikeList = feedLikeRepository.findAll();
        feedLikeList.forEach(System.out::println);
        return feedLikeList;
    }
}
