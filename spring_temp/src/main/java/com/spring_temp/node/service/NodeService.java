package com.spring_temp.node.service;

import com.spring_temp.global.domain.CrudAble;
import com.spring_temp.global.domain.FindEntityAble;
import com.spring_temp.node.domain.Node;
import com.spring_temp.node.domain.NodeRepository;
import com.spring_temp.node.dto.NodeRequestDto;
import com.spring_temp.node.dto.NodeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NodeService implements
        CrudAble<NodeRequestDto, NodeResponseDto>,
        FindEntityAble<Node> {

    private final NodeRepository repository;

    @Override
    public NodeResponseDto save(
            NodeRequestDto nodeRequestDto
    ) {
        Node node = repository.save(nodeRequestDto.toEntity());
        return NodeResponseDto.of(node);
    }

    @Override
    public List<NodeResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(NodeResponseDto::of)
                .toList();
    }

    @Override
    public NodeResponseDto findById(
            String id
    ) {
        return NodeResponseDto.of(findEntity(id));
    }

    @Override
    public void deleteById(
            String id
    ) {
        repository.deleteById(id);
    }

    @Override
    public NodeResponseDto update(
            String id, NodeRequestDto nodeRequestDto
    ) {
        return NodeResponseDto.of(findEntity(id).update(nodeRequestDto));
    }

    @Override
    public Node findEntity(
            String id
    ) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
