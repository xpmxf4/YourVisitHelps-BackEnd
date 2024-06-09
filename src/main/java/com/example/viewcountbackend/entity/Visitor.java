package com.example.viewcountbackend.entity;


import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import java.time.*;

@Getter
@Builder
@Document(collection= "visitors")
public class Visitor {
    @Id
    private final String id;
    private final int count;
    private final String ipAddress;
    private final String userAgent;
    private final LocalDateTime visitTime;
}