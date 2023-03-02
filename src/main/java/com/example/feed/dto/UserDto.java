package com.example.feed.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;
}
