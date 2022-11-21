package com.yazdanfar.assignment.dto.csv;

import com.yazdanfar.assignment.dto.ResponseMessageDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseResponseDTO extends ResponseMessageDTO {
    private ExerciseBean exerciseBean;
}
