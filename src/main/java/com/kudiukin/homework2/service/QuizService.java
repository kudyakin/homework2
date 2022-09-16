package com.kudiukin.homework2.service;

public interface QuizService {

    void quiz();

    boolean checkAnswer(String answer);

    String askQuestion();
}
