package com.panish.ridebooking.events;

public record RideCreatedEvent(String eventId, Long rideId, Long riderId, double estimatedFare) {}
