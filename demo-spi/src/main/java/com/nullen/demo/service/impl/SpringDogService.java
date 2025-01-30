package com.nullen.demo.service.impl;

import com.nullen.demo.service.SpringAnimalService;
import org.springframework.stereotype.Service;

/**
 * @author Nullen
 * @date 2022/4/29
 * @description
 **/
@Service
public class SpringDogService implements SpringAnimalService {
    @Override
    public void shut() {
        System.out.println("IOC dog: Wang!!!");
    }
}
