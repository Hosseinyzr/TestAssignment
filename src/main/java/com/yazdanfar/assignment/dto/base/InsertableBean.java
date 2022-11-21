package com.yazdanfar.assignment.dto.base;

import com.yazdanfar.assignment.dto.BaseBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class InsertableBean extends BaseBean {

    private String createAt;
}
