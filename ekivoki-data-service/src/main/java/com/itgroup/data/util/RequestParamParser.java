package com.itgroup.data.util;

import com.itgroup.data.model.dto.FilterParam;
import jakarta.servlet.http.HttpServletRequest;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UtilityClass
public class RequestParamParser {

    private static final String NAME = "fieldName";
    private static final String VALUE = "fieldValue";

    public static List<FilterParam> buildFilterObjects(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (!parameterMap.containsKey(NAME) || !parameterMap.containsKey(VALUE)) {
            return List.of();
        }
        List<FilterParam> filterParams = new ArrayList<>((parameterMap.size() - 1) / 2);
        for (int i = 0; i < parameterMap.get(NAME).length; i++) {
            filterParams.add(new FilterParam(parameterMap.get(NAME)[i], parameterMap.get(VALUE)[i]));
        }
        return filterParams;
    }

    public static List<FilterParam> buildFilterObjects(Map<String, String> parameterMap) {
        if (parameterMap == null || parameterMap.isEmpty()) {
            return List.of();
        }
        List<FilterParam> filterParamList = new ArrayList<>(parameterMap.size());
        for (Map.Entry<String, String> item : parameterMap.entrySet()) {
            filterParamList.add(new FilterParam(item.getKey(), item.getValue()));
        }
        return filterParamList;
    }
}