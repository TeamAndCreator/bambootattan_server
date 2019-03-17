package com.ahau.service.file;

import com.ahau.BambootattanServerApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesServiceTest {

    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    private FilesService filesService;

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
    }

    @Test
    public void upLoad() {
    }

    @Test
    public void fileSave() throws IOException {
        MultipartFile[] multipartFiles=new MultipartFile[1];
        File file = new File("/Users/james/Desktop/xiaoxin.png");
        FileInputStream inputStream = new FileInputStream(file);
        LOGGER.info(file.getName());
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        multipartFiles[0]=multipartFile;
        filesService.fileSave(multipartFiles,"bamboo",53L);
    }
}