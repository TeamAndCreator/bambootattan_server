package com.ahau.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * 测试类
 * Created by: 张理
 * 2018-11-8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GenusControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void genusList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/find_all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("[{\"genusId\":1,\"genusNameCh\":\"sdf\",\"genusNameEn\":null,\"genusNameLd\":\"2134\",\"genusNameOth\":\"sdfsdf\",\"genusDesc\":null,\"sortNum\":null}]"));
    }

    @Test
    public void findById(Long id) {
    }

    @Test
    public void genusUpdate() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void genusAdd() {
    }
}