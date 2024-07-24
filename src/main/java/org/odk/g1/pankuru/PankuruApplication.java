package org.odk.g1.pankuru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//exclude = SecurityAutoConfiguration.class
@SpringBootApplication()
public class PankuruApplication {

    public static void main(String[] args) {
        SpringApplication.run(PankuruApplication.class, args);
    }


}
