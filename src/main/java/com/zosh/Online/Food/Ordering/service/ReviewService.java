package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.model.Review;

import java.util.List;

public interface ReviewService {

    Review createReview(Long userId, Long restaurantId, Review review) throws Exception;

    List<Review> getAllReviewsForRestaurant(Long restaurantId);

    List<Review> getReviewsByUser(Long userId);
}
