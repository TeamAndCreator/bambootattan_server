package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathnode;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.SheathnodeService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 箨环控制层接口
 * Created by: 张理
 * 2018-11-13
 */
@RestController
@RequestMapping("/sheathnode")
@Api(description = "箨环")
public class SheathnodeController {
    private final SheathnodeService sheathnodeService;

    @Autowired
    public SheathnodeController(SheathnodeService sheathnodeService) {this.sheathnodeService = sheathnodeService;}

    /**
     * 查询所有箨环列表
     * @return
     */
    @ApiOperation(value = "获取所有箨环列表", notes = "获取所有箨环列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(sheathnodeService.findAll());
    }

    /**
     * 查询一个箨环列表
     * @param sheNodeId
     * @return
     */
    @ApiOperation(value = "获取箨环详细信息", notes = "根据url的id来获取箨环详细信息")
    @GetMapping("findId/{sheNodeId}")
    public Result findById(@ApiParam(name = "sheNodeId", value = "需要查找的箨环的id", required = true)
                           @PathVariable("sheNodeId") Long sheNodeId) {
        return ResultUtil.success(sheathnodeService.findById(sheNodeId));
    }

    /**
     * 更新
     * @param sheathnode
     * @return
     */
    @ApiOperation(value = "更新箨环信息", notes = "根据url的id来指定更新箨环信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "sheathnode", value = "要修改的属详细实体sheathnode", required = true)
                         @RequestBody Sheathnode sheathnode) {
        return ResultUtil.success(sheathnodeService.update(sheathnode));
    }

    /**
     * 删除
     * @param sheNodeId
     * @return
     */
    @ApiOperation(value = "删除箨环", notes = "根据url的id来指定删除箨环")
    @DeleteMapping("delete/{sheNodeId}")
    public Result delete(@ApiParam(name = "sheNodeId", value = "需删除箨环的ID", required = true)
                         @PathVariable("sheNodeId") Long sheNodeId) {
        sheathnodeService.delete(sheNodeId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨环
     * @param sheathnode
     * @return
     */
    @ApiOperation(value = "创建箨环", notes = "根据Sheathnode对象创建箨环")
    @PostMapping("save")
    public Result save(@ApiParam(name = "sheathnode", value = "要添加的箨环详细实体sheathnode", required = true)
                       @RequestBody Sheathnode sheathnode) {
        return ResultUtil.success(sheathnodeService.save(sheathnode));
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
    public Result findSheathnodeNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Sheathnode> sheathnodePage = sheathnodeService.findSheathnodeNoQuery(page, size);

        return ResultUtil.success(sheathnodePage);
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
    public Result findSheathnodeQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Sheathnode> sheathnodePage = sheathnodeService.findSheathnodeQuery(page, size, search);

        return ResultUtil.success(sheathnodePage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨环")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨环的id数组", required = true) @RequestParam List<Long> ids) {
        sheathnodeService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
