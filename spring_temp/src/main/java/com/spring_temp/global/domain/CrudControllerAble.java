package com.spring_temp.global.domain;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudControllerAble<Request, Response> {

    ResponseEntity<Response> save(Request request);
    ResponseEntity<List<Response>> findAll();
    ResponseEntity<Response> findById(String id);
    ResponseEntity delete(String id);
    ResponseEntity<Response> update(String id, Request request);
}
