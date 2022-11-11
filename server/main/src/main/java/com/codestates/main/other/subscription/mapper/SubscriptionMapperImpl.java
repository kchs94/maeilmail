package com.codestates.main.other.subscription.mapper;

import com.codestates.main.other.subscription.dto.SubscriptionDTO;
import com.codestates.main.other.subscription.entity.Subscription;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMapperImpl implements SubscriptionMapper{
    @Override
    public Subscription SubscriptionPostDtoToSubscription(SubscriptionDTO.Post subscriptionPostDTO) {
        return null;
    }

    @Override
    public SubscriptionDTO.Response subscriptionToSubscriptionResponseDTO(Subscription subscription) {
        if(subscription==null){
            return null;
        }
        long questionCategoryId = 0L;
        String name = null;
        System.out.println(subscription);
        questionCategoryId=subscription.getQuestionCategory().getQuestionCategoryId();
        name = subscription.getQuestionCategory().getName();
        return new SubscriptionDTO.Response(questionCategoryId,name);

    }
}
