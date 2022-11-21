package com.yazdanfar.assignment.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UpdatableBean extends  InsertableBean {

    private String updateAt;
}
