package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheath;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.SheathService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 箨鞘控制层接口
 * Created by: 张理
 * 2018-11-13
 */
@RestController
@RequestMapping("/sheath")
@Api(description = "箨鞘")
public class SheathController {
    private final SheathService sheathService;

    @Autowired
    public SheathController(SheathService sheathService) {this.sheathService = sheathService;}

    /**
     * 查询所有箨鞘列表
     * @return
     */
    @ApiOperation(value = "获取所有箨鞘列表", notes = "获取所有箨鞘列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(sheathService.findAll());
    }

    /**
     * 查询一个箨鞘列表
     * @param sheId
     * @return
     */
    @ApiOperation(value = "获取箨鞘详细信息", notes = "根据url的id来获取箨鞘详细信息")
    @GetMapping("findId/{sheId}")
    public Result findById(@ApiParam(name = "sheId", value = "需要查找的箨鞘的id", required = true)
                           @PathVariable("sheId") Long sheId) {
        return ResultUtil.success(sheathService.findById(sheId));
    }

    /**
     * 更新
     * @param sheath
     * @return
     */
    @ApiOperation(value = "更新箨鞘信息", notes = "根据url的id来指定更新箨鞘信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "sheath", value = "要修改的属详细实体sheath", required = true)
                         @RequestBody Sheath sheath) {
        return ResultUtil.success(sheathService.update(sheath));
    }

    /**
     * 删除
     * @param sheId
     * @return
     */
    @ApiOperation(value = "删除箨鞘", notes = "根据url的id来指定删除箨鞘")
    @DeleteMapping("delete/{sheId}")
    public Result delete(@ApiParam(name = "sheId", value = "需删除箨鞘的ID", required = true)
                         @PathVariable("sheId") Long sheId) {
        sheathService.delete(sheId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨鞘
     * @param sheath
     * @return
     */
    @ApiOperation(value = "创建箨鞘", notes = "根据Sheath对象创建箨鞘")
    @PostMapping("save")
    public Result save(@ApiParam(name = "sheath", value = "要添加的箨鞘详细实体sheath", required = true)
                       @RequestBody Sheath sheath) {
        return ResultUtil.success(sheathService.save(sheath));
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
    public Result findSheathNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Sheath> sheathPage = sheathService.findSheathNoQuery(page, size);

        return ResultUtil.success(sheathPage);
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
    public Result findSheathQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Sheath> sheathPage = sheathService.findSheathQuery(page, size, search);

        return ResultUtil.success(sheathPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨鞘")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨鞘的id数组", required = true) @RequestParam List<Long> ids) {
        sheathService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
