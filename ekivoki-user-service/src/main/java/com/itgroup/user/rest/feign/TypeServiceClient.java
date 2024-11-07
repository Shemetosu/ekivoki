package com.itgroup.user.rest.feign;

import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
        contextId = "typeServiceClient",
        value = "typeServiceClient",
        url = "${spring.cloud.openfeign.client.config.tables.url}"
)
public interface TypeServiceClient {

    @PostMapping
    PageContentDto<CardTypeDto> types(@RequestParam String tableName,
                                      @RequestParam String sortField,
                                      @RequestBody Map<String, String> parameterMap);
}
