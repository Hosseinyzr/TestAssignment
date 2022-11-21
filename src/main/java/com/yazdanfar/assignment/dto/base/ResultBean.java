package com.yazdanfar.assignment.dto.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultBean implements Bean {

    private Integer code;

    private String responseMessage;

    private String[] idArray;

    private Long totalItemsCount;

    private CustomAppException customAppException;


}
