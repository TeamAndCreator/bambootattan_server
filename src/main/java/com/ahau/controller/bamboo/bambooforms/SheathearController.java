package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathear;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.SheathearService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result findAll() {
        return ResultUtil.success(sheathearService.findAll());
    }

    /**
     * 查询一个箨耳列表
     * @param sheearId
     * @return
     */
    @ApiOperation(value = "获取箨耳详细信息", notes = "根据url的id来获取箨耳详细信息")
    @GetMapping("findId/{sheearId}")
    public Result findById(@ApiParam(name = "sheearId", value = "需要查找的箨耳的id", required = true)
                           @PathVariable("sheearId") Long sheearId) {
        return ResultUtil.success(sheathearService.findById(sheearId));
    }

    /**
     * 更新
     * @param sheathear
     * @return
     */
    @ApiOperation(value = "更新箨耳信息", notes = "根据url的id来指定更新箨耳信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "sheathear", value = "要修改的属详细实体sheathear", required = true)
                         @RequestBody Sheathear sheathear) {
        return ResultUtil.success(sheathearService.update(sheathear));
    }

    /**
     * 删除
     * @param sheearId
     * @return
     */
    @ApiOperation(value = "删除箨耳", notes = "根据url的id来指定删除箨耳")
    @DeleteMapping("delete/{sheearId}")
    public Result delete(@ApiParam(name = "sheearId", value = "需删除箨耳的ID", required = true)
                         @PathVariable("sheearId") Long sheearId) {
        sheathearService.delete(sheearId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨耳
     * @param sheathear
     * @return
     */
    @ApiOperation(value = "创建箨耳", notes = "根据Sheathear对象创建箨耳")
    @PostMapping("save")
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
    public Result findSheathearNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Sheathear> sheathearPage = sheathearService.findSheathearNoQuery(page, size);

        return ResultUtil.success(sheathearPage);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param sheathear
     * @return
     */
    @ApiOperation(value = "分页有条件查找", notes = "分页有条件查找")
    @GetMapping("findAllQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
    })
    public Result findSheathearQuery(@RequestParam Integer page, @RequestParam Integer size, @RequestBody Sheathear sheathear) {

        Page<Sheathear> sheathearPage = sheathearService.findSheathearQuery(page, size, sheathear);

        return ResultUtil.success(sheathearPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨耳")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨耳的id数组", required = true) @RequestParam List<Long> ids) {
        sheathearService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
