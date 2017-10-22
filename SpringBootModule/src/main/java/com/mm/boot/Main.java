package com.mm.boot;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication
//@Import({MongoModuleConfiguration.class})
//@ComponentScan(basePackages = "com.mm.boot")
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Configuration.class, args);
    }
}
