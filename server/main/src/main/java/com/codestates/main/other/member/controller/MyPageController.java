package com.codestates.main.other.member.controller;

import com.codestates.main.other.member.dto.MemberDTO;
import com.codestates.main.other.member.entity.Member;
import com.codestates.main.other.member.mapper.MemberMapper;
import com.codestates.main.other.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/my-page")
public class MyPageController {
    private final MemberMapper memberMapper;
    private final MemberService memberService;
    @GetMapping("/test")
    public String getTest(){
        return "security test";
    }

    @GetMapping
    public ResponseEntity getMemberProfile(){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        String email = String.valueOf(user.getPrincipal().toString());
        Member member = memberService.findMemberByEmail(email);
        MemberDTO.Response response = memberMapper.memberToMemberResponseDTO(member);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PatchMapping("/patch")
    public ResponseEntity patchMember(@RequestBody MemberDTO.Patch requestBody){
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        String email = String.valueOf(user.getPrincipal().toString());

        Member member = memberMapper.memberPatchDTOToMember(requestBody);
        member.setEmail(email);
        Member updatedAnswer = memberService.updateMember(member);
        MemberDTO.Response response = memberMapper.memberToMemberResponseDTO(updatedAnswer);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
