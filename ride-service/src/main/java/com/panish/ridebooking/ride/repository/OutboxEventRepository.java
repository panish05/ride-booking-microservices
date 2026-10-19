package com.panish.ridebooking.ride.repository;
import com.panish.ridebooking.ride.domain.OutboxEvent; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface OutboxEventRepository extends JpaRepository<OutboxEvent,String>{List<OutboxEvent> findTop100ByPublishedFalseOrderByCreatedAtAsc();}