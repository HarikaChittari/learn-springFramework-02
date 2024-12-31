package com.demo.learn_spring.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Component
class SomeClass{

    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){
        super();
        this.someDependency = someDependency;
        System.out.println("All dependencies are ready!");
    }

    @PostConstruct
    public void Intialize(){
        someDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("CleanUp");
    }
}

@Component
class SomeDependency {

    public static void getReady() {
        System.out.println("Some logic using some dependency");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {



    public static void main(String[] args) {

      try(var context = new  AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {

          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
      };

    }
}
