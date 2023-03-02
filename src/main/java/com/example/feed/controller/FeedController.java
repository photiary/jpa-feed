package com.example.feed.controller;

import com.example.feed.dto.FeedDto;
import com.example.feed.entity.Feed;
import com.example.feed.service.FeedService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeedController {
    private final FeedService feedService;
    private final ModelMapper modelMapper;

    @Autowired
    public FeedController(FeedService feedService, ModelMapper modelMapper) {
        this.feedService = feedService;
        this.modelMapper = modelMapper;
    }

    @QueryMapping
    @GetMapping(path = "/feeds")
    public List<FeedDto> findAllFeed() {
        List<Feed> feedList = feedService.findAll();
        return feedList.stream()
                .map(feed -> modelMapper.map(feed, FeedDto.class))
                .collect(Collectors.toList());
    }
}
