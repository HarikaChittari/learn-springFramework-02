package com.demo.learn_spring.helloworld;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address){};
record Address(String FirstLine, String city){};


@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Harika";
    }

    @Bean
    public int age(){
        return 28;
    }

    @Bean
    @Primary
    public Person person(){
        var person = new Person("Harshitha", 25, new Address("Baker street", "London"));
        return person;
    }

    @Bean(name = "person2MethodCall")
    public Person person2(){
        //by method call
        var person2 = new Person(name(), age(), address());//name , age use existing bean without hardcoding again
        return person2;
    }

    @Bean(name = "person3Parameters")
    public Person person3(String name, int age, Address address3){//name , age , address2
        //by  method parameters
        var person3 = new Person(name, age, address3);//name , age use existing bean without hardcoding again
        return person3;
    }

    @Bean(name = "person4Parameters")
    public Person person4(String name, int age, Address address){//name , age , address( bean)
        //by  method parameters
        return new Person(name, age, address);//name , age use existing bean without hardcoding again
    }

    @Bean
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address){//name , age , address( bean)
        //by  method parameters
        return new Person(name, age, address);//name , age use existing bean without hardcoding again
    }
    @Bean(name = "address2")
    @Primary
    public Address address(){
        var address = new Address("Miyapur", "Hyderabad");
        return address;

    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    public Address address3() {
        var address = new Address("elevate", "SALT LAKE CITY");
        return address;
    }



}
