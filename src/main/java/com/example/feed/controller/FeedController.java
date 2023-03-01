package com.example.feed.controller;

import com.example.feed.entity.Feed;
import com.example.feed.service.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {
    private final FeedService feedService;

    @Autowired
    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping(path = "/feeds")
    public List<Feed> findAll() {
        return feedService.findAll();
    }
}
