package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TFibermorphology;
import com.ahau.service.rattan.rattannature.TFibermorphologyService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤解剖性质_纤维形态特征控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tFibermorphology")
@Api(description = "藤解剖性质_纤维形态特征")
public class TFibermorphologyController {
    private final TFibermorphologyService tFibermorphologyService;

    @Autowired
    public TFibermorphologyController(TFibermorphologyService tFibermorphologyService) {this.tFibermorphologyService = tFibermorphologyService;}

    /**
     * 查询所有解剖性质_纤维形态特征列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_纤维形态特征列表", notes = "获取所有解剖性质_纤维形态特征列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tFibermorphologyService.findAll());
    }

    /**
     * 查询一个解剖性质_纤维形态特征列表
     * @param fmId
     * @return
     */
    @ApiOperation(value = "获取解剖性质_纤维形态特征详细信息", notes = "根据url的id来获取解剖性质_纤维形态特征详细信息")
    @GetMapping("findId/{fmId}")
    public Result findById(@ApiParam(name = "fmId", value = "需要查找的解剖性质_纤维形态特征的id", required = true)
                           @PathVariable("fmId") Long fmId) {
        return ResultUtil.success(tFibermorphologyService.findById(fmId));
    }

    /**
     * 更新
     * @param tFibermorphology
     * @return
     */
    @ApiOperation(value = "更新解剖性质_纤维形态特征信息", notes = "根据url的id来指定更新解剖性质_纤维形态特征信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tFibermorphology",
            value = "要修改的属详细实体tFibermorphology", required = true)
                         @RequestBody TFibermorphology tFibermorphology) {
        return ResultUtil.success(tFibermorphologyService.update(tFibermorphology));
    }

    /**
     * 删除
     * @param fmId
     * @return
     */
    @ApiOperation(value = "删除解剖性质_纤维形态特征", notes = "根据url的id来指定删除解剖性质_纤维形态特征")
    @DeleteMapping("delete/{fmId}")
    public Result delete(@ApiParam(name = "fmId", value = "需删除解剖性质_纤维形态特征的ID", required = true)
                         @PathVariable("fmId") Long fmId) {
        tFibermorphologyService.delete(fmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_纤维形态特征
     * @param tFibermorphology
     * @return
     */
    @ApiOperation(value = "创建解剖性质_纤维形态特征", notes = "根据TFibermorphology对象创建解剖性质_纤维形态特征")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tFibermorphology",
            value = "要添加的解剖性质_纤维形态特征详细实体tFibermorphology", required = true)
                       @RequestBody TFibermorphology tFibermorphology) {
        return ResultUtil.success(tFibermorphologyService.save(tFibermorphology));
    }

    /**
     * 分页无条件查找
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
    public Result findTFibermorphologyNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TFibermorphology> tFibermorphologyPage = tFibermorphologyService.findTFibermorphologyNoQuery(page, size);

        return ResultUtil.success(tFibermorphologyPage);
    }

    /**
     * 分页有条件查找
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
    public Result findTFibermorphologyQuery(@RequestParam Integer page, @RequestParam Integer size,
                                           String search) {

        Page<TFibermorphology> tFibermorphologyPage = tFibermorphologyService.findTFibermorphologyQuery(page, size, search);

        return ResultUtil.success(tFibermorphologyPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除解剖性质_纤维形态特征")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除解剖性质_纤维形态特征的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tFibermorphologyService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
