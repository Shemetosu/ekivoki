package com.itgroup.data.collector.filter.impl;

import com.itgroup.data.collector.filter.DataFilter;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;

import java.util.List;

public class GameHistoryFilter extends DataFilter {

    public GameHistoryFilter(List<FilterParam> filterParams, PageParam pageParams) {
        super(filterParams, pageParams);
    }
}
