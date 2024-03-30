package org.nr.reviewms.review.messaging;

import org.nr.reviewms.review.Review;
import org.nr.reviewms.review.dto.ReviewMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review) {
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(reviewMessage.getId());
        reviewMessage.setTitle(reviewMessage.getTitle());
        reviewMessage.setDescription(reviewMessage.getDescription());
        reviewMessage.setRating(reviewMessage.getRating());
        reviewMessage.setCompanyId(reviewMessage.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);
    }
}
