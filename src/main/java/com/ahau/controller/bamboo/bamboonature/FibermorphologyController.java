package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Fibermorphology;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.FibermorphologyService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 解剖性质_纤维形态特征控制层接口
 * Created by: 张理
 * 2018-11-17
 */
@RestController
@RequestMapping("/fibermorphology")
@Api(description = "解剖性质_纤维形态特征")
@CacheConfig(cacheNames = "fibermorphology")
public class FibermorphologyController {
    private final FibermorphologyService fibermorphologyService;

    @Autowired
    public FibermorphologyController(FibermorphologyService fibermorphologyService) {this.fibermorphologyService = fibermorphologyService;}

    /**
     * 查询所有解剖性质_纤维形态特征列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_纤维形态特征列表", notes = "获取所有解剖性质_纤维形态特征列表")
    @GetMapping("findAll")
    @Cacheable(value = "fibermorphology-findAll")
    public Result findAll() {
        return ResultUtil.success(fibermorphologyService.findAll());
    }

    /**
     * 查询一个解剖性质_纤维形态特征列表
     * @param fmId
     * @return
     */
    @ApiOperation(value = "获取解剖性质_纤维形态特征详细信息", notes = "根据url的id来获取解剖性质_纤维形态特征详细信息")
    @GetMapping("findId/{fmId}")
    @Cacheable(value = "fibermorphology-findById",key = "#fmId")
    public Result findById(@ApiParam(name = "fmId", value = "需要查找的解剖性质_纤维形态特征的id", required = true)
                           @PathVariable("fmId") Long fmId) {
        return ResultUtil.success(fibermorphologyService.findById(fmId));
    }

    /**
     * 更新
     * @param fibermorphology
     * @return
     */
    @ApiOperation(value = "更新解剖性质_纤维形态特征信息", notes = "根据url的id来指定更新解剖性质_纤维形态特征信息")
    @PutMapping("update")
    @CacheEvict(value = "fibermorphology-findById", key = "#fibermorphology.fmId", allEntries = true)
    public Result update(@ApiParam(name = "fibermorphology",
            value = "要修改的属详细实体fibermorphology", required = true)
                         @RequestBody Fibermorphology fibermorphology) {
        return ResultUtil.success(fibermorphologyService.update(fibermorphology));
    }

    /**
     * 删除
     * @param fmId
     * @return
     */
    @ApiOperation(value = "删除解剖性质_纤维形态特征", notes = "根据url的id来指定删除解剖性质_纤维形态特征")
    @DeleteMapping("delete/{fmId}")
    @CacheEvict(value = "fibermorphology-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "fmId", value = "需删除解剖性质_纤维形态特征的ID", required = true)
                         @PathVariable("fmId") Long fmId) {
        fibermorphologyService.delete(fmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_纤维形态特征
     * @param fibermorphology
     * @return
     */
    @ApiOperation(value = "创建解剖性质_纤维形态特征", notes = "根据Fibermorphology对象创建解剖性质_纤维形态特征")
    @PostMapping("save")
    @CacheEvict(value = "fibermorphology-findAll", allEntries = true)
    public Result save(@ApiParam(name = "fibermorphology",
            value = "要添加的解剖性质_纤维形态特征详细实体fibermorphology", required = true)
                       @RequestBody Fibermorphology fibermorphology) {
        return ResultUtil.success(fibermorphologyService.save(fibermorphology));
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
    @Cacheable(value = "fibermorphology-findFibermorphologyNoQuery")
    public Result findFibermorphologyNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Fibermorphology> fibermorphologyPage = fibermorphologyService.findFibermorphologyNoQuery(page, size);

        return ResultUtil.success(fibermorphologyPage);
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
    public Result findFibermorphologyQuery(@RequestParam Integer page, @RequestParam Integer size,
                                     String search) {

        Page<Fibermorphology> fibermorphologyPage = fibermorphologyService.findFibermorphologyQuery(page, size, search);

        return ResultUtil.success(fibermorphologyPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除解剖性质_纤维形态特征")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "fibermorphology-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除解剖性质_纤维形态特征的id数组", required = true)
                              @RequestParam List<Long> ids) {
        fibermorphologyService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
