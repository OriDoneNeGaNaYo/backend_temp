package com.spring_temp.global.domain;

import java.util.List;

public interface CrudAble<Request, Response> {

    Response save(Request request);

    List<Response> findAll();

    Response findById(String id);

    void deleteById(String id);

    Response update(String id, Request request);
}
