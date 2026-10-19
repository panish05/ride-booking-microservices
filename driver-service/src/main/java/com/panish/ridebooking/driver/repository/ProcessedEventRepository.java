package com.panish.ridebooking.driver.repository;
import com.panish.ridebooking.driver.domain.ProcessedEvent;import org.springframework.data.jpa.repository.JpaRepository;
public interface ProcessedEventRepository extends JpaRepository<ProcessedEvent,String>{}