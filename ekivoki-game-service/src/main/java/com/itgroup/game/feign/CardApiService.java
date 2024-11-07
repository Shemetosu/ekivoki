package com.itgroup.game.feign;

import com.itgroup.model.dto.responce.CardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(
        contextId = "cardClient",
        value = "cardApiService",
        url = "${spring.cloud.openfeign.client.config.cards.url}/pairs"
)
public interface CardApiService {

    @GetMapping
    List<CardDto> get2Cards(@RequestParam UUID sessionId,
                            @RequestParam int dice);
}
