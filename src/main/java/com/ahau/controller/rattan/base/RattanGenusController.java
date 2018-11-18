package com.ahau.controller.rattan.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.base.RattanGenus;
import com.ahau.service.rattan.base.RattanGenusService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  藤属控制层接口
 *  Created by: 张理
 *  2018-11-18
 */
@RestController
@RequestMapping("/rattanGenus")
@Api(description = "属")
public class RattanGenusController {
    private final RattanGenusService rattanGenusService;

    @Autowired
    public RattanGenusController(RattanGenusService rattanGenusService) {
        this.rattanGenusService = rattanGenusService;
    }

    /**
     * 查询所有属列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有属列表", notes = "获取所有属列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(rattanGenusService.findAll());
    }

    /**
     * 查询一个属
     *
     * @param rattanGenusId
     * @returnR
     */
    @ApiOperation(value = "获取属详细信息", notes = "根据url的id来获取属详细信息")
    @GetMapping("findId/{rattanGenusId}")
    public Result findById(@ApiParam(name = "rattanGenusId", value = "需要查找的属的id", required = true) @PathVariable("rattanGenusId") Long rattanGenusId) {
        return ResultUtil.success(rattanGenusService.findById(rattanGenusId));
    }

    /**
     * 更新
     *
     * @param rattanGenus
     * @return
     */
    @ApiOperation(value = "更新属信息", notes = "根据url的id来指定更新属信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "rattanGenus", value = "要修改的属详细实体rattanGenus", required = true)
                         @RequestBody RattanGenus rattanGenus) {
        return ResultUtil.success(rattanGenusService.update(rattanGenus));
    }

    /**
     * 删除
     *
     * @param rattanGenusId
     */
    @ApiOperation(value = "删除属", notes = "根据url的id来指定删除属")
    @DeleteMapping("delete/{rattanGenusId}")
    public Result delete(@ApiParam(name = "rattanGenusId", value = "需删除属的ID", required = true)
                         @PathVariable("rattanGenusId") Long rattanGenusId) {
        rattanGenusService.delete(rattanGenusId);
        return ResultUtil.success();
    }

    /**
     * 添加一个属
     *
     * @param rattanGenus
     * @return
     */
    @ApiOperation(value = "创建属", notes = "根据RattanGenus对象创建属")
    @PostMapping("save")
    public Result save(@ApiParam(name = "rattanGenus", value = "要添加的属详细实体rattanGenus", required = true) @RequestBody RattanGenus rattanGenus) {
        return ResultUtil.success(rattanGenusService.save(rattanGenus));
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
    public Result findRattanGenusNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<RattanGenus> rattanGenusPage = rattanGenusService.findRattanGenusNoQuery(page, size);

        return ResultUtil.success(rattanGenusPage);
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
    public Result findRattanGenusQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {
        Page<RattanGenus> rattanGenusPage = rattanGenusService.findRattanGenusQuery(page, size, search);

        return ResultUtil.success(rattanGenusPage);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除属")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除属的id数组", required = true) @RequestParam List<Long> ids) {
        rattanGenusService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
