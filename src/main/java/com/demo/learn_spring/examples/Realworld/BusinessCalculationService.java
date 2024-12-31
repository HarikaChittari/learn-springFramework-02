package com.demo.learn_spring.examples.Realworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class BusinessCalculationService{

    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);

    }
}
