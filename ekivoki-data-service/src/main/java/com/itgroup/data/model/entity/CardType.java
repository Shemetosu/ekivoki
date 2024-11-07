package com.itgroup.data.model.entity;

import com.itgroup.data.model.entity.parent.NameEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardType extends NameEntity {

    private Integer dice;
    private String description;
}
