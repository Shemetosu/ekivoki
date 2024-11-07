package com.itgroup.data.collector.filter;

import com.itgroup.data.model.dto.FilterParam;
import com.itgroup.data.model.dto.PageParam;
import com.itgroup.data.util.StringUtils;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public abstract class DataFilter {

    private static final String IN_SEPARATOR = ";";
    private static final String AND = "AND ";

    private final List<FilterParam> filterParams;
    private final PageParam pageParams;

    public String buildQueryTail() {
        var tail = new StringBuilder();
        // формирование параметров запроса
        for (var filterParam : filterParams) {
            if (StringUtils.isDigit(filterParam.getValue())) {
                addDigit(tail, filterParam);
            } else if (filterParam.getValue().contains(IN_SEPARATOR)) {
                addIn(tail, filterParam);
            } else {
                addString(tail, filterParam);
            }
            tail.append(AND);
        }
        // блок условий
        addWhere(tail);
        // сортировка
        addSorting(tail);
        // пагинация
        addPagination(tail);
        return tail.toString();
    }

    void addWhere(StringBuilder tail) {
        if (tail.length() > 5) {
            if (tail.lastIndexOf(AND) == tail.length() - AND.length()) {
                tail.setLength(tail.length() - 5);
            }
            tail.insert(0, " WHERE ");
        }
    }

    public void addDigit(StringBuilder tail, FilterParam filterParam) {
        tail
                .append(filterParam.getName())
                .append(" = ")
                .append(filterParam.getValue())
                .append(" ");
    }

    public void addIn(StringBuilder tail, FilterParam filterParam) {
        var valueArray = filterParam.getValue().split(IN_SEPARATOR);
        var isStringArray = false;
        for (String value : valueArray) {
            if (StringUtils.isNotDigit(value)) {
                isStringArray = true;
                break;
            }
        }
        if (isStringArray) {
            for (int i = 0; i < valueArray.length; i++) {
                valueArray[i] = String.join(valueArray[i], "'", "'");
            }
        }
        var values = new StringBuilder();
        for (String value : valueArray) {
            values.append(value).append(",");
        }
        values.setLength(values.length() - 1);
        tail
                .append(filterParam.getName())
                .append(" IN (")
                .append(values)
                .append(") ");
    }

    public void addString(StringBuilder tail, FilterParam filterParam) {
        tail
                .append(filterParam.getName())
                .append(" LIKE '")
                .append(filterParam.getValue())
                .append("' ");
    }

    public void addSorting(StringBuilder tail) {
        if (StringUtils.isNotEmpty(pageParams.getSortField())) {
            tail
                    .append(" ORDER BY ")
                    .append(pageParams.getSortField())
                    .append(" ")
                    .append(pageParams.getSortOrder().toUpperCase());
        }
    }

    public void addPagination(StringBuilder tail) {
        tail
                .append(" LIMIT ")
                .append(pageParams.getPageSize())
                .append(" OFFSET ")
                .append(getOffset(pageParams.getPageNumber(), pageParams.getPageSize()));
    }

    public int getOffset(int pageNumber, int pageSize) {
        return pageNumber <= 1 ? 0 : pageNumber * pageSize - pageSize;
    }
}
