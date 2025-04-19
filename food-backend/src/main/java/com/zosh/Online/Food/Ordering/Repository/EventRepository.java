package com.zosh.Online.Food.Ordering.Repository;

import com.zosh.Online.Food.Ordering.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByRestaurantId(Long RestaurantId);
}
