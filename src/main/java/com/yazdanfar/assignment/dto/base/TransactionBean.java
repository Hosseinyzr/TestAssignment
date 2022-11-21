package com.yazdanfar.assignment.dto.base;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
//@ToString
public class TransactionBean implements Bean {

    private String ip;

    private String method;

    private Integer pageNumber;

    private Integer pageRecordCount;

    private Date createAt;

    private LanguageBean languageBean;

    private FrontChannelBean frontChannelBean;

    private List<String> authorities;

    private String role;

}
