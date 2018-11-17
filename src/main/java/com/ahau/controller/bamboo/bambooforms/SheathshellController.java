package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Sheathshell;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.SheathshellService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 箨片控制层接口
 * Created by: 张理
 * 2018-11-13
 */
@RestController
@RequestMapping("/sheathshell")
@Api(description = "箨片")
public class SheathshellController {
    private final SheathshellService sheathshellService;

    @Autowired
    public SheathshellController(SheathshellService sheathshellService) {this.sheathshellService = sheathshellService;}

    /**
     * 查询所有箨片列表
     * @return
     */
    @ApiOperation(value = "获取所有箨片列表", notes = "获取所有箨片列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(sheathshellService.findAll());
    }

    /**
     * 查询一个箨片列表
     * @param sheshellId
     * @return
     */
    @ApiOperation(value = "获取箨片详细信息", notes = "根据url的id来获取箨片详细信息")
    @GetMapping("findId/{sheshellId}")
    public Result findById(@ApiParam(name = "sheshellId", value = "需要查找的箨片的id", required = true)
                           @PathVariable("sheshellId") Long sheshellId) {
        return ResultUtil.success(sheathshellService.findById(sheshellId));
    }

    /**
     * 更新
     * @param sheathshell
     * @return
     */
    @ApiOperation(value = "更新箨片信息", notes = "根据url的id来指定更新箨片信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "sheathshell", value = "要修改的属详细实体sheathshell", required = true)
                         @RequestBody Sheathshell sheathshell) {
        return ResultUtil.success(sheathshellService.update(sheathshell));
    }

    /**
     * 删除
     * @param sheshellId
     * @return
     */
    @ApiOperation(value = "删除箨片", notes = "根据url的id来指定删除箨片")
    @DeleteMapping("delete/{sheshellId}")
    public Result delete(@ApiParam(name = "sheshellId", value = "需删除箨片的ID", required = true)
                         @PathVariable("sheshellId") Long sheshellId) {
        sheathshellService.delete(sheshellId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨片
     * @param sheathshell
     * @return
     */
    @ApiOperation(value = "创建箨片", notes = "根据Sheathshell对象创建箨片")
    @PostMapping("save")
    public Result save(@ApiParam(name = "sheathshell", value = "要添加的箨片详细实体sheathshell", required = true)
                       @RequestBody Sheathshell sheathshell) {
        return ResultUtil.success(sheathshellService.save(sheathshell));
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
    public Result findSheathshellNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Sheathshell> sheathshellPage = sheathshellService.findSheathshellNoQuery(page, size);

        return ResultUtil.success(sheathshellPage);
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
    public Result findSheathshellQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Sheathshell> sheathshellPage = sheathshellService.findSheathshellQuery(page, size, search);

        return ResultUtil.success(sheathshellPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨片")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨片的id数组", required = true) @RequestParam List<Long> ids) {
        sheathshellService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
