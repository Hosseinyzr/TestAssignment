package com.yazdanfar.assignment.dto.csv;

import com.yazdanfar.assignment.dto.ResponseMessageDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseRequestDTO extends ResponseMessageDTO {
    private ExerciseBean exerciseBean;
}
