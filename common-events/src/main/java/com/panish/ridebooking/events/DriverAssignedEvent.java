package com.panish.ridebooking.events;

public record DriverAssignedEvent(String eventId, Long rideId, Long driverId, String driverName) {}
