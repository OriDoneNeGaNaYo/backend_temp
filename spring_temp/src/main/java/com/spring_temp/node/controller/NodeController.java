package com.spring_temp.node.controller;

import com.spring_temp.global.domain.CrudControllerAble;
import com.spring_temp.node.dto.NodeRequestDto;
import com.spring_temp.node.dto.NodeResponseDto;
import com.spring_temp.node.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/node")
@RequiredArgsConstructor
public class NodeController implements
        CrudControllerAble<NodeRequestDto, NodeResponseDto> {
    private final NodeService service;

    @Override
    @PostMapping
    public ResponseEntity<NodeResponseDto> save(
            @RequestBody @Validated NodeRequestDto nodeRequestDto
    ) {
        return new ResponseEntity<>(
                service.save(nodeRequestDto),
                HttpStatus.CREATED
        );
    }

    @Override
    @GetMapping
    public ResponseEntity<List<NodeResponseDto>> findAll() {
        return new ResponseEntity<>(
                service.findAll(),
                HttpStatus.OK
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<NodeResponseDto> findById(
            @PathVariable String id
    ) {
        return new ResponseEntity<>(
                service.findById(id),
                HttpStatus.OK
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable String id
    ) {
        service.deleteById(id);
        return new ResponseEntity<>(
                true,
                HttpStatus.NO_CONTENT
        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<NodeResponseDto> update(
            @PathVariable String id,
            @RequestBody @Validated NodeRequestDto nodeRequestDto
    ) {
        return new ResponseEntity<>(
                service.update(id, nodeRequestDto),
                HttpStatus.CREATED
        );
    }
}
