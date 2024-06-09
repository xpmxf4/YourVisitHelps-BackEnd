package com.example.viewcountbackend.dto.response;

import lombok.*;

@Getter
public class VisitorResponseDTO {
    private long visitorCount;

    public VisitorResponseDTO(long count) {
        this.visitorCount = count;
    }
}
