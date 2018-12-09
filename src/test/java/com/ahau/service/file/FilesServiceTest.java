package com.ahau.service.file;

import com.ahau.BambootattanServerApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FilesServiceTest {
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    @Autowired
    private FilesService filesService;





    @Test
    public void fileSave() throws IOException {
        File file=new File("/Users/james/IdeaProjects/bambootattan_server/src/main/resources/application.properties");
        LOGGER.debug(file.toString());
        FileInputStream inputStream=new FileInputStream(file);
        LOGGER.debug(inputStream.toString());
        MultipartFile multipart = new MockMultipartFile("application.properties", inputStream);


        LOGGER.debug("file:",multipart.getOriginalFilename());

    }
}