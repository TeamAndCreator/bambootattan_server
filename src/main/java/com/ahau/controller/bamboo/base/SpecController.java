package com.ahau.controller.bamboo.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.bamboo.base.Spec;
import com.ahau.entity.file.Files;
import com.ahau.service.bamboo.base.SpecService;
import com.ahau.service.file.FilesService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;


/**
 * 竹种控制层接口
 * Created by: 张理
 * 2018-11-12
 */
@RestController
@RequestMapping("/spec")
@Api(description = "种")
public class SpecController {
    private static final Logger LOGGER = LogManager.getLogger(SpecController.class);
    private final SpecService specService;
    private final FilesService filesService;

    @Autowired
    public SpecController(SpecService specService, FilesService filesService) {
        this.specService = specService;
        this.filesService = filesService;
    }

    /**
     * 查询所有种列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有种列表", notes = "获取所有种列表")
    @GetMapping("findAll")
    public Result findAll() {
        LOGGER.info(specService.findAll().toString());
        return ResultUtil.success(specService.findAll());
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
        return ResultUtil.success(specService.findById(specId));
    }

    /**
     * 更新
     *
     * @param spec
     * @return
     */
    @ApiOperation(value = "更新种信息", notes = "根据url的id来指定更新种信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "spec", value = "要修改的属详细实体spec", required = true)
                         @RequestBody Spec spec) {
        return ResultUtil.success(specService.update(spec));
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
        try {
            specService.delete(specId);
        } catch (Exception e) {
            return ResultUtil.error(500, e.toString());
        }
        return ResultUtil.success();
    }

    /**
     * 添加一个种
     *
     * @param spec
     * @return
     */
    @ApiOperation(value = "创建种", notes = "根据Spec对象创建种")
    @PostMapping(value = "save")
    public Result save(@ApiParam(name = "spec", value = "要添加的种详细实体spec",required = true) Spec spec, MultipartFile[] multipartFiles) throws IOException {
        LOGGER.debug(multipartFiles);
        if (multipartFiles.length != 0) {//ajax发过来没有文件时可以不用执行
            if (!multipartFiles[0].isEmpty()) {//form发过来没有文件时可以不用执行
                Set<Files> filesSet = filesService.fileSave(multipartFiles,"bamboo",spec.getGenus().getGenusId());
                spec.setFiles(filesSet);
            }

        }
        return ResultUtil.success(specService.save(spec));
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
    public Result findSpecNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Spec> specPage = specService.findSpecNoQuery(page, size);

        return ResultUtil.success(specPage);
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
    public Result findSpecQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Spec> specPage = specService.findSpecQuery(page, size, search);

        return ResultUtil.success(specPage);
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
        try {
            specService.deleteByIds(ids);
        } catch (Exception e) {
            return ResultUtil.error(500, e.toString());
        }


        return ResultUtil.success();
    }
}


