package com.ahau.service;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.service.bamboo.base.GenusService;
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
        System.out.println(genusList);
    }

    @Test
    public void findById() {
            Genus genus = genusService.findById(1L);
            System.out.println(genus);
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