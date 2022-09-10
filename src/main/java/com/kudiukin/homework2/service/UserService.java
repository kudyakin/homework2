package com.kudiukin.homework2.service;

import com.kudiukin.homework2.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
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

        System.out.println(languageHandler.getBundle().getString("name"));
        user.setName(scanner.nextLine());
        System.out.println(languageHandler.getBundle().getString("surname"));
        user.setSurname(scanner.nextLine());
        checkUser();
    }

        private void checkUser() {
            if (user.getName().isEmpty() || user.getSurname().isEmpty()) {
                throw new IllegalArgumentException(languageHandler.getBundle().getString("wrongInfo"));
            }
        }

}