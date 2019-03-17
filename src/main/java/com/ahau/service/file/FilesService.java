package com.ahau.service.file;


import com.ahau.BambootattanServerApplication;
import com.ahau.entity.file.Files;
import com.ahau.repository.file.FilesRepository;
import com.ahau.utils.GetTimeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

@Transactional
@Service
public class FilesService {
    private final FilesRepository filesRepository;
    private String ROOT_PATH = "d:/File/";
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);
    private String type;

    private final static String VR_PATH = "/file/";
    private String[] imagesSuffixName = {"bmp", "gif", "jpeg", "png", "jpg"};
    private String[] videoSuffixname = {"flv", "mp4", "flash", "avi", "mov", "rmvb", "rm"};


    @Autowired
    public FilesService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public List<Files> findAll() {
        return filesRepository.findAll();
    }

    public Files save(Files files) {
        return filesRepository.save(files);
    }

    public Set<Files> fileSave(MultipartFile[] multipartFiles, String content, Long genusId) throws IOException {
        //物理路径
        Set<Files> filesSet = new HashSet<Files>();
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            ROOT_PATH = "/root/File/";
        } else if (Pattern.matches("Mac.*", osName)) {
            ROOT_PATH = "/Users/james/File/";
        }

        for (MultipartFile multipartFile : multipartFiles) {
            //获取文件名
            String origin_name = multipartFile.getOriginalFilename();
            //获取文件后缀
            assert origin_name != null;
            String suffixName = origin_name.substring(origin_name.lastIndexOf(".") + 1).toLowerCase();
            //文件上传路径
            String path = genusId + "/";
            List<String> imgSuffixList = Arrays.asList(imagesSuffixName);
            List<String> videoSuffixList = Arrays.asList(videoSuffixname);
            if (imgSuffixList.contains(suffixName)) {
                type = "image";
                path = path + "image/";
            } else if (videoSuffixList.contains(suffixName)) {
                type = "video";
                path = path + "video/";
            }
            //创建唯一文件名
            String uuid = UUID.randomUUID().toString();
            String name = uuid + "." + suffixName;
            path = VR_PATH+path + name;
            File file = new File(ROOT_PATH+path);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            multipartFile.transferTo(file);
            //Files(String name, String origin_name, String path, String date, String type, String content)
            Files files = save(new Files(name, origin_name, path, GetTimeUtil.getDate(), type, content));
            filesSet.add(files);
        }
        return filesSet;
    }
}
