package com.itgroup.data.collector;

import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.model.dto.page.PageContentDto;

import java.util.List;

public interface CollectorFinder {

    PageContentDto<?> getData(String tableName, List<FilterParam> filterParams, PageParam pageParams);
}
