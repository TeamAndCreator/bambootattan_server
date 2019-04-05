package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathtongue;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.SheathtongueService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 箨舌控制层接口
 * Created by: 张理
 * 2018-11-13
 */
@RestController
@RequestMapping("/sheathtongue")
@Api(description = "箨舌")
public class SheathtongueController {
    private final SheathtongueService sheathtongueService;

    @Autowired
    public SheathtongueController(SheathtongueService sheathtongueService) {this.sheathtongueService = sheathtongueService;}

    /**
     * 查询所有箨舌列表
     * @return
     */
    @ApiOperation(value = "获取所有箨舌列表", notes = "获取所有箨舌列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(sheathtongueService.findAll());
    }

    /**
     * 查询一个箨舌列表
     * @param sheTogId
     * @return
     */
    @ApiOperation(value = "获取箨舌详细信息", notes = "根据url的id来获取箨舌详细信息")
    @GetMapping("findId/{sheTogId}")
    public Result findById(@ApiParam(name = "sheTogId", value = "需要查找的箨舌的id", required = true)
                           @PathVariable("sheTogId") Long sheTogId) {
        return ResultUtil.success(sheathtongueService.findById(sheTogId));
    }

    /**
     * 更新
     * @param sheathtongue
     * @return
     */
    @ApiOperation(value = "更新箨舌信息", notes = "根据url的id来指定更新箨舌信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "sheathtongue", value = "要修改的属详细实体sheathtongue", required = true)
                         @RequestBody Sheathtongue sheathtongue) {
        return ResultUtil.success(sheathtongueService.update(sheathtongue));
    }

    /**
     * 删除
     * @param sheTogId
     * @return
     */
    @ApiOperation(value = "删除箨舌", notes = "根据url的id来指定删除箨舌")
    @DeleteMapping("delete/{sheTogId}")
    public Result delete(@ApiParam(name = "sheTogId", value = "需删除箨舌的ID", required = true)
                         @PathVariable("sheTogId") Long sheTogId) {
        sheathtongueService.delete(sheTogId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨舌
     * @param sheathtongue
     * @return
     */
    @ApiOperation(value = "创建箨舌", notes = "根据Sheathtongue对象创建箨舌")
    @PostMapping("save")
    public Result save(@ApiParam(name = "sheathtongue", value = "要添加的箨舌详细实体sheathtongue", required = true)
                       @RequestBody Sheathtongue sheathtongue) {
        return ResultUtil.success(sheathtongueService.save(sheathtongue));
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
    public Result findSheathtongueNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Sheathtongue> sheathtonguePage = sheathtongueService.findSheathtongueNoQuery(page, size);

        return ResultUtil.success(sheathtonguePage);
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
    public Result findSheathtongueQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Sheathtongue> sheathtonguePage = sheathtongueService.findSheathtongueQuery(page, size, search);

        return ResultUtil.success(sheathtonguePage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨舌")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨舌的id数组", required = true) @RequestParam List<Long> ids) {
        sheathtongueService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
