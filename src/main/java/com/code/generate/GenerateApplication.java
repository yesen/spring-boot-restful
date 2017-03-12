package com.code.generate;

import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sen.ye on 2017/3/2.
 */
//@SpringBootApplication(scanBasePackages = "com.code.generate")
//@ComponentScan(basePackages = "com.code.generate")
@Configuration
public class GenerateApplication implements CommandLineRunner {

    @Autowired
    private CodeTemplate codeTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Velocity.setProperty("input.encoding", "utf-8");
        Velocity.setProperty("output.encoding", "utf-8");
        Velocity.setProperty("file.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init();


        /*codeTemplate.createEntity();
        codeTemplate.createDao();
        codeTemplate.createDaoImpl();
        codeTemplate.createMapper();

        codeTemplate.createDomain();
        codeTemplate.createService();
        codeTemplate.createSerivceImpl();

        */

        codeTemplate.createResource();
        codeTemplate.createController();
    }
}
