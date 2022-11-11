package com.codestates.main.question.dto;

import com.codestates.main.other.member.dto.MemberDTO;
import com.codestates.main.question.entity.Question;
import com.codestates.main.other.questionCategory.dto.QuestionCategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponseDto {

    private Long questionId;

    private String content;

    private LocalDateTime createdAt;

    private MemberDTO.PostResponse member;

    private QuestionCategoryResponseDto questionCategory;

    public QuestionResponseDto(Question question) {
        this.questionId = question.getQuestionId();
        this.content = question.getContent();
        this.createdAt = question.getCreatedAt();
        this.member = new MemberDTO.PostResponse(question.getMember());
        this.questionCategory = new QuestionCategoryResponseDto(question.getQuestionCategory());
    }
}
