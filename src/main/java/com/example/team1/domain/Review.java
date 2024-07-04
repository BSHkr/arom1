package com.example.team1.domain;


import com.example.team1.dto.request.MemberSignupDto;
import com.example.team1.dto.request.ReviewDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "review")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    private double rating;

    private int views;

    private int likes;

    private int dislikes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eatery_id")
    private Eatery eatery;


    @Builder
    private Review(String content, double rating, int views, int likes, int dislikes) {
        this.content = content;
        this.rating = rating;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public static Review newReview(ReviewDto dto){
        return Review.builder()
                .content(dto.getContent())
                .rating(dto.getRating())
                .views(dto.getViews())
                .likes(dto.getLikes())
                .dislikes(dto.getDislikes())
                .build();
    }

}
