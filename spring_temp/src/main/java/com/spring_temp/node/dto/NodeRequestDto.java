package com.spring_temp.node.dto;

import com.spring_temp.node.domain.Node;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class NodeRequestDto {

    @NotNull
    private String id;
    @NotNull
    private String city;
    @NotNull
    private String name;
    @NotNull
    private String ename;
    @NotNull
    private String gpsLati;
    @NotNull
    private String gpsLong;
    @NotNull
    private LocalDateTime collectedAt;

    public Node toEntity() {
        return Node.builder()
                .id(id)
                .city(city)
                .name(name)
                .ename(ename)
                .gpsLati(gpsLati)
                .gpsLong(gpsLong)
                .collectedAt(collectedAt)
                .build();
    }
}
