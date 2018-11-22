package com.ahau.service.bamboo.base;

import com.ahau.entity.bamboo.base.Spec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecService1Test {

    @Autowired
    private SpecService1 specService1;

    @Test
    public void search() {
        List<Spec> specs= specService1.search();
        System.out.println(specs.toString());
    }
}