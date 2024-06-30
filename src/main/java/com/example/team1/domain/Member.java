package com.example.team1.domain;

import com.example.team1.dto.request.MemberSignupDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String introduction;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<BoardReply> boardsReplies = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<ChatRoomMember> chatroomMemberList = new ArrayList<>();

    @JsonBackReference
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_chat_id")
    private GroupChat groupChat;

    public enum Gender{
        MALE, FEMALE
    }


    @Builder
    private Member(String email, String password, String name, String introduction, Gender gender) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.introduction = introduction;
        this.gender = gender;
    }

    public static Member newMember(MemberSignupDto dto){
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .introduction(dto.getIntroduction())
                .gender(dto.getGender())
                .build();
    }
}
