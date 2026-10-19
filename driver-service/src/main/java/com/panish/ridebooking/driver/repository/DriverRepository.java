package com.panish.ridebooking.driver.repository;
import com.panish.ridebooking.driver.domain.Driver;import org.springframework.data.jpa.repository.JpaRepository;import java.util.Optional;
public interface DriverRepository extends JpaRepository<Driver,Long>{Optional<Driver> findFirstByStatusOrderByIdAsc(String status);}