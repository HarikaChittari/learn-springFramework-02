package com.demo.learn_spring.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//Your business class and has two dependency injections
//dependency 1
//dependency 2


@Component
class YourBusinessClass{

    //@Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor  Injection - Your business class");

        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    Dependency1 dependency1;
    Dependency2 dependency2;

//    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("Setter Injection - set dependency 1");
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("Setter Injection - set dependency 2");
//        this.dependency2 = dependency2;
//    }

    public String toString() {
        return "Using"+dependency1 + "and"+ dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

    public static void main(String[] args) {

      try(var context = new  AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
//          context.getBean(GamingConsole.class).up();
//          context.getBean(GameRunner.class).run();
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

          System.out.println(context.getBean(YourBusinessClass.class));

      };

    }
}
