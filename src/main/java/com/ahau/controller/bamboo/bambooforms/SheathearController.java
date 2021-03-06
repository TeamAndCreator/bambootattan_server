package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathear;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.SheathearService;
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
 * 箨耳控制层接口
 * Created by: 张理
 * 2018-11-13
 */
@RestController
@RequestMapping("/sheathear")
@Api(description = "箨耳")
@CacheConfig(cacheNames = "sheathear")
public class SheathearController {
    private final SheathearService sheathearService;

    @Autowired
    public SheathearController(SheathearService sheathearService) {this.sheathearService = sheathearService;}

    /**
     * 查询所有箨耳列表
     * @return
     */
    @ApiOperation(value = "获取所有箨耳列表", notes = "获取所有箨耳列表")
    @GetMapping("findAll")
    @Cacheable(value = "sheathear-findAll")
    public Result findAll() {
        return ResultUtil.success(sheathearService.findAll());
    }

    /**
     * 查询一个箨耳列表
     * @param sheEarId
     * @return
     */
    @ApiOperation(value = "获取箨耳详细信息", notes = "根据url的id来获取箨耳详细信息")
    @GetMapping("findId/{sheEarId}")
    @Cacheable(value = "sheathear-findById",key = "#sheEarId")
    public Result findById(@ApiParam(name = "sheEarId", value = "需要查找的箨耳的id", required = true)
                           @PathVariable("sheEarId") Long sheEarId) {
        return ResultUtil.success(sheathearService.findById(sheEarId));
    }

    /**
     * 更新
     * @param sheathear
     * @return
     */
    @ApiOperation(value = "更新箨耳信息", notes = "根据url的id来指定更新箨耳信息")
    @PutMapping("update")
    @CacheEvict(value = "sheathear-findById", key = "#sheathear.sheEarId", allEntries = true)
    public Result update(@ApiParam(name = "sheathear", value = "要修改的属详细实体sheathear", required = true)
                         @RequestBody Sheathear sheathear) {
        return ResultUtil.success(sheathearService.update(sheathear));
    }

    /**
     * 删除
     * @param sheEarId
     * @return
     */
    @ApiOperation(value = "删除箨耳", notes = "根据url的id来指定删除箨耳")
    @DeleteMapping("delete/{sheEarId}")
    @CacheEvict(value = "sheathear-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "sheEarId", value = "需删除箨耳的ID", required = true)
                         @PathVariable("sheEarId") Long sheEarId) {
        sheathearService.delete(sheEarId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨耳
     * @param sheathear
     * @return
     */
    @ApiOperation(value = "创建箨耳", notes = "根据Sheathear对象创建箨耳")
    @PostMapping("save")
    @CacheEvict(value = "sheathear-findAll", allEntries = true)
    public Result save(@ApiParam(name = "sheathear", value = "要添加的箨耳详细实体sheathear", required = true)
                       @RequestBody Sheathear sheathear) {
        return ResultUtil.success(sheathearService.save(sheathear));
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
    @Cacheable(value = "sheathear-findSheathearNoQuery")
    public Result findSheathearNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Sheathear> sheathearPage = sheathearService.findSheathearNoQuery(page, size);

        return ResultUtil.success(sheathearPage);
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
    public Result findSheathearQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Sheathear> sheathearPage = sheathearService.findSheathearQuery(page, size, search);

        return ResultUtil.success(sheathearPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨耳")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "sheathear-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨耳的id数组", required = true) @RequestParam List<Long> ids) {
        sheathearService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
