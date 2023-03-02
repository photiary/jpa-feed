package com.example.feed.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class FeedLikeDto {
    private Long id;
    private UserDto author;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;
}
