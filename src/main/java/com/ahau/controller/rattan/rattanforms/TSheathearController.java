package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TSheathear;
import com.ahau.service.rattan.rattanforms.TSheathearService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tSheathear")
@Api(description = "藤箨耳")
public class TSheathearController {
    private final TSheathearService tSheathearService;

    @Autowired
    public TSheathearController(TSheathearService tSheathearService) {this.tSheathearService = tSheathearService;}

    /**
     * 查询所有箨耳列表
     * @return
     */
    @ApiOperation(value = "获取所有箨耳列表", notes = "获取所有箨耳列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tSheathearService.findAll());
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
        return ResultUtil.success(tSheathearService.findById(sheearId));
    }

    /**
     * 更新
     * @param tSheathear
     * @return
     */
    @ApiOperation(value = "更新箨耳信息", notes = "根据url的id来指定更新箨耳信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tSheathear", value = "要修改的属详细实体tSheathear", required = true)
                         @RequestBody TSheathear tSheathear) {
        return ResultUtil.success(tSheathearService.update(tSheathear));
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
        tSheathearService.delete(sheearId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨耳
     * @param tSheathear
     * @return
     */
    @ApiOperation(value = "创建箨耳", notes = "根据TSheathear对象创建箨耳")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tSheathear", value = "要添加的箨耳详细实体tSheathear", required = true)
                       @RequestBody TSheathear tSheathear) {
        return ResultUtil.success(tSheathearService.save(tSheathear));
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
    public Result findTSheathearNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TSheathear> tSheathearPage = tSheathearService.findTSheathearNoQuery(page, size);

        return ResultUtil.success(tSheathearPage);
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
    public Result findTSheathearQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TSheathear> tSheathearPage = tSheathearService.findTSheathearQuery(page, size, search);

        return ResultUtil.success(tSheathearPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨耳")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨耳的id数组", required = true) @RequestParam List<Long> ids) {
        tSheathearService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
