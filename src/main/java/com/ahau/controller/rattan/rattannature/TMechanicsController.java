package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TMechanics;
import com.ahau.service.rattan.rattannature.TMechanicsService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤力学性质控制层接口
 * Created by: 张理
 * 2018-11-17
 */
@RestController
@RequestMapping("/tMechanics")
@Api(description = "藤力学性质")
public class TMechanicsController {
    private final TMechanicsService tMechanicsService;

    @Autowired
    public TMechanicsController(TMechanicsService tMechanicsService) {this.tMechanicsService = tMechanicsService;}

    /**
     * 查询所有力学性质列表
     * @return
     */
    @ApiOperation(value = "获取所有力学性质列表", notes = "获取所有力学性质列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tMechanicsService.findAll());
    }

    /**
     * 查询一个力学性质列表
     * @param mechId
     * @return
     */
    @ApiOperation(value = "获取力学性质详细信息", notes = "根据url的id来获取力学性质详细信息")
    @GetMapping("findId/{mechId}")
    public Result findById(@ApiParam(name = "mechId", value = "需要查找的力学性质的id", required = true)
                           @PathVariable("mechId") Long mechId) {
        return ResultUtil.success(tMechanicsService.findById(mechId));
    }

    /**
     * 更新
     * @param tMechanics
     * @return
     */
    @ApiOperation(value = "更新力学性质信息", notes = "根据url的id来指定更新力学性质信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tMechanics",
            value = "要修改的属详细实体tMechanics", required = true)
                         @RequestBody TMechanics tMechanics) {
        return ResultUtil.success(tMechanicsService.update(tMechanics));
    }

    /**
     * 删除
     * @param mechId
     * @return
     */
    @ApiOperation(value = "删除力学性质", notes = "根据url的id来指定删除力学性质")
    @DeleteMapping("delete/{mechId}")
    public Result delete(@ApiParam(name = "mechId", value = "需删除力学性质的ID", required = true)
                         @PathVariable("mechId") Long mechId) {
        tMechanicsService.delete(mechId);
        return ResultUtil.success();
    }

    /**
     * 添加一个力学性质
     * @param tMechanics
     * @return
     */
    @ApiOperation(value = "创建力学性质", notes = "根据TMechanics对象创建力学性质")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tMechanics",
            value = "要添加的力学性质详细实体tMechanics", required = true)
                       @RequestBody TMechanics tMechanics) {
        return ResultUtil.success(tMechanicsService.save(tMechanics));
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
    public Result findTMechanicsNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TMechanics> tMechanicsPage = tMechanicsService.findTMechanicsNoQuery(page, size);

        return ResultUtil.success(tMechanicsPage);
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
    public Result findTMechanicsQuery(@RequestParam Integer page, @RequestParam Integer size,
                                     String search) {

        Page<TMechanics> tMechanicsPage = tMechanicsService.findTMechanicsQuery(page, size, search);

        return ResultUtil.success(tMechanicsPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除力学性质")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除力学性质的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tMechanicsService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
