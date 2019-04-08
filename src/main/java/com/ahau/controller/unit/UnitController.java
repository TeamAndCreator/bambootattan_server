package com.ahau.controller.unit;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.echart.EchartData;
import com.ahau.entity.echart.Series;
import com.ahau.entity.echart.Visit;
import com.ahau.entity.unit.Unit;
import com.ahau.service.unit.UnitService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/unit")
@Api(description = "单位")
public class UnitController {
    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) {this.unitService = unitService;}

    /**
     * 查询所有单位列表
     * @return
     */
    @ApiOperation(value = "获取所有单位列表", notes = "获取所有单位列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(unitService.findAll());
    }

    /**
     * 查询一个单位列表
     * @param unitId
     * @return
     */
    @ApiOperation(value = "获取单位详细信息", notes = "根据url的id来获取单位详细信息")
    @GetMapping("findId/{unitId}")
    public Result findById(@ApiParam(name = "unitId", value = "需要查找的单位的id", required = true)
                           @PathVariable("unitId") Long unitId) {
        return ResultUtil.success(unitService.findById(unitId));
    }

    /**
     * 更新
     * @param unit
     * @return
     */
    @ApiOperation(value = "更新单位信息", notes = "根据url的id来指定更新单位信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "unit", value = "要修改的属详细实体leaf", required = true)
                         @RequestBody Unit unit) {
        return ResultUtil.success(unitService.update(unit));
    }

    /**
     * 删除
     * @param unitId
     * @return
     */
    @ApiOperation(value = "删除单位", notes = "根据url的id来指定删除单位")
    @DeleteMapping("delete/{unitId}")
    public Result delete(@ApiParam(name = "unitId", value = "需删除单位的ID", required = true)
                         @PathVariable("unitId") Long unitId) {
        unitService.delete(unitId);
        return ResultUtil.success();
    }

    /**
     * 添加一个单位
     * @param unit
     * @return
     */
    @ApiOperation(value = "创建单位", notes = "根据Unit对象创建单位")
    @PostMapping("save")
    public Result save(@ApiParam(name = "unit", value = "要添加的单位详细实体unit", required = true)
                       @RequestBody Unit unit) {
        return ResultUtil.success(unitService.save(unit));
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
    public Result findUnitNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Unit> unitPage = unitService.findUnitNoQuery(page, size);

        return ResultUtil.success(unitPage);
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
    public Result findUnitQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Unit> unitPage = unitService.findUnitQuery(page, size, search);

        return ResultUtil.success(unitPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除单位")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除单位的id数组", required = true) @RequestParam List<Long> ids) {
        unitService.deleteByIds(ids);
        return ResultUtil.success();
    }






}
