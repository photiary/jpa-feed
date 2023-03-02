package com.example.feed.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Feed> feedList = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comment> commentList;
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FeedLike> feedLikeList;

    @CreationTimestamp
    private OffsetDateTime createAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;

    @Builder
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
