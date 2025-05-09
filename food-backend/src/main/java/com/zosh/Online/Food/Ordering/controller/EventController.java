package com.zosh.Online.Food.Ordering.controller;

import com.zosh.Online.Food.Ordering.model.Event;
import com.zosh.Online.Food.Ordering.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("admin/restaurants/{restaurantId}")
    public ResponseEntity<Event> createEvent(@RequestBody Event event,
                                             @PathVariable Long restaurantId) {
        Event created = eventService.createEvent(event, restaurantId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("admin/restaurants/{restaurantId}")
    public ResponseEntity<List<Event>> getEventsByRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(eventService.getEventByRestaurant(restaurantId));
    }

    @DeleteMapping("admin/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted successfully");
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

}
