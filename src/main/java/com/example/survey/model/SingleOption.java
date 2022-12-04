package com.example.survey.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
public class SingleOption {
    @Schema(description = "Description of an option", example = "Some of the time.")
    @NotEmpty(message = "field OPTION DETAIL is mandatory")
    @Length(max = 4000, message = "field OPTION DETAIL is too long. Maximum range is 4000 characters.")
    private String optionDetail;

    //score can be null,representing is is zero mark
    @Schema(description = "Score if this option was selected", example = "1.5")
    private float score;

    @Schema(description = "If this is the correct option", example = "true")
    private boolean isCorrect;
//    public String getOptionDetail() {
//        return optionDetail;
//    }
//    public void setOptionDetail(String optionDetail) {
//        this.optionDetail = optionDetail;
//    }
//    public float getScore() {
//        return score;
//    }
//    public void setScore(float score) {
//        this.score = score;
//    }
//    public boolean isCorrect() {
//        return isCorrect;
//    }
//    public void setCorrect(boolean isCorrect) {
//        this.isCorrect = isCorrect;
//    }

}
