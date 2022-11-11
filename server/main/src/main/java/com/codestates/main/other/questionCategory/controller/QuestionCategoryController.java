package com.codestates.main.other.questionCategory.controller;

import com.codestates.main.other.questionCategory.entity.QuestionCategory;
import com.codestates.main.other.questionCategory.service.QuestionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/questionCategoryController")
public class QuestionCategoryController {
    private final QuestionCategoryService questionCategoryService;

    String[] categories = new String[]{"Java", "React", "Spring", "Data Structure", "Operating System", "Database", "Network", "Javascript"};
//    @PostConstruct
    public void init(){
        for(long i=0;i<categories.length;i++){
            QuestionCategory questionCategory = QuestionCategory.builder()
                    .questionCategoryId(i+1)
                    .name(categories[(int)i])
                    .build();
            questionCategoryService.createQuestionCategory(questionCategory);
        }
    }
}
