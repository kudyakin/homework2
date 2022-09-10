package com.kudiukin.homework2.service;

import com.kudiukin.homework2.FileReader;
import com.kudiukin.homework2.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Getter
@Setter
@Service
public class QuizService {
    @Autowired
    private FileReader fileReader;

    @Autowired
    private User user;

    @Autowired
    private LanguageHandler languageHandler;
    private int score;
    private int number;

    private Locale locale;

    public void quiz() {
        Scanner scanner = new Scanner(System.in);
        for (number = 0; number < fileReader.getRecords().size(); number++){
            System.out.println(languageHandler.getBundle().getString("question")+askQuestion());
            if (checkAnswer(scanner.nextLine())) {
                score++;
            }
        }
        System.out.println("\n" + user.getName() + " " + user.getSurname() + "\n"
                + languageHandler.getBundle().getString("score") + score + " " + languageHandler.getBundle().getString("outOfPossible") + fileReader.getRecords().size());
    }

    private boolean checkAnswer(String answer) {
        return fileReader.getRecords().get(number).get(6).equals(answer);
    }

    private String askQuestion() {
        List<String> record = fileReader.getRecords().get(number);
        return record.get(1) +"\n" + String.join(
                ", ", record.get(2)+ "\n"+ record.get(3)+"\n"+ record.get(4)+"\n"+ record.get(5)+"."+"\n"+ languageHandler.getBundle().getString("numberOfAnswer")) ;
    }
}
