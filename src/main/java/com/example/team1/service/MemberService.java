package com.example.team1.service;

import com.example.team1.domain.Member;
import com.example.team1.dto.request.MemberSignupDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public class MemberService {

    public void signup(MemberSignupDto dto){
        Member member = Member.newMember(dto);

    }
}
