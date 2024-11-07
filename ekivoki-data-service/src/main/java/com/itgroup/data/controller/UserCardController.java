package com.itgroup.data.controller;

import com.itgroup.data.service.UserCardService;
import com.itgroup.model.dto.request.UserCardCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/data/users/cards")
public class UserCardController {

    private final UserCardService service;

    @PostMapping
    public boolean createCard(UserCardCreateDto dto) {
        return service.createCard(dto);
    }
}
