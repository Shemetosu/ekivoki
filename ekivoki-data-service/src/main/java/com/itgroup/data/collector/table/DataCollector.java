package com.itgroup.data.collector.table;

import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.service.CollectorService;
import com.itgroup.model.dto.page.PageContentDto;
import com.itgroup.model.dto.page.PageDto;

import java.util.List;

public abstract class DataCollector<E> {

    public CollectorService<E> service;

    public void setService(CollectorService<E> service) {
        this.service = service;
    }

    /*
     * над реализацией добавить аннотацию @PostConstruct
     */
    public abstract void init();

    public abstract PageContentDto<E> getData(PageParam pageParams, List<FilterParam> filterParams);

    protected PageContentDto<E> getData(PageParam pageParams, String queryTail) {
        return returnPageContent(
                pageParams,
                service.count(),
                service.findAll(queryTail)
        );
    }

    private PageContentDto<E> returnPageContent(PageParam pageParams, long count, List<E> list) {
        return new PageContentDto<>(
                new PageDto(
                        pageParams.getPageNumber(),
                        pageParams.getPageSize(),
                        Math.max((int) count / pageParams.getPageSize(), 1),
                        count
                ),
                list
        );
    }
}