package com.codestates.main.other.subscription.repository;

import com.codestates.main.other.member.entity.Member;
import com.codestates.main.other.questionCategory.entity.QuestionCategory;
import com.codestates.main.other.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    @Transactional
    List<Subscription> findSubscriptionsByMemberAndStatus(Member member, Subscription.STATUS status);
    Subscription findSubscriptionsByMemberAndQuestionCategory(Member member, QuestionCategory questionCategory);

}
