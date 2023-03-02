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
@Table(name = "TB_FEED")
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String contents;
    @ManyToOne
    @Setter
    private User author;
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comment> commentList = new ArrayList<>();
    @OneToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<FeedLike> feedLikeList = new ArrayList<>();

    @CreationTimestamp
    private OffsetDateTime createAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;

    @Builder
    public Feed(String title, String contents, User author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    @ToString.Include
    public Integer getCountComment() {
        return this.getCommentList().size();
    }

    @ToString.Include
    public Integer getCountFeedLike() {
        return this.getFeedLikeList().size();
    }
}
