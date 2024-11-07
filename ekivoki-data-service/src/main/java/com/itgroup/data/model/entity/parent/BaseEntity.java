package com.itgroup.data.model.entity.parent;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {

    private UUID id;
}
