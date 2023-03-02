package com.example.feed.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CommentDto {
    private Long id;
    private String comment;
    private UserDto author;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;

}
