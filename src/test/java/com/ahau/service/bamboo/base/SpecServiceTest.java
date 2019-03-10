package com.ahau.service.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Spec;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecServiceTest {
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    private SpecService specService;

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void save() {
    }

    @Test
    public void findSpecNoQuery() {
    }

    @Test
    public void findSpecQuery() {
        String search="";
        Page<Spec> specPage=  specService.findSpecQuery(0,5,search);
        LOGGER.info(specPage);
    }

    @Test
    public void deleteByIds() {
    }




}