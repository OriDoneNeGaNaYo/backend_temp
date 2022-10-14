package com.spring_temp.node.dto;

import com.spring_temp.node.domain.Node;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class NodeResponseDto {
    private String id;

    private String city;
    private String name;
    private String ename;


    private String gpsLati;
    private String gpsLong;


    private Boolean isDeleted;
    private LocalDateTime collectedAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static NodeResponseDto of(Node node) {
        return NodeResponseDto.builder()
                .id(node.getId())
                .city(node.getCity())
                .name(node.getName())
                .ename(node.getEname())
                .gpsLati(node.getGpsLati())
                .gpsLong(node.getGpsLong())
                .isDeleted(node.getIsDeleted())
                .collectedAt(node.getCollectedAt())
                .createdAt(node.getCreatedAt())
                .updatedAt(node.getUpdatedAt())
                .build();
    }
}
