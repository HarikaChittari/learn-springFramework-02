package com.demo.learn_spring;

import com.demo.learn_spring.game.GameRunner;
import com.demo.learn_spring.game.GamingConfiguration;
import com.demo.learn_spring.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBeans {

    public static void main(String[] args) {

      try(var context = new  AnnotationConfigApplicationContext(GamingConfiguration.class)) {
          context.getBean(GamingConsole.class).up();
          context.getBean(GameRunner.class).run();
      };


    }
}
