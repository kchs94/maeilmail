package com.codestates.main.other.subscription.mapper;

import com.codestates.main.other.subscription.dto.SubscriptionDTO;
import com.codestates.main.other.subscription.entity.Subscription;

public interface SubscriptionMapper {
    Subscription SubscriptionPostDtoToSubscription(SubscriptionDTO.Post requestBody);

    SubscriptionDTO.Response subscriptionToSubscriptionResponseDTO(Subscription subscription);
}
