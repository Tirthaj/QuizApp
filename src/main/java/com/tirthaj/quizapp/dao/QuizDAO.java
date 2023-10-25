package com.tirthaj.quizapp.dao;

import com.tirthaj.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface QuizDAO extends JpaRepository<Quiz, Integer> {

}
