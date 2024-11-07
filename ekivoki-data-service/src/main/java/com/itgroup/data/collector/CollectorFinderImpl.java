package com.itgroup.data.collector;

import com.itgroup.data.collector.table.DataCollector;
import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.page.PageDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
class CollectorFinderImpl implements CollectorFinder {

    public PageContentDto<?> getData(String tableName, List<FilterParam> filterParams, PageParam pageParams) {
        DataCollector<?> dataCollector = findImplementation(tableName);
        return dataCollector == null
                ? new PageContentDto<>(new PageDto(), List.of())
                : dataCollector.getData(pageParams, filterParams);
    }

    private DataCollector<?> findImplementation(String name) {
        Map<String, DataCollector> beans = ApplicationContextHandler.getContext().getBeansOfType(DataCollector.class);
        for (DataCollector<?> dataCollector : beans.values()) {
            if (dataCollector.getClass().getAnnotation(Collector.class).value().equalsIgnoreCase(name)) {
                return dataCollector;
            }
        }
        return null;
    }
}
