package org.odk.g1.pankuru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//exclude = SecurityAutoConfiguration.class
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PankuruApplication {

    public static void main(String[] args) {
        SpringApplication.run(PankuruApplication.class, args);
    }


}
