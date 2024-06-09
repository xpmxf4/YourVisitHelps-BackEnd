package com.example.viewcountbackend.controller;

import com.example.viewcountbackend.dto.response.*;
import com.example.viewcountbackend.service.*;
import jakarta.servlet.http.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/visitors")
public class VisitorController {
    private final VisitorService visitorService;

    @PostMapping
    public ResponseEntity<ApiResponseBody<Void>> incrementVisitor(
                                                                  @RequestHeader("User-Agent") String userAgent,
                                                                  HttpServletRequest request) {
        log.info("=============================================" + request.getRemoteAddr());
        visitorService.incrementVisitorCount(request.getRemoteAddr(), userAgent);
        return ResponseEntity.ok(ApiResponseBody.ok(null));
    }

    @GetMapping("/count")
    public ResponseEntity<ApiResponseBody<VisitorResponseDTO>> getVisitorCount() {
        long count = visitorService.getCurrentVisitorCount();
        VisitorResponseDTO response = new VisitorResponseDTO(count);
        return ResponseEntity.ok(ApiResponseBody.ok(response));
    }

    // 특정 기간 동안의 방문자 수 조회 예시
    @GetMapping("/count/date-range")
    public ResponseEntity<ApiResponseBody<Long>> getVisitorCountByDateRange(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        long count = visitorService.getVisitorCountByDate(startDate, endDate);
        return ResponseEntity.ok(ApiResponseBody.ok(count));
    }
}
