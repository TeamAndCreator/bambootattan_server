package com.ahau.controller.rattan.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.file.Files;
import com.ahau.entity.rattan.base.RattanSpec;
import com.ahau.service.rattan.base.RattanSpecService;
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
 *  藤种控制层接口
 *  Created by: 张理
 *  2018-11-18
 */
@RestController
@RequestMapping("/rattanSpec")
@Api(description = "藤种")
public class RattanSpecController {
    private final RattanSpecService rattanSpecService;
    private final FilesService filesService;
    private static final Logger LOGGER = LogManager.getLogger(RattanSpecController.class);

    @Autowired
    public RattanSpecController(RattanSpecService rattanSpecService, FilesService filesService) {
        this.rattanSpecService = rattanSpecService;
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
                         @RequestBody RattanSpec rattanSpec, MultipartFile[] multipartFiles) {
        try {
            if (rattanSpecService.IsNameChExisted(rattanSpec.getSpecNameCh(),rattanSpec.getSpecId()))
                return ResultUtil.error(500,"该藤种已存在");
            Set<Files> oldFileSet = rattanSpecService.getFiles(rattanSpec.getSpecId());
            if (multipartFiles != null) {
                if (multipartFiles.length != 0) {
                    if (!multipartFiles[0].isEmpty()){
                        Set<Files> filesSet = filesService.fileSave(multipartFiles, "rattan",rattanSpec.getRattanGenus().getGenusId());
                        rattanSpec.setFiles(filesSet);
                    }
                }
            }
            rattanSpecService.update(rattanSpec);
            filesService.deleteDoubleFiles(oldFileSet);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
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
            RattanSpec rattanSpec = rattanSpecService.findById(specId);
            Set<Files> filesSet = rattanSpec.getFiles();
            filesService.deleteFiles(filesSet);
            try {
                rattanSpecService.delete(specId);
            }catch (Exception e) {
                return ResultUtil.error(1451, "提示：该藤种存在形态和性质信息，因此无法删除！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(1451,"提示：该竹种存在形态和性质信息，因此无法删除！");
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
    public Result save(@ApiParam(name = "rattanSpec", value = "要添加的种详细实体rattanSpec",required = true) RattanSpec rattanSpec, MultipartFile[] multipartFiles){
        try{
            if (rattanSpecService.IsNameChExisted(rattanSpec.getSpecNameCh()))
                return ResultUtil.error(500,"该藤种已存在");
        if (multipartFiles.length != 0) {//ajax发过来没有文件时可以不用执行
            if (!multipartFiles[0].isEmpty()) {//form发过来没有文件时可以不用执行
                Set<Files> filesSet = filesService.fileSave(multipartFiles, "rattan", rattanSpec.getRattanGenus().getGenusId());
                rattanSpec.setFiles(filesSet);
            }

        }
        return ResultUtil.success(rattanSpecService.save(rattanSpec));
    } catch(Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
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
            for (Long specId : ids) {
                RattanSpec rattanSpec = rattanSpecService.findById(specId);
                Set<Files> filesSet = rattanSpec.getFiles();
                filesService.deleteFiles(filesSet);
            }
            try {
                rattanSpecService.deleteByIds(ids);
            } catch (Exception e){
                return ResultUtil.error(1451,"提示：该藤种存在形态和性质信息，因此无法删除！");
            }
        }catch (Exception e){
            return ResultUtil.error(1451,"提示：该竹种存在形态和性质信息，因此无法删除！");
        }
        return ResultUtil.success();
    }

    /**
     * 分页有条件查找(不包含已有地下茎的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有地下茎的数据)", notes = "分页有条件查找（不包含已有地下茎的数据）")
    @GetMapping("findAllQueryWithOutTUnderstem")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTUnderstem(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTUnderstem(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有藤秆的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有藤秆的数据)", notes = "分页有条件查找（不包含已有藤秆的数据）")
    @GetMapping("findAllQueryWithOutTCulm")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTCulm(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTCulm(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有花果形态的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有花果形态的数据)", notes = "分页有条件查找（不包含已有花果形态的数据）")
    @GetMapping("findAllQueryWithOutTFlowerfruit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTFlowerfruit(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTFlowerfruit(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有藤叶的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有藤叶的数据)", notes = "分页有条件查找（不包含已有藤叶的数据）")
    @GetMapping("findAllQueryWithOutTLeaf")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTLeaf(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTLeaf(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有箨鞘的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有箨鞘的数据)", notes = "分页有条件查找（不包含已有箨鞘的数据）")
    @GetMapping("findAllQueryWithOutTSheath")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTSheath(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTSheath(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有箨耳的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有箨耳的数据)", notes = "分页有条件查找（不包含已有箨耳的数据）")
    @GetMapping("findAllQueryWithOutTSheathear")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTSheathear(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTSheathear(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有箨环的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有箨环的数据)", notes = "分页有条件查找（不包含已有箨环的数据）")
    @GetMapping("findAllQueryWithOutTSheathnode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTSheathnode(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTSheathnode(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有箨片的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有箨片的数据)", notes = "分页有条件查找（不包含已有箨片的数据）")
    @GetMapping("findAllQueryWithOutTSheathshell")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTSheathshell(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTSheathshell(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有箨舌的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有箨舌的数据)", notes = "分页有条件查找（不包含已有箨舌的数据）")
    @GetMapping("findAllQueryWithOutTSheathtongue")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTSheathtongue(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTSheathtongue(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有解剖性质_导管形态特征的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有解剖性质_导管形态特征的数据)", notes = "分页有条件查找（不包含已有解剖性质_导管形态特征的数据）")
    @GetMapping("findAllQueryWithOutTCathermorphology")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTCathermorphology(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTCathermorphology(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有化学性质的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有化学性质的数据)", notes = "分页有条件查找（不包含已有化学性质的数据）")
    @GetMapping("findAllQueryWithOutTChemistry")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTChemistry(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTChemistry(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有解剖性质_纤维形态特征的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有解剖性质_纤维形态特征的数据)", notes = "分页有条件查找（不包含已有解剖性质_纤维形态特征的数据）")
    @GetMapping("findAllQueryWithOutTFibermorphology")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTFibermorphology(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTFibermorphology(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有力学性质的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有力学性质的数据)", notes = "分页有条件查找（不包含已有力学性质的数据）")
    @GetMapping("findAllQueryWithOutTMechanics")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTMechanics(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTMechanics(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有物理性质的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有物理性质的数据)", notes = "分页有条件查找（不包含已有物理性质的数据）")
    @GetMapping("findAllQueryWithOutTPhysics")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTPhysics(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTPhysics(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有结构性质的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有结构性质的数据)", notes = "分页有条件查找（不包含已有结构性质的数据）")
    @GetMapping("findAllQueryWithOutTStructure")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTStructure(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTStructure(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有解剖性质_组织比量的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有解剖性质_组织比量的数据)", notes = "分页有条件查找（不包含已有解剖性质_组织比量的数据）")
    @GetMapping("findAllQueryWithOutTTissueproportion")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTTissueproportion(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTTissueproportion(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有解剖性质_维管束形态特征)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有解剖性质_维管束形态特征)", notes = "分页有条件查找（不包含已有解剖性质_维管束形态特征）")
    @GetMapping("findAllQueryWithOutTVascularbundelmorphology")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTVascularbundelmorphology(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<RattanSpec> specPage = rattanSpecService.findAllQueryWithOutTVascularbundelmorphology(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }
}
