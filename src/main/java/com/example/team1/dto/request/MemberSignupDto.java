package com.example.team1.dto.request;

import com.example.team1.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignupDto {
    private String name;
    private String email;
    private String password;
    private String introduction;
    private Member.Gender gender;
}
