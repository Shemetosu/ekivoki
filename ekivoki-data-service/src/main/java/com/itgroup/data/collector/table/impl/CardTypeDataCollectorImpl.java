package com.itgroup.data.collector.table.impl;

import com.itgroup.data.collector.Collector;
import com.itgroup.data.collector.filter.impl.CardTypeFilter;
import com.itgroup.data.collector.table.DataCollector;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.service.CommonService;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.CardTypeDto;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Collector(value = "card_type")
public class CardTypeDataCollectorImpl extends DataCollector<CardTypeDto> {

    private final CommonService<CardTypeDto, ?, ?> service;

    @PostConstruct
    @Override
    public void init() {
        setService(service);
    }

    @Override
    public PageContentDto<CardTypeDto> getData(PageParam pageParams, List<FilterParam> filterParams) {
        return super.getData(pageParams, new CardTypeFilter(filterParams, pageParams).buildQueryTail());
    }
}
