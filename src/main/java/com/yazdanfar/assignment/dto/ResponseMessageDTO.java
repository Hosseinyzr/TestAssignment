package com.yazdanfar.assignment.dto;

import com.yazdanfar.assignment.dto.base.CustomAppException;
import com.yazdanfar.assignment.dto.base.ResultBean;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessageDTO extends MessageDTO {

    private ResultBean resultBean;


    public void setSuccess() {
        setSuccess("successful");
    }

    public void setSuccess(String responseMessage) {
        if (resultBean == null)
            resultBean = new ResultBean();

        resultBean.setCode(0);
        resultBean.setResponseMessage(responseMessage);
    }


    public void setFailure(Exception e) {
        if (resultBean == null)
            resultBean = new ResultBean();

        resultBean.setCode(-1);
        if (e instanceof CustomAppException) {
            resultBean.setCode(((CustomAppException) e).getCode());
        }
        var customAppException = new CustomAppException(e);

        customAppException.setCode(resultBean.getCode());
        resultBean.setCustomAppException(customAppException);
    }

    public void setResultBeanIdList(String... idArray) {
        if (resultBean == null)
            resultBean = new ResultBean();

        resultBean.setIdArray(idArray);
    }

    public void setTotalItemsCount(Long totalItemsCount) {
        if (resultBean == null)
            resultBean = new ResultBean();

        resultBean.setTotalItemsCount(totalItemsCount);
    }
}
