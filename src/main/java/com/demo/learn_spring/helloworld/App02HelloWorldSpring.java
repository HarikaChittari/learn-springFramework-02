package com.demo.learn_spring.helloworld;

import com.demo.learn_spring.helloworld.Address;
import com.demo.learn_spring.helloworld.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        //1. Launch a spring application or spring context

        // this is try with resoirces for the warning of resource leak
        try(var context =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
            //2. configure the things that we want spring framework to manage - @Configuration class s needed
            //we added helloworld configuration class
            // inside this we also created a name method with @bean annotation
            //here now we are retrieving beans managed by spring

            //3. Retrieving beans managed by spring  by name of bean or class name
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class));
            System.out.println(context.getBean(Person.class));


            //4. By using a method call or method parameters
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));

            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out:: println);
            System.out.println(context.getBean("person5Qualifier"));


        }






    }

}
