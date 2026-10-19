package com.panish.ridebooking.events;

public record RideRequestedEvent(String eventId, Long riderId, String pickup, String dropoff) {}
