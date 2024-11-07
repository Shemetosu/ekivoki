package com.itgroup.data.util;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@UtilityClass
public class PageableUtils {

    public static Pageable buildPageable(int pageNumber, int pageSize, String sortOrder, String sortField) {
        return StringUtils.isEmpty(sortField)
                ? buildPageRequest(pageNumber, pageSize)
                : buildPageRequest(pageNumber, pageSize, sortOrder, sortField);
    }

    private static Pageable buildPageRequest(int pageNumber, int pageSize) {
        return PageRequest.of(
                pageNumber, // from 0
                pageSize
        );
    }

    private static Pageable buildPageRequest(int pageNumber, int pageSize, String sortOrder, String sortField) {
        return PageRequest.of(
                pageNumber, // from 0
                pageSize,
                StringUtils.isEmpty(sortOrder) ? Sort.Direction.ASC : Sort.Direction.fromString(sortOrder),
                sortField
        );
    }
}
