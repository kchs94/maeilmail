package com.codestates.main;

import com.codestates.main.other.member.entity.Member;
import com.codestates.main.other.member.service.MemberService;
import com.codestates.main.other.questionCategory.entity.QuestionCategory;
import com.codestates.main.other.questionCategory.service.QuestionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final MemberService memberService;
    private final QuestionCategoryService questionCategoryService;

    String[] categories = new String[]{"Java", "React", "Spring", "Data Structure", "Operating System", "Database", "Network", "Javascript"};

    @PostConstruct
    public void init() throws IOException {

        Member member = Member.builder()
                .email("shb03207@naver.com")
                .nickname("관리자")
                .password("1234")
                .role(Member.ROLE.ROLE_ADMIN)
                .build();
        memberService.createAdmin(member);

        member = Member.builder()
                .email("test@gmail.com")
                .nickname("유저")
                .password("1234")
                .build();
        memberService.createMember(member);

        for(long i=0;i<categories.length;i++){
            QuestionCategory questionCategory = QuestionCategory.builder()
                    .questionCategoryId(i+1)
                    .name(categories[(int)i])
                    .build();
            questionCategoryService.createQuestionCategory(questionCategory);
        }
    }
}
