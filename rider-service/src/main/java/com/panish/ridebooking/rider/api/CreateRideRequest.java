package com.panish.ridebooking.rider.api;
import jakarta.validation.constraints.NotBlank; import jakarta.validation.constraints.NotNull;
public record CreateRideRequest(@NotNull Long riderId, @NotBlank String pickup, @NotBlank String dropoff) {}