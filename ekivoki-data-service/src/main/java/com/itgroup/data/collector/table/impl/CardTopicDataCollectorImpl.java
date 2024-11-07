package com.itgroup.data.collector.table.impl;

import com.itgroup.data.collector.Collector;
import com.itgroup.data.collector.filter.impl.CardTopicFilter;
import com.itgroup.data.collector.table.DataCollector;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.service.CommonService;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.CardTopicDto;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Collector(value = "card_topic")
class CardTopicDataCollectorImpl extends DataCollector<CardTopicDto> {

    private final CommonService<CardTopicDto, ?, ?> service;

    @PostConstruct
    @Override
    public void init() {
        setService(service);
    }

    @Override
    public PageContentDto<CardTopicDto> getData(PageParam pageParams, List<FilterParam> filterParams) {
        return super.getData(pageParams, new CardTopicFilter(filterParams, pageParams).buildQueryTail());
    }
}
