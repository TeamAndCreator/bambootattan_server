package com.ahau.controller;

import com.ahau.entity.bamboo.base.Genus;
import net.minidev.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
    private Genus genus=new Genus();

    @Before
    public void before(){
        genus.setGenusNameOth("sdfsdf");
        genus.setGenusNameLd("2134");
        genus.setGenusNameCh("sdf");
    }

    @Test
    public void genusList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/genus/findAll"))
                .andExpect(status().isOk());
        //.andExpect(MockMvcResultMatchers.content().string("[{\"genusId\":1,\"genusNameCh\":\"sdf\",\"genusNameEn\":null,\"genusNameLd\":\"2134\",\"genusNameOth\":\"sdfsdf\",\"genusDesc\":null,\"sortNum\":null}]"));
    }

    @Test
    public void findById() {
    }

    @Test
    public void genusUpdate() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void genusAdd() throws Exception {

        MvcResult result = mvc.perform(post("/genus/save").contentType(MediaType.APPLICATION_JSON).content(genus.toString()))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果
    }
}