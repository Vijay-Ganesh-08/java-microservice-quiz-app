package org.springboot.quizservice.model;

import lombok.Data;

@Data
public class QuestionWrapper {

    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

}
