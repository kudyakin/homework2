package com.kudiukin.homework2;

import com.kudiukin.homework2.service.QuizService;
import com.kudiukin.homework2.service.QuizServiceImpl;
import com.kudiukin.homework2.service.UserService;
import com.kudiukin.homework2.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationQuiz {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationQuizConfiguration.class);

        UserService userService = (UserService) context.getBean("userService");
        QuizService quizService = (QuizService) context.getBean("quizService");

        userService.askUserNameAndSurname();

        quizService.quiz();
    }
}
