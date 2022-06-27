package org.aposternak35.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Starter {
    public static void main(String[] args){
        SpringApplication.run(Starter.class,args);
    }
}
