package com.itgroup.data.collector.table.impl;

import com.itgroup.data.collector.Collector;
import com.itgroup.data.collector.filter.impl.CardFilter;
import com.itgroup.data.collector.table.DataCollector;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.service.CommonService;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.CardDto;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Collector(value = "card")
class CardDataCollectorImpl extends DataCollector<CardDto> {

    private final CommonService<CardDto, ?, ?> service;

    @PostConstruct
    @Override
    public void init() {
        setService(service);
    }

    @Override
    public PageContentDto<CardDto> getData(PageParam pageParams, List<FilterParam> filterParams) {
        return super.getData(pageParams, new CardFilter(filterParams, pageParams).buildQueryTail());
    }
}