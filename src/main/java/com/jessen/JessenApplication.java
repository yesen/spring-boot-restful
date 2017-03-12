package com.jessen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sen.ye on 2017/2/27.
 */
//@SpringBootApplication(scanBasePackages = "com.jessen")
@Configuration
public class JessenApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("JessenApplication starting...");
    }

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>JessenApplication.main");
        SpringApplication.run(JessenApplication.class, args);
    }


}
