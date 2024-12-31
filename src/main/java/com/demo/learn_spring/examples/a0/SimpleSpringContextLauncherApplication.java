package com.demo.learn_spring.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {



    public static void main(String[] args) {

      try(var context = new  AnnotationConfigApplicationContext(SimpleSpringContextLauncherApplication.class)) {
//          context.getBean(GamingConsole.class).up();
//          context.getBean(GameRunner.class).run();
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
      };

    }
}
