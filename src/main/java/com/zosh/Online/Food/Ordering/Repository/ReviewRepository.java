package com.zosh.Online.Food.Ordering.Repository;

import com.zosh.Online.Food.Ordering.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByRestaurantId(Long restaurantId);

    List<Review> findByUserId(Long userId);
}
