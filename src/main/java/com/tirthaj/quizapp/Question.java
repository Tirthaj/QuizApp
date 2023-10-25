package com.tirthaj.quizapp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @SequenceGenerator(name = "id_generator",allocationSize = 1)
    @GeneratedValue(generator = "id_generator", strategy = GenerationType.IDENTITY)
    private int id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;


}
