package com.ahau.service.file;


import com.ahau.entity.file.Files;
import com.ahau.repository.file.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

@Transactional
@Service
public class FilesService {
    private final FilesRepository filesRepository;
    private final String REAL_PATH="C:/File/";

    private final static String VR_PATH="/File/";

    @Autowired
    public FilesService(FilesRepository filesRepository) {this.filesRepository = filesRepository;}

    public List<Files> findAll() {return filesRepository.findAll();}

    public Files save(Files files) {
        return filesRepository.save(files);
    }
    public String upLoad(MultipartFile file){
        if (file.isEmpty()) {
            return "文件为空";
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        //获取文件的后缀名
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        //文件上传路径
        String filePath = "d:/bamboo/video/";
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            filePath = "/root/bamboo/video/";
        } else if (Pattern.matches("Mac.*", osName)) {
            filePath = "/Users/james/bamboo/video/";
        }
        File dest = new File(filePath + fileName);
        //检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    public Set<Files> fileSave(MultipartFile[] multipartFiles, String content) throws IOException {
        //物理路径
        String realPath = REAL_PATH + content;
        Set<Files> filesSet=new HashSet<Files>();

        for (MultipartFile multipartFile:multipartFiles){
            String origin_name =multipartFile.getOriginalFilename();
            //获取文件后缀
            String fileEnd = origin_name.substring(origin_name.lastIndexOf(".") + 1).toLowerCase();

            //创建唯一文件名
            String uuid= UUID.randomUUID().toString();
            String name=uuid+"."+fileEnd;
            File file = new File(realPath, name);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            multipartFile.transferTo(new File(realPath + File.separator + name));
            filesSet.add(new Files(name,content,realPath,null,null,null));
        }
        return filesSet;
    }
}
