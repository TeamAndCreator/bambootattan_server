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
    public Result update(@ApiParam(name = "spec", value = "要修改的属详细实体spec")
                                 Spec spec, MultipartFile[] multipartFiles) {
        try {
            if (specService.IsNameChExisted(spec.getSpecNameCh(),spec.getSpecId()))
                return ResultUtil.error(500, "该竹种已存在");
            //查出原文件并删除
            Set<Files> oldFilesSet = specService.getFiles(spec.getSpecId());
            if (multipartFiles != null) {
                if (multipartFiles.length != 0) {//ajax发过来没有文件时可以不用执行
                    if (!multipartFiles[0].isEmpty()) {//form发过来没有文件时可以不用执行
                        Set<Files> filesSet = filesService.fileSave(multipartFiles, "bamboo", spec.getGenus().getGenusId());
                        spec.setFiles(filesSet);
                    }
                }
            }
            specService.update(spec);
            filesService.deleteDoubleFiles(oldFilesSet);
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
        try {
            Spec spec = specService.findById(specId);
            Set<Files> filesSet = spec.getFiles();
            filesService.deleteFiles(filesSet);
            try {
                specService.delete(specId);
            } catch (Exception e) {
                return ResultUtil.error(1451, "提示：该竹种存在形态和性质信息，因此无法删除！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(1451, "提示：该竹种存在形态和性质信息，因此无法删除！");
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
    public Result save(@ApiParam(name = "spec", value = "要添加的种详细实体spec", required = true) Spec spec, MultipartFile[] multipartFiles) {
        try {
            if (specService.IsNameChExisted(spec.getSpecNameCh()))
                return ResultUtil.error(500,"该竹种已存在");
            if (multipartFiles.length != 0) {//ajax发过来没有文件时可以不用执行
                if (!multipartFiles[0].isEmpty()) {//form发过来没有文件时可以不用执行
                    Set<Files> filesSet = filesService.fileSave(multipartFiles, "bamboo", spec.getGenus().getGenusId());
                    spec.setFiles(filesSet);
                }

            }
            return ResultUtil.success(specService.save(spec));
        } catch (Exception e) {
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
        try {
            Page<Spec> specPage = specService.findSpecQuery(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
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
            for (Long specId : ids) {
                Spec spec = specService.findById(specId);
                Set<Files> filesSet = spec.getFiles();
                filesService.deleteFiles(filesSet);
            }
            try{
                specService.deleteByIds(ids);
            }catch (Exception e){
                return ResultUtil.error(1451, "提示：该竹种存在形态和性质信息，因此无法删除！");
            }

        } catch (Exception e) {
            return ResultUtil.error(1451, "提示：该竹种存在形态和性质信息，因此无法删除！");
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
    @GetMapping("findAllQueryWithOutUnderstem")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutUnderstem(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutUnderstem(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有竹秆的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有竹秆的数据)", notes = "分页有条件查找（不包含已有竹秆的数据）")
    @GetMapping("findAllQueryWithOutCulm")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutCulm(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutCulm(page, size, search);

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
    @GetMapping("findAllQueryWithOutFlowerfruit")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutFlowerfruit(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutFlowerfruit(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页有条件查找(不包含已有竹叶的数据)
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找(不包含已有竹叶的数据)", notes = "分页有条件查找（不包含已有竹叶的数据）")
    @GetMapping("findAllQueryWithOutLeaf")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutLeaf(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutLeaf(page, size, search);

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
    @GetMapping("findAllQueryWithOutSheath")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutSheath(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutSheath(page, size, search);

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
    @GetMapping("findAllQueryWithOutSheathear")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutSheathear(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutSheathear(page, size, search);

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
    @GetMapping("findAllQueryWithOutSheathnode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutSheathnode(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutSheathnode(page, size, search);

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
    @GetMapping("findAllQueryWithOutSheathshell")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutSheathshell(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutSheathshell(page, size, search);

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
    @GetMapping("findAllQueryWithOutSheathtongue")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutSheathtongue(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutSheathtongue(page, size, search);

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
    @GetMapping("findAllQueryWithOutCathermorphology")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutCathermorphology(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutCathermorphology(page, size, search);

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
    @GetMapping("findAllQueryWithOutChemistry")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutChemistry(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutChemistry(page, size, search);

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
    @GetMapping("findAllQueryWithOutFibermorphology")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutFibermorphology(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutFibermorphology(page, size, search);

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
    @GetMapping("findAllQueryWithOutMechanics")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutMechanics(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutMechanics(page, size, search);

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
    @GetMapping("findAllQueryWithOutPhysics")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutPhysics(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutPhysics(page, size, search);

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
    @GetMapping("findAllQueryWithOutStructure")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutStructure(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutStructure(page, size, search);

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
    @GetMapping("findAllQueryWithOutTissueproportion")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutTissueproportion(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutTissueproportion(page, size, search);

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
    @GetMapping("findAllQueryWithOutVascularbundelmorphology")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findAllQueryWithOutVascularbundelmorphology(@RequestParam Integer page, @RequestParam Integer size, String search) {
        try {
            Page<Spec> specPage = specService.findAllQueryWithOutVascularbundelmorphology(page, size, search);

            return ResultUtil.success(specPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }





}


