package com.portfolio.EduSilva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;

//@Controller
@SpringBootApplication
@EntityScan(basePackageClasses = {
    EduSilvaApplication.class,
    Jsr310JpaConverters.class
})
public class EduSilvaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EduSilvaApplication.class, args);
    }
    
     @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
      return application.sources(EduSilvaApplication.class);
   }

}
