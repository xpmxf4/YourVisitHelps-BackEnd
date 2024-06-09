package com.example.viewcountbackend.repository;

import com.example.viewcountbackend.entity.*;
import org.springframework.data.mongodb.repository.*;

import java.time.*;

public interface VisitorRepository extends MongoRepository<Visitor, String> {
    long countByVisitTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
    long countByIpAddress(String ipAddress);
}
