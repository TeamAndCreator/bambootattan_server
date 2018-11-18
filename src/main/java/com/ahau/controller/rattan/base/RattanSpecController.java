package com.ahau.controller.rattan.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.base.RattanSpec;
import com.ahau.service.rattan.base.RattanSpecService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  藤种控制层接口
 *  Created by: 张理
 *  2018-11-18
 */
@RestController
@RequestMapping("/rattanSpec")
@Api(description = "种")
public class RattanSpecController {
    private final RattanSpecService rattanSpecService;

    @Autowired
    public RattanSpecController(RattanSpecService rattanSpecService) {
        this.rattanSpecService = rattanSpecService;
    }

    /**
     * 查询所有种列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有种列表", notes = "获取所有种列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(rattanSpecService.findAll());
    }

    /**
     * 查询一个种列表
     *
     * @param specId
     * @return
     */
    @ApiOperation(value = "获取种详细信息", notes = "根据url的id来获取种详细信息")
    @GetMapping("findId/{specId}")
    public Result findById(@ApiParam(name = "specId", value = "需要查找的种的id", required = true) @PathVariable("specId") Long specId) {
        return ResultUtil.success(rattanSpecService.findById(specId));
    }

    /**
     * 更新
     *
     * @param rattanSpec
     * @return
     */
    @ApiOperation(value = "更新种信息", notes = "根据url的id来指定更新种信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "rattanSpec", value = "要修改的属详细实体rattanSpec", required = true)
                         @RequestBody RattanSpec rattanSpec) {
        return ResultUtil.success(rattanSpecService.update(rattanSpec));
    }

    /**
     * 删除
     *
     * @param specId
     * @return
     */
    @ApiOperation(value = "删除种", notes = "根据url的id来指定删除种")
    @DeleteMapping("delete/{specId}")
    public Result delete(@ApiParam(name = "specId", value = "需删除种的ID", required = true)
                         @PathVariable("specId") Long specId) {
        try{
            rattanSpecService.delete(specId);
        }catch (Exception e){
            return ResultUtil.error(500,e.toString());
        }
        return ResultUtil.success();
    }

    /**
     * 添加一个种
     *
     * @param rattanSpec
     * @return
     */
    @ApiOperation(value = "创建种", notes = "根据RattanSpec对象创建种")
    @PostMapping("save")
    public Result save(@ApiParam(name = "rattanSpec", value = "要添加的种详细实体rattanSpec", required = true) @RequestBody RattanSpec rattanSpec) {
        return ResultUtil.success(rattanSpecService.save(rattanSpec));
    }

    /**
     * 分页无条件查找
     *
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页无条件查找", notes = "分页无条件查找")
    @GetMapping("findAllNoQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
    })
    public Result findRattanSpecNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<RattanSpec> rattanSpecPage = rattanSpecService.findRattanSpecNoQuery(page, size);

        return ResultUtil.success(rattanSpecPage);
    }

    /**
     * 分页有条件查找
     *
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找", notes = "分页有条件查找")
    @GetMapping("findAllQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findRattanSpecQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<RattanSpec> rattanSpecPage = rattanSpecService.findRattanSpecQuery(page, size, search);

        return ResultUtil.success(rattanSpecPage);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除种")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除种的id数组", required = true) @RequestParam List<Long> ids) {
        try{
            rattanSpecService.deleteByIds(ids);
        }catch (Exception e){
            return ResultUtil.error(500,e.toString());
        }


        return ResultUtil.success();
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @PostMapping("upload")
    public String upload(@RequestParam("rattanFile") MultipartFile file) {
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
        String filePath = "d:/rattan/video/";
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            filePath = "/root/rattan/video/";
        } else if (Pattern.matches("Mac.*", osName)) {
            filePath = "/Users/james/rattan/video/";
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
}
