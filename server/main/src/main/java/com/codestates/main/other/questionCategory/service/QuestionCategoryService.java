package com.codestates.main.other.questionCategory.service;

import com.codestates.main.other.questionCategory.entity.QuestionCategory;
import com.codestates.main.other.questionCategory.repository.QuestionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionCategoryService {
    private final QuestionCategoryRepository questionCategoryRepository;
    public QuestionCategory createQuestionCategory(QuestionCategory questionCategory){
        return questionCategoryRepository.save(questionCategory);
    }

    public QuestionCategory findQuestionCategory(long questionCategoryId) {
        return questionCategoryRepository.findByQuestionCategoryId(questionCategoryId);
    }
}
