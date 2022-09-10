package com.kudiukin.homework2.service;

import com.kudiukin.homework2.LanguageHandler;
import com.kudiukin.homework2.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Getter
@Setter
@Service
public class UserService {

    @Autowired
    private User user;

    @Autowired
    private LanguageHandler languageHandler;

    public void askUserNameAndSurname() {
        Scanner scanner = new Scanner(System.in);
        boolean isFilled = false;
        while (!isFilled) {
            System.out.println(languageHandler.getBundle().getString("name"));
            user.setName(scanner.nextLine());
            System.out.println(languageHandler.getBundle().getString("surname"));
            user.setSurname(scanner.nextLine());
            if (checkUser()) {
                isFilled = true;
            } else {
                System.out.println(languageHandler.getBundle().getString("wrongInfo"));
            }
        }
    }

    public Boolean checkUser() {
        return !user.getName().isEmpty() && !user.getSurname().isEmpty();
    }

}