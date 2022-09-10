package com.kudiukin.homework2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.annotation.PostConstruct;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

@Getter
@Setter
public class LanguageHandler {

    private ResourceBundle bundle;

    private Locale locale;

    @PostConstruct
    public void setApplicationLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language (en, pl, est):");
        String answer = scanner.nextLine();
        locale = new Locale(answer);
        bundle = ResourceBundle.getBundle("language", locale);
    }
}
