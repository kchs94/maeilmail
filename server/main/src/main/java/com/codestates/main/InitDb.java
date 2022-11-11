package com.codestates.main;

import com.codestates.main.answer.entity.Answer;
import com.codestates.main.answer.service.AnswerService;
import com.codestates.main.comment.entity.Comment;
import com.codestates.main.comment.service.CommentService;
import com.codestates.main.member.entity.Member;
import com.codestates.main.member.service.MemberService;
import com.codestates.main.post.entity.Post;
import com.codestates.main.post.service.PostService;
import com.codestates.main.question.entity.Question;
import com.codestates.main.question.service.QuestionService;
import com.codestates.main.questionCategory.entity.QuestionCategory;
import com.codestates.main.questionCategory.service.QuestionCategoryService;
import com.codestates.main.subscription.entity.Subscription;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
