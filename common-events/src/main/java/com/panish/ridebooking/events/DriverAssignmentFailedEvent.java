package com.panish.ridebooking.events;

public record DriverAssignmentFailedEvent(String eventId, Long rideId, String reason) {}
