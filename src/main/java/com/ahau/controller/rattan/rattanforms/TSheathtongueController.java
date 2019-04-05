package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TSheathtongue;
import com.ahau.service.rattan.rattanforms.TSheathtongueService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tSheathtongue")
@Api(description = "藤箨舌")
public class TSheathtongueController {
    private final TSheathtongueService tSheathtongueService;

    @Autowired
    public TSheathtongueController(TSheathtongueService tSheathtongueService) {this.tSheathtongueService = tSheathtongueService;}

    /**
     * 查询所有箨舌列表
     * @return
     */
    @ApiOperation(value = "获取所有箨舌列表", notes = "获取所有箨舌列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tSheathtongueService.findAll());
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
        return ResultUtil.success(tSheathtongueService.findById(sheTogId));
    }

    /**
     * 更新
     * @param tSheathtongue
     * @return
     */
    @ApiOperation(value = "更新箨舌信息", notes = "根据url的id来指定更新箨舌信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tSheathtongue", value = "要修改的属详细实体tSheathtongue", required = true)
                         @RequestBody TSheathtongue tSheathtongue) {
        return ResultUtil.success(tSheathtongueService.update(tSheathtongue));
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
        tSheathtongueService.delete(sheTogId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨舌
     * @param tSheathtongue
     * @return
     */
    @ApiOperation(value = "创建箨舌", notes = "根据TSheathtongue对象创建箨舌")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tSheathtongue", value = "要添加的箨舌详细实体tSheathtongue", required = true)
                       @RequestBody TSheathtongue tSheathtongue) {
        return ResultUtil.success(tSheathtongueService.save(tSheathtongue));
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
    public Result findTSheathtongueNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TSheathtongue> tSheathtonguePage = tSheathtongueService.findTSheathtongueNoQuery(page, size);

        return ResultUtil.success(tSheathtonguePage);
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
    public Result findTSheathtongueQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TSheathtongue> tSheathtonguePage = tSheathtongueService.findTSheathtongueQuery(page, size, search);

        return ResultUtil.success(tSheathtonguePage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨舌")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨舌的id数组", required = true) @RequestParam List<Long> ids) {
        tSheathtongueService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
