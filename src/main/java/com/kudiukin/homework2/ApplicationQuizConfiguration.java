package com.kudiukin.homework2;

import com.kudiukin.homework2.service.QuizService;
import com.kudiukin.homework2.service.QuizServiceImpl;
import com.kudiukin.homework2.service.UserService;
import com.kudiukin.homework2.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationQuizConfiguration {

    private static final String FILE_PATH = "questions.csv";

    @Bean(name = "userService")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "languageHandler")
    public LanguageHandler languageHandler() {
        return new LanguageHandler();
    }

    @Bean(name = "user")
    public User user() {
        return new User();
    }

    @Bean(name = "quizService")
    public QuizService quizService() {
        return new QuizServiceImpl();
    }

    @Bean(name = "fileReader")
    public FileReader fileReader() {
        return new FileReader(FILE_PATH);
    }
}