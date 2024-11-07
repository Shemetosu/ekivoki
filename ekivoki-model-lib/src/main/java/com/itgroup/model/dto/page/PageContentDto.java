package com.itgroup.model.dto.page;

import java.util.List;

public record PageContentDto<E>(
        PageDto page,
        List<E> content
) {
}