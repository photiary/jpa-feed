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
@Table(name = "TB_FEED_LIKE")
public class FeedLike {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Setter
    private User author;

    @CreationTimestamp
    private OffsetDateTime createAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;

    @Builder
    public FeedLike(User author) {
        this.author = author;
    }
}
