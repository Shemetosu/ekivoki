package com.itgroup.data.controller;

import com.itgroup.data.service.CommonService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public abstract class CommonController<R, C, U> {

    @Getter
    private final CommonService<R, C, U> service;

    @GetMapping
    public R findOne(UUID id) {
        return service.findById(id);
    }

    @PostMapping
    public R create(C dto) {
        return service.create(dto);
    }

    @PutMapping
    public R update(U dto) {
        return service.update(dto);
    }

    @DeleteMapping
    public void remove(UUID id) {
        service.remove(id);
    }
}
