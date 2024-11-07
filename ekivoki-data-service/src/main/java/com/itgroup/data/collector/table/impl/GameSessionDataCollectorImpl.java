package com.itgroup.data.collector.table.impl;

import com.itgroup.data.collector.Collector;
import com.itgroup.data.collector.filter.impl.GameSessionFilter;
import com.itgroup.data.collector.table.DataCollector;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.service.GameSessionService;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.responce.GameSessionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
@Collector(value = "game_session")
public class GameSessionDataCollectorImpl extends DataCollector<GameSessionDto> {

    private final GameSessionService service;

    @Override
    public void init() {
        setService(service);
    }

    @Override
    public PageContentDto<GameSessionDto> getData(PageParam pageParams, List<FilterParam> filterParams) {
        return super.getData(pageParams, new GameSessionFilter(filterParams, pageParams).buildQueryTail());
    }
}
