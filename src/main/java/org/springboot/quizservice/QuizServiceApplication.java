package org.springboot.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class QuizServiceApplication {

    /**
     * EnableFeignClients is used to connect to the other
     * MicroServices Registered in Eureka Client
     */


    public static void main(String[] args) {
        SpringApplication.run(QuizServiceApplication.class, args);
    }

}
