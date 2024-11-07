package com.itgroup.data.controller;

import com.itgroup.data.service.GameSessionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/data/sessions")
public class GameSessionController {

    private final GameSessionService service;

    @PostMapping
    public UUID createSession() {
        return service.createSession();
    }

    @GetMapping
    public boolean existsById(@RequestParam UUID id) {
        return service.existsById(id);
    }
}
