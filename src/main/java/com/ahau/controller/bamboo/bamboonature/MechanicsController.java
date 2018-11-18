package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Mechanics;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.MechanicsService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *力学性质控制层接口
 * Created by: 张理
 * 2018-11-17
 */
@RestController
@RequestMapping("/mechanics")
@Api(description = "力学性质")
public class MechanicsController {
    private final MechanicsService mechanicsService;

    @Autowired
    public MechanicsController(MechanicsService mechanicsService) {this.mechanicsService = mechanicsService;}

    /**
     * 查询所有力学性质列表
     * @return
     */
    @ApiOperation(value = "获取所有力学性质列表", notes = "获取所有力学性质列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(mechanicsService.findAll());
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
        return ResultUtil.success(mechanicsService.findById(mechId));
    }

    /**
     * 更新
     * @param mechanics
     * @return
     */
    @ApiOperation(value = "更新力学性质信息", notes = "根据url的id来指定更新力学性质信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "mechanics",
            value = "要修改的属详细实体mechanics", required = true)
                         @RequestBody Mechanics mechanics) {
        return ResultUtil.success(mechanicsService.update(mechanics));
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
        mechanicsService.delete(mechId);
        return ResultUtil.success();
    }

    /**
     * 添加一个力学性质
     * @param mechanics
     * @return
     */
    @ApiOperation(value = "创建力学性质", notes = "根据Mechanics对象创建力学性质")
    @PostMapping("save")
    public Result save(@ApiParam(name = "mechanics",
            value = "要添加的力学性质详细实体mechanics", required = true)
                       @RequestBody Mechanics mechanics) {
        return ResultUtil.success(mechanicsService.save(mechanics));
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
    public Result findMechanicsNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Mechanics> mechanicsPage = mechanicsService.findMechanicsNoQuery(page, size);

        return ResultUtil.success(mechanicsPage);
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
    public Result findMechanicsQuery(@RequestParam Integer page, @RequestParam Integer size,
                                           String search) {

        Page<Mechanics> mechanicsPage = mechanicsService.findMechanicsQuery(page, size, search);

        return ResultUtil.success(mechanicsPage);
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
        mechanicsService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
