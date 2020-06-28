package org.codejudge.sb.payload;

import org.codejudge.sb.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuizAllResponse {

    private String name;
    private String description;
    private List questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getQuestions() {
        return questions;
    }

    public void setQuestions(List questions) {
        this.questions = questions;
    }
}
