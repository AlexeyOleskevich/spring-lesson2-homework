package ru.gb.springlesson1homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConf {
    @Bean
    StudentRepository myStudentRepository() {
        return new StudentRepository();
    }
}
