package com.portfolio.EduSilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
    EduSilvaApplication.class,
    Jsr310JpaConverters.class
})
public class EduSilvaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduSilvaApplication.class, args);
    }

}
