package com.itgroup.game.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@FeignClient(
        contextId = "gameSessionClient",
        value = "gameSessionApiService",
        url = "${spring.cloud.openfeign.client.config.sessions.url}"
)
public interface GameSessionApiService {

    @PostMapping
    UUID createSession();

    @GetMapping
    boolean existsById(@RequestParam UUID id);
}
