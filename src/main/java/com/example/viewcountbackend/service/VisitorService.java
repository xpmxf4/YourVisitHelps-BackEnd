package com.example.viewcountbackend.service;

import com.example.viewcountbackend.entity.*;
import com.example.viewcountbackend.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository repository;

    public long getCurrentVisitorCount() {
        return repository.count();
    }

    public void incrementVisitorCount(String ipAddress, String userAgent) {
        Visitor visitor = Visitor.builder()
                .id(null) // MongoDB 가 자동으로 id 생성
                .count(1)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .visitTime(LocalDateTime.now())
                .build();

        repository.save(visitor);
    }

    // 특정 기간 기간 동안의 방문자 수 조회
    public long getVisitorCountByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.countByVisitTimeBetween(startDate, endDate);
    }

    // 특정 IP 주소의 방문자 수 조회
    public long getVisitorCountByIpAddress(String ipAddress) {
        return repository.countByIpAddress(ipAddress);
    }

    // 모든 방문자 정보 조회
    public List<Visitor> getAllVisitors() {
        return repository.findAll();
    }
}
