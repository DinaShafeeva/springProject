package ru.itis.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.first.config.ApplicationContextConfig;
import ru.itis.first.interpretator.Interpretator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        Interpretator interpretator = new Interpretator();
        Scanner scanner = new Scanner(System.in);
        String newString = interpretator.interpretate(applicationContext, scanner.nextLine());
        while (!(newString.equals("stop"))){
            System.out.println(newString);
            newString = interpretator.interpretate(applicationContext, scanner.nextLine());
        }
    }
}
