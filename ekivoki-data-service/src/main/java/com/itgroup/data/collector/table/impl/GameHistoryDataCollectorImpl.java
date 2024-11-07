package com.itgroup.data.collector.table.impl;

import com.itgroup.data.collector.Collector;
import com.itgroup.data.collector.filter.impl.GameHistoryFilter;
import com.itgroup.data.collector.table.DataCollector;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.service.GameHistoryService;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.GameHistoryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Collector(value = "game_history")
public class GameHistoryDataCollectorImpl extends DataCollector<GameHistoryDto> {

    private final GameHistoryService service;

    @Override
    public void init() {
        setService(service);
    }

    @Override
    public PageContentDto<GameHistoryDto> getData(PageParam pageParams, List<FilterParam> filterParams) {
        return super.getData(pageParams, new GameHistoryFilter(filterParams, pageParams).buildQueryTail());
    }
}
