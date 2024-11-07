package com.itgroup.data.controller;

import com.itgroup.data.collector.CollectorFinder;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.util.RequestParamParser;
import com.itgroup.model.dto.page.PageContentDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/data/tables")
public class TableDataController {

    private final CollectorFinder collector;

    /*
     * пример запросов:
     * http://localhost:8080/api/tables/data?tableName=user
     * http://localhost:8080/api/tables/data?tableName=user&pageNumber=1&pageSize=2
     * http://localhost:8080/api/tables/data?tableName=user&pageNumber=1&pageSize=2&sortField=name
     * http://localhost:8080/api/tables/data?tableName=user&pageNumber=1&pageSize=2&sortField=name&fieldName=name&fieldValue=user2
     * http://localhost:8080/api/tables/data?tableName=user&pageNumber=1&pageSize=2&sortField=name&fieldName=id&fieldValue=2&fieldName=name&fieldValue=user2
     * http://localhost:8080/api/tables/data?tableName=user&pageNumber=1&pageSize=4&fieldName=name&fieldValue=user1;user2;user3
     */
    @GetMapping
    public ResponseEntity<PageContentDto<?>> getData(@RequestParam String tableName,
                                                     @RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                                     @RequestParam(value = "pageSize", required = false, defaultValue = "100") int pageSize,
                                                     @RequestParam(value = "sortOrder", required = false, defaultValue = "asc") String sortOrder,
                                                     @RequestParam(value = "sortField", required = false, defaultValue = "") String sortField,
                                                     HttpServletRequest request) {
        var pageParams = new PageParam(pageNumber, pageSize, sortOrder, sortField);
        var filterParams = RequestParamParser.buildFilterObjects(request);
        var collection = collector.getData(tableName, filterParams, pageParams);
        return collection != null ? ResponseEntity.ok(collection) : ResponseEntity.badRequest().build();
    }

    /*
     * при обращении без параметров фильтрации:
     * в клиентах по коду отправлять пустую карту: Map.of()
     * в swagger в поле объекта отправлять пустой: {}
     */
    @PostMapping
    public ResponseEntity<PageContentDto<?>> getData(@RequestParam String tableName,
                                                     @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                                                     @RequestParam(value = "pageSize", defaultValue = "100") int pageSize,
                                                     @RequestParam(value = "sortOrder", defaultValue = "asc") String sortOrder,
                                                     @RequestParam(value = "sortField", defaultValue = "") String sortField,
                                                     @RequestBody Map<String, String> parameterMap) {
        var pageParams = new PageParam(pageNumber, pageSize, sortOrder, sortField);
        var filterParams = RequestParamParser.buildFilterObjects(parameterMap);
        var collection = collector.getData(tableName, filterParams, pageParams);
        return collection != null
                ? ResponseEntity.ok(collection)
                : ResponseEntity.badRequest().build();
    }
}
