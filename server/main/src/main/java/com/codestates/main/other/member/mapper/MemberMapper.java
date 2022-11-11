package com.codestates.main.other.member.mapper;

import com.codestates.main.other.member.dto.MemberDTO;
import com.codestates.main.other.member.entity.Member;
import org.springframework.stereotype.Component;

@Component
public interface MemberMapper {
    MemberDTO.Post memberToMemberPostDTO(Member member);
    Member memberPostDTOToMember(MemberDTO.Post memberPostDTO);

    MemberDTO.Response memberToMemberResponseDTO(Member member);

    Member memberPatchDTOToMember(MemberDTO.Patch memberPatchDTO);

    Member memberLoginDTOToMember(MemberDTO.Login memberLoginDTO);

    MemberDTO.JwtResponse memberToMemberJwtResponseDTO(Member member);

}
