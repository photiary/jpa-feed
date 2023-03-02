package com.example.feed.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
public class FeedDto {
    private Long id;
    private String title;
    private String contents;
    private UserDto author;
    private List<FeedLikeDto> feedLikeList;
    private List<CommentDto> commentList;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;
}
