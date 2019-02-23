package com.ahau.service.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Spec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    private EsService esService;

    @Test
    public void search() {
        List<Spec> specs= esService.search();
        LOGGER.debug(specs.toString());
    }
}