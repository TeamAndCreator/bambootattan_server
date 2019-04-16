package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Flowerfruit;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.FlowerfruitService;
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
 * 花果形态控制层接口
 * Created by: 张理
 * 2018-11-12
 */
@RestController
@RequestMapping("/flowerfruit")
@Api(description = "花果形态")
@CacheConfig(cacheNames = "flowerfruit")
public class FlowerfruitController {
    private final FlowerfruitService flowerfruitService;

    @Autowired
    public FlowerfruitController(FlowerfruitService flowerfruitService) {this.flowerfruitService = flowerfruitService;}

    /**
     * 查询所有花果形态列表
     * @return
     */
    @ApiOperation(value = "获取所有花果形态列表", notes = "获取所有花果形态列表")
    @GetMapping("findAll")
    @Cacheable(value = "flowerfruit-findAll")
    public Result findAll() {
        return ResultUtil.success(flowerfruitService.findAll());
    }

    /**
     * 查询一个花果形态列表
     * @param flofruitId
     * @return
     */
    @ApiOperation(value = "获取花果形态详细信息", notes = "根据url的id来获取花果形态详细信息")
    @GetMapping("findId/{flofruitId}")
    @Cacheable(value = "flowerfruit-findById",key = "#flofruitId")
    public Result findById(@ApiParam(name = "flofruitId", value = "需要查找的花果形态的id", required = true)
                               @PathVariable("flofruitId") Long flofruitId) {
        return ResultUtil.success(flowerfruitService.findById(flofruitId));
    }

    /**
     * 更新
     * @param flowerfruit
     * @return
     */
    @ApiOperation(value = "更新花果形态信息", notes = "根据url的id来指定更新花果形态信息")
    @PutMapping("update")
    @CacheEvict(value = "flowerfruit-findById", key = "#flowerfruit.floFruitId", allEntries = true)
    public Result update(@ApiParam(name = "flowerfruit", value = "要修改的属详细实体flowerfruit", required = true)
                         @RequestBody Flowerfruit flowerfruit) {
        return ResultUtil.success(flowerfruitService.update(flowerfruit));
    }

    /**
     * 删除
     * @param flofruitId
     * @return
     */
    @ApiOperation(value = "删除花果形态", notes = "根据url的id来指定删除花果形态")
    @DeleteMapping("delete/{flofruitId}")
    @CacheEvict(value = "flowerfruit-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "flofruitId", value = "需删除花果形态的ID", required = true)
                         @PathVariable("flofruitId") Long flofruitId) {
        flowerfruitService.delete(flofruitId);
        return ResultUtil.success();
    }

    /**
     * 添加一个花果形态
     * @param flowerfruit
     * @return
     */
    @ApiOperation(value = "创建花果形态", notes = "根据Flowerfruit对象创建花果形态")
    @PostMapping("save")
    @CacheEvict(value = "flowerfruit-findAll", allEntries = true)
    public Result save(@ApiParam(name = "flowerfruit", value = "要添加的花果形态详细实体flowerfruit", required = true)
                           @RequestBody Flowerfruit flowerfruit) {
        return ResultUtil.success(flowerfruitService.save(flowerfruit));
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
    @Cacheable(value = "flowerfruit-findGenusNoQuery")
    public Result findFlowerfruitNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Flowerfruit> flowerfruitPage = flowerfruitService.findFlowerfruitNoQuery(page, size);

        return ResultUtil.success(flowerfruitPage);
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
    public Result findFlowerfruitQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Flowerfruit> flowerfruitPage = flowerfruitService.findFlowerfruitQuery(page, size, search);

        return ResultUtil.success(flowerfruitPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除花果形态")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "flowerfruit-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除花果形态的id数组", required = true) @RequestParam List<Long> ids) {
        flowerfruitService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
