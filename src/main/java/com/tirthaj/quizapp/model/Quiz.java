package com.tirthaj.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @SequenceGenerator(name = "seq_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    private int id;
    private String title;
    @ManyToMany
    private List<Question> questions;
}
