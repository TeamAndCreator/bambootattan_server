package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TPhysics;
import com.ahau.service.rattan.rattannature.TPhysicsService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤物理性质控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tPhysics")
@Api(description = "藤物理性质")
public class TPhysicsController {
    private final TPhysicsService tPhysicsService;

    @Autowired
    public TPhysicsController(TPhysicsService tPhysicsService) {this.tPhysicsService = tPhysicsService;}

    /**
     * 查询所有物理性质列表
     * @return
     */
    @ApiOperation(value = "获取所有物理性质列表", notes = "获取所有物理性质列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tPhysicsService.findAll());
    }

    /**
     * 查询一个物理性质列表
     * @param phyId
     * @return
     */
    @ApiOperation(value = "获取物理性质详细信息", notes = "根据url的id来获取物理性质详细信息")
    @GetMapping("findId/{phyId}")
    public Result findById(@ApiParam(name = "phyId", value = "需要查找的物理性质的id", required = true)
                           @PathVariable("phyId") Long phyId) {
        return ResultUtil.success(tPhysicsService.findById(phyId));
    }

    /**
     * 更新
     * @param tPhysics
     * @return
     */
    @ApiOperation(value = "更新物理性质信息", notes = "根据url的id来指定更新物理性质信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tPhysics",
            value = "要修改的属详细实体tPhysics", required = true)
                         @RequestBody TPhysics tPhysics) {
        return ResultUtil.success(tPhysicsService.update(tPhysics));
    }

    /**
     * 删除
     * @param phyId
     * @return
     */
    @ApiOperation(value = "删除物理性质", notes = "根据url的id来指定删除物理性质")
    @DeleteMapping("delete/{phyId}")
    public Result delete(@ApiParam(name = "phyId", value = "需删除物理性质的ID", required = true)
                         @PathVariable("phyId") Long phyId) {
        tPhysicsService.delete(phyId);
        return ResultUtil.success();
    }

    /**
     * 添加一个物理性质
     * @param tPhysics
     * @return
     */
    @ApiOperation(value = "创建物理性质", notes = "根据TPhysics对象创建物理性质")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tPhysics",
            value = "要添加的物理性质详细实体tPhysics", required = true)
                       @RequestBody TPhysics tPhysics) {
        return ResultUtil.success(tPhysicsService.save(tPhysics));
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
    public Result findTPhysicsNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TPhysics> tPhysicsPage = tPhysicsService.findTPhysicsNoQuery(page, size);

        return ResultUtil.success(tPhysicsPage);
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
    public Result findTPhysicsQuery(@RequestParam Integer page, @RequestParam Integer size,
                                   String search) {

        Page<TPhysics> tPhysicsPage = tPhysicsService.findTPhysicsQuery(page, size, search);

        return ResultUtil.success(tPhysicsPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除物理性质")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除物理性质的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tPhysicsService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
