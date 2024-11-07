package com.itgroup.user.rest.feign;

import com.itgroup.model.dto.request.UserCardCreateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        contextId = "dataServiceClient",
        value = "dataServiceClient",
        url = "${spring.cloud.openfeign.client.config.cards.url}"
)
public interface DataServiceClient {

    @PostMapping
    boolean createCard(@RequestBody UserCardCreateDto dto);
}
