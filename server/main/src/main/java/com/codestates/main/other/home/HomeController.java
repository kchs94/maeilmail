package com.codestates.main.other.home;

import com.codestates.main.other.member.dto.MemberDTO;
import com.codestates.main.other.member.entity.Member;
import com.codestates.main.other.member.mapper.MemberMapper;
import com.codestates.main.other.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;



    @GetMapping("/hello")
    public String oauth2() {
        return "oauth2";
    }


    @GetMapping("/home")
    public ResponseEntity home() {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        String email = String.valueOf(user.getPrincipal());
        Member member = memberService.findMemberWithActiveSubscription(email);
        MemberDTO.JwtResponse jwtResponse = memberMapper.memberToMemberJwtResponseDTO(member);
        return new ResponseEntity<>(jwtResponse,HttpStatus.OK);
    }

    @GetMapping("/subscription")
    public ResponseEntity getMember(){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        String email = String.valueOf(user.getPrincipal());
        Member member = memberService.findMemberWithActiveSubscription(email);
        MemberDTO.Response response = memberMapper.memberToMemberResponseDTO(member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
