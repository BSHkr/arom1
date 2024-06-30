package com.example.team1.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "eatery")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Eatery extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String telephone;

    private String information;

    private double rating;

    private LocalDateTime openingHours;

    private LocalDateTime closingHours;


    @OneToMany(mappedBy = "eatery", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "eatery")
    private List<EateryCategory> eateryCategories = new ArrayList<>();

    @OneToMany(mappedBy = "eatery", cascade = CascadeType.REMOVE)
    private List<ChatRoom> chatRooms = new ArrayList<>();


}
