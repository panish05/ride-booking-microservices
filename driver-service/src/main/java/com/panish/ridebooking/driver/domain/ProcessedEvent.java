package com.panish.ridebooking.driver.domain;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="processed_events") public class ProcessedEvent {@Id private String eventId;@Column(nullable=false)private Instant processedAt=Instant.now();protected ProcessedEvent(){}public ProcessedEvent(String id){eventId=id;}}