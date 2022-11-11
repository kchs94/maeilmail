package com.codestates.main.other.subscription.service;

import com.codestates.main.other.member.entity.Member;
import com.codestates.main.other.subscription.repository.SubscriptionRepository;
import com.codestates.main.other.questionCategory.entity.QuestionCategory;
import com.codestates.main.other.subscription.entity.Subscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    public void createSubscription(Subscription subscription){
        subscriptionRepository.save(subscription);
    }

    public void createNewSubscription(Subscription subscription){
        subscription.setStatus(Subscription.STATUS.SUBSCRIPTION_ACTIVE);
        subscriptionRepository.save(subscription);
    }

    public List<Subscription> findActiveMemberSubscriptions(Member member){

        //System.out.println("find Active Member Subscription 호출");
        //System.out.println("member: "+member);
        //System.out.println("구독 정보: "+subscriptions);
        return subscriptionRepository.findSubscriptionsByMemberAndStatus(member, Subscription.STATUS.SUBSCRIPTION_ACTIVE);
    }

    public Subscription findSubscriptionInfo(Member member, QuestionCategory questionCategory) {
        Subscription subscription = subscriptionRepository.findSubscriptionsByMemberAndQuestionCategory(member, questionCategory);

        if (subscription == null) {                                         // 아예 처음 구독
            Subscription createdSubscription = new Subscription();
            createdSubscription.setMember(member);
            createdSubscription.setQuestionCategory(questionCategory);
            createNewSubscription(createdSubscription);
            return createdSubscription;
        } else {

            Subscription.STATUS status = subscription.getStatus();          // 이후 구독 처리
            System.out.println(status);
            if (status.equals(Subscription.STATUS.SUBSCRIPTION_ACTIVE)) {
                subscription.setStatus(Subscription.STATUS.SUBSCRIPTION_DEACTIVATED);
            } else {
                subscription.setStatus(Subscription.STATUS.SUBSCRIPTION_ACTIVE);
            }
            createSubscription(subscription);
            return subscription;
        }
    }
}
