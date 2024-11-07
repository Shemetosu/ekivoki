package com.itgroup.data.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageParam {

    private int pageNumber;
    private int pageSize;
    private String sortOrder;
    private String sortField;
}
