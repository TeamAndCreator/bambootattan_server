package com.ahau.service.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Genus;
import com.ahau.service.bamboo.base.GenusService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GenusServiceTest {

    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    private GenusService genusService;
    private Genus genus=new Genus();

    @Before
    public void before() throws Exception{
        genus.setGenusNameOth("sdfsdf");
        genus.setGenusNameLd("2134");
        genus.setGenusNameCh("sdf");
    }
    @After
    public void after() throws Exception {
    }

    @Test
    public void findAll() {
        List<Genus> genusList = genusService.findAll();
        LOGGER.debug(genusList);
    }

    @Test
    public void findById() {
            Genus genus = genusService.findById(1L);
            LOGGER.debug(genus);
        }

     @Test
     public void update() {
         genus.setGenusId(3L);
         genusService.save(genus);
     }


    @Test
    public void save() {
        genusService.save(genus);
    }

    @Test
    public void delete() {
        genusService.delete(6L);
    }
}