package com.itgroup.user.rest.feign;

import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
        contextId = "topicServiceClient",
        value = "topicServiceClient",
        url = "${spring.cloud.openfeign.client.config.tables.url}"
)
public interface TopicServiceClient {

    @PostMapping
    PageContentDto<CardTopicDto> topics(@RequestParam String tableName,
                                        @RequestParam int pageNumber,
                                        @RequestParam String sortField,
                                        @RequestBody Map<String, String> parameterMap);
}
