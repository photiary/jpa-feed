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
    @Setter
    private User author;

    @CreationTimestamp
    private OffsetDateTime createAt;
    @UpdateTimestamp
    private OffsetDateTime updateAt;

    @Builder
    public Comment(String comment, User author) {
        this.comment = comment;
        this.author = author;
    }
}
