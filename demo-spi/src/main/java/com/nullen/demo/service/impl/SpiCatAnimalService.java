package com.nullen.demo.service.impl;

import com.nullen.demo.service.SpiAnimalService;

/**
 * @author Nullen
 * @date 2022/4/29
 * @description
 **/
public class SpiCatAnimalService implements SpiAnimalService {

    @Override
    public void shut() {
        System.out.println("Spi cat: Miao");
    }

}
