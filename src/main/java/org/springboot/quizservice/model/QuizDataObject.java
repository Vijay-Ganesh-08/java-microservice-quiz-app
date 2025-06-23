package org.springboot.quizservice.model;

import lombok.Data;

@Data
public class QuizDataObject {

    private String category;
    private int numQuestion;
    private String title;
}
