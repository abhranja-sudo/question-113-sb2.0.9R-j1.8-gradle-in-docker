package org.codejudge.sb.payload;

import org.codejudge.sb.model.Quiz;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class QuestionRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String options;
    @NotBlank
    private String correct_option;
    @NotNull
    private Long quiz;
    @NotBlank
    private String points;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getCorrect_option() {
        return correct_option;
    }

    public void setCorrect_options(String correct_options) {
        this.correct_option = correct_options;
    }

    public Long getQuiz() {
        return quiz;
    }

    public void setQuiz(Long quiz) {
        this.quiz = quiz;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
