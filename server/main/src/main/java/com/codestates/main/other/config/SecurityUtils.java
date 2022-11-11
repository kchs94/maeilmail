package com.codestates.main.other.config;

import com.codestates.main.other.member.entity.Member;
import com.codestates.main.other.member.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    /**
     * 로그인한 회원을 반환하는 메서드
     * @param memberService
     * @return 회원
     */
    public static Member getCurrentMember(MemberService memberService) {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        String email = String.valueOf(user.getPrincipal());
        return memberService.findMemberByEmail(email);
    }
}
