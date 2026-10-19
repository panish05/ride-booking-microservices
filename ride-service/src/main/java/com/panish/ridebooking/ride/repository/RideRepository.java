package com.panish.ridebooking.ride.repository;
import com.panish.ridebooking.ride.domain.Ride; import org.springframework.data.jpa.repository.JpaRepository;
public interface RideRepository extends JpaRepository<Ride,Long> {}