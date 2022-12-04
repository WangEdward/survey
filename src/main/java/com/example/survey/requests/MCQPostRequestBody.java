package com.example.survey.requests;

import com.example.survey.model.MCQ;
import com.example.survey.model.SingleOption;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MCQPostRequestBody implements Serializable{

    private static final long serialVersionUID = -4040516302734722943L;

    @Schema(description = "Description of the question", example = "Do you often feel more nervous and anxious than usual?")
    @NotEmpty(message = "field QUESTION DETAIL is mandatory")
    @Length(max = 4000, message = "field QUESTION DETAIL is too long. Maximum range is 4000 characters.")
    private String questionDetail;

    @Schema(description = "List of possible options")
    @NotEmpty(message = "The option list can not be empty")
    private List<
            @Valid SingleOption> options;


}
