package com.yazdanfar.assignment.dto.csv;

import com.yazdanfar.assignment.dao.BaseEntity;
import com.yazdanfar.assignment.dao.ExerciseEntity;
import com.yazdanfar.assignment.dto.BaseBean;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class ExerciseBean extends BaseBean {

    private Long id;

    private String source;

    private String codeListCode;

    private String code;

    private String displayValue;

    private String longDescription;

    private String fromDate;

    private String toDate;

    private Integer sortingPriority;

    @Override
    public BaseEntity toEntity() {
        throw new RuntimeException("not  implemented");
    }


    public static ExerciseBean fromEntity(ExerciseEntity entity) {
        if (entity == null) {
            return null;
        }
        ExerciseBean exerciseBean = new ExerciseBean();
        exerciseBean.setId(entity.getId());
        exerciseBean.setSource(entity.getSource());
        exerciseBean.setCodeListCode(entity.getCodeListCode());
        exerciseBean.setCode(entity.getCode());
        exerciseBean.setDisplayValue(entity.getDisplayValue());
        exerciseBean.setLongDescription(entity.getLongDescription());
        exerciseBean.setFromDate(entity.getFromDate());
        exerciseBean.setToDate(entity.getToDate());
        exerciseBean.setSortingPriority(entity.getSortingPriority());

        return exerciseBean;
    }
}
