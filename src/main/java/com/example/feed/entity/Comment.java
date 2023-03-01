package com.example.feed.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(name = "TB_COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;

    @ManyToOne
    private Feed feed;
    @ManyToOne
    private User author;

    @CreationTimestamp
    private OffsetDateTime createAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;

    @Builder
    public Comment(String comment, Feed feed, User author) {
        this.comment = comment;
        this.feed = feed;
        this.author = author;
    }
}
