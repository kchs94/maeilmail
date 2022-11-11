package com.codestates.main.other.questionCategory.repository;


import com.codestates.main.other.questionCategory.entity.QuestionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionCategoryRepository extends JpaRepository<QuestionCategory, Long> {
    QuestionCategory findByQuestionCategoryId(long questionCategoryId);
    QuestionCategory findByName(String name);
}
