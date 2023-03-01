package com.example.feed;

import com.example.feed.entity.Comment;
import com.example.feed.entity.Feed;
import com.example.feed.entity.User;
import com.example.feed.service.CommentService;
import com.example.feed.service.FeedLikeService;
import com.example.feed.service.FeedService;
import com.example.feed.service.UserService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaFeedApplication.class, args);
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> readyEventApplicationListener(
            UserService userService
            , FeedService feedService
            , CommentService commentService
            , FeedLikeService feedLikeService) {
        return event -> {
            System.out.println("------------------------------");
            userService.findAll();
            System.out.println("------------------------------");
            feedService.findAll();
            System.out.println("------------------------------");
            commentService.findAll();
            System.out.println("------------------------------");
            feedLikeService.findAll();
            System.out.println("------------------------------");
            feedService.findAll();
            System.out.println("------------------------------");
            userService.findAll();
            System.out.println("------------------------------");
        };
    }

    @Bean
    ApplicationRunner initData(UserService userService
            , FeedService feedService
            , CommentService commentService
            , FeedLikeService feedLikeService) {
        return args -> {
            User user1 = User.builder()
                    .email("user1@example.com")
                    .password("qwe123!@#")
                    .name("Kim")
                    .build();
            userService.save(user1);

            User user2 = User.builder()
                    .email("user2@example.com")
                    .password("456$%^")
                    .name("Lee")
                    .build();
            userService.save(user2);


            Feed feed1 = Feed.builder()
                    .title("feed1Title")
                    .contents("feed1Contents")
                    .author(user1)
                    .build();
            feedService.save(feed1);

            Feed feed2 = Feed.builder()
                    .title("feed2Title")
                    .contents("feed2Contents")
                    .author(user1)
                    .build();
            feedService.save(feed2);

            Feed feed3 = Feed.builder()
                    .title("feed3Title")
                    .contents("feed3Contents")
                    .build();
            feedService.save(feed3, user1.getId());

            Comment comment = Comment.builder()
                    .feed(feed2)
                    .comment("user1 comment")
                    .author(user1)
                    .build();
            commentService.save(comment);

//            FeedLike feedLike = FeedLike.builder()
//                    .feed(feed2)
//                    .author(user1)
//                    .build();
//            feedLikeService.save(feedLike);

        };
    }
}
