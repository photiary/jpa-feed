package com.example.feed.service;

import com.example.feed.entity.FeedLike;
import com.example.feed.repository.FeedLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedLikeService {
    private final FeedLikeRepository feedLikeRepository;

    @Autowired
    public FeedLikeService(FeedLikeRepository feedLikeRepository) {
        this.feedLikeRepository = feedLikeRepository;
    }

    public void save(FeedLike feedLike) {
        feedLikeRepository.save(feedLike);
    }

    public List<FeedLike> findAll() {
        List<FeedLike> feedLikeList = feedLikeRepository.findAll();
        feedLikeList.forEach(System.out::println);
        return feedLikeList;
    }
}
