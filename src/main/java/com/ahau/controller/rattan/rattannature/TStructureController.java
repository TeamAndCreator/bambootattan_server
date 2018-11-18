package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TStructure;
import com.ahau.service.rattan.rattannature.TStructureService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤结构性质控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tStructure")
@Api(description = "藤结构性质")
public class TStructureController {
    private final TStructureService tStructureService;

    @Autowired
    public TStructureController(TStructureService tStructureService) {this.tStructureService = tStructureService;}

    /**
     * 查询所有结构性质列表
     * @return
     */
    @ApiOperation(value = "获取所有结构性质列表", notes = "获取所有结构性质列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tStructureService.findAll());
    }

    /**
     * 查询一个结构性质列表
     * @param stId
     * @return
     */
    @ApiOperation(value = "获取结构性质详细信息", notes = "根据url的id来获取结构性质详细信息")
    @GetMapping("findId/{stId}")
    public Result findById(@ApiParam(name = "stId", value = "需要查找的结构性质的id", required = true)
                           @PathVariable("stId") Long stId) {
        return ResultUtil.success(tStructureService.findById(stId));
    }

    /**
     * 更新
     * @param tStructure
     * @return
     */
    @ApiOperation(value = "更新结构性质信息", notes = "根据url的id来指定更新结构性质信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tStructure",
            value = "要修改的属详细实体tStructure", required = true)
                         @RequestBody TStructure tStructure) {
        return ResultUtil.success(tStructureService.update(tStructure));
    }

    /**
     * 删除
     * @param stId
     * @return
     */
    @ApiOperation(value = "删除结构性质", notes = "根据url的id来指定删除结构性质")
    @DeleteMapping("delete/{stId}")
    public Result delete(@ApiParam(name = "stId", value = "需删除结构性质的ID", required = true)
                         @PathVariable("stId") Long stId) {
        tStructureService.delete(stId);
        return ResultUtil.success();
    }

    /**
     * 添加一个结构性质
     * @param tStructure
     * @return
     */
    @ApiOperation(value = "创建结构性质", notes = "根据TStructure对象创建结构性质")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tStructure",
            value = "要添加的结构性质详细实体tStructure", required = true)
                       @RequestBody TStructure tStructure) {
        return ResultUtil.success(tStructureService.save(tStructure));
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
    public Result findTStructureNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TStructure> tStructurePage = tStructureService.findTStructureNoQuery(page, size);

        return ResultUtil.success(tStructurePage);
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
    public Result findTStructureQuery(@RequestParam Integer page, @RequestParam Integer size,
                                     String search) {

        Page<TStructure> tStructurePage = tStructureService.findTStructureQuery(page, size, search);

        return ResultUtil.success(tStructurePage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除结构性质")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除结构性质的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tStructureService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
