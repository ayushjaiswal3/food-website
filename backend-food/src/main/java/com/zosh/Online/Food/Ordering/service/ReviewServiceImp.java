package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.Repository.RestaurantRepository;
import com.zosh.Online.Food.Ordering.Repository.ReviewRepository;
import com.zosh.Online.Food.Ordering.Repository.UserRepository;
import com.zosh.Online.Food.Ordering.model.Restaurant;
import com.zosh.Online.Food.Ordering.model.Review;
import com.zosh.Online.Food.Ordering.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Review createReview(Long userId, Long restaurantId, Review review) throws Exception {
        // Corrected: use orElseThrow correctly
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("Address not found with id: " + userId));

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new Exception("Address not found with id: " + restaurantId));

        review.setUser(user);
        review.setRestaurant(restaurant);

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviewsForRestaurant(Long restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId); // Fix: lowercase "reviewRepository"
    }

    @Override
    public List<Review> getReviewsByUser(Long userId) {
        return reviewRepository.findByUserId(userId);
    }
}
