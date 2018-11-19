package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TChemistry;
import com.ahau.service.rattan.rattannature.TChemistryService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤化学性质控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tChemistry")
@Api(description = "藤化学性质")
public class TChemistryController {
    private final TChemistryService tChemistryService;

    @Autowired
    public TChemistryController(TChemistryService tChemistryService) {this.tChemistryService = tChemistryService;}

    /**
     * 查询所有化学性质列表
     * @return
     */
    @ApiOperation(value = "获取所有化学性质列表", notes = "获取所有化学性质列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tChemistryService.findAll());
    }

    /**
     * 查询一个化学性质列表
     * @param chemId
     * @return
     */
    @ApiOperation(value = "获取化学性质详细信息", notes = "根据url的id来获取化学性质详细信息")
    @GetMapping("findId/{chemId}")
    public Result findById(@ApiParam(name = "chemId", value = "需要查找的化学性质的id", required = true)
                           @PathVariable("chemId") Long chemId) {
        return ResultUtil.success(tChemistryService.findById(chemId));
    }

    /**
     * 更新
     * @param tChemistry
     * @return
     */
    @ApiOperation(value = "更新化学性质信息", notes = "根据url的id来指定更新化学性质信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tChemistry",
            value = "要修改的属详细实体tChemistry", required = true)
                         @RequestBody TChemistry tChemistry) {
        return ResultUtil.success(tChemistryService.update(tChemistry));
    }

    /**
     * 删除
     * @param chemId
     * @return
     */
    @ApiOperation(value = "删除化学性质", notes = "根据url的id来指定删除化学性质")
    @DeleteMapping("delete/{chemId}")
    public Result delete(@ApiParam(name = "chemId", value = "需删除化学性质的ID", required = true)
                         @PathVariable("chemId") Long chemId) {
        tChemistryService.delete(chemId);
        return ResultUtil.success();
    }

    /**
     * 添加一个化学性质
     * @param tChemistry
     * @return
     */
    @ApiOperation(value = "创建化学性质", notes = "根据TChemistry对象创建化学性质")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tChemistry",
            value = "要添加的化学性质详细实体tChemistry", required = true)
                       @RequestBody TChemistry tChemistry) {
        return ResultUtil.success(tChemistryService.save(tChemistry));
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
    public Result findTChemistryNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TChemistry> tChemistryPage = tChemistryService.findTChemistryNoQuery(page, size);

        return ResultUtil.success(tChemistryPage);
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
    public Result findTChemistryQuery(@RequestParam Integer page, @RequestParam Integer size,
                                     String search) {

        Page<TChemistry> tChemistryPage = tChemistryService.findTChemistryQuery(page, size, search);

        return ResultUtil.success(tChemistryPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除化学性质")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除化学性质的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tChemistryService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
