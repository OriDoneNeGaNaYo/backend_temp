package com.spring_temp.node.domain;

import com.spring_temp.node.dto.NodeRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Node {

    @Id
    private String id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String ename;


    @Column(nullable = false)
    private String gpsLati;

    @Column(nullable = false)
    private String gpsLong;


    @Column(nullable = false)
    private Boolean isDeleted = false;

    @Column(nullable = false)
    private LocalDateTime collectedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Node update(NodeRequestDto requestDto){
        this.id = requestDto.getId();
        this.city = requestDto.getCity();
        this.name = requestDto.getName();
        this.ename = requestDto.getEname();
        this.gpsLati = requestDto.getGpsLati();
        this.gpsLong = requestDto.getGpsLong();
        this.collectedAt = requestDto.getCollectedAt();
        return this;
    }
}
