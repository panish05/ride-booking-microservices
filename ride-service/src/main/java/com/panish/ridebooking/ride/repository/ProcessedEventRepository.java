package com.panish.ridebooking.ride.repository;
import com.panish.ridebooking.ride.domain.ProcessedEvent; import org.springframework.data.jpa.repository.JpaRepository;
public interface ProcessedEventRepository extends JpaRepository<ProcessedEvent,String>{}