package com.zosh.Online.Food.Ordering.service;


import com.zosh.Online.Food.Ordering.model.Event;

import java.util.List;

public interface EventService {

    Event createEvent(Event event, Long restaurantId);
    List<Event> getEventByRestaurant(Long restaurantId);
    void deleteEvent(Long eventId);
    List<Event> getAllEvents();
}
