package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TSheathshell;
import com.ahau.service.rattan.rattanforms.TSheathshellService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tSheathshell")
@Api(description = "藤箨片")
public class TSheathshellController {
    private final TSheathshellService tSheathshellService;

    @Autowired
    public TSheathshellController(TSheathshellService tSheathshellService) {this.tSheathshellService = tSheathshellService;}

    /**
     * 查询所有箨片列表
     * @return
     */
    @ApiOperation(value = "获取所有箨片列表", notes = "获取所有箨片列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tSheathshellService.findAll());
    }

    /**
     * 查询一个箨片列表
     * @param sheShellId
     * @return
     */
    @ApiOperation(value = "获取箨片详细信息", notes = "根据url的id来获取箨片详细信息")
    @GetMapping("findId/{sheShellId}")
    public Result findById(@ApiParam(name = "sheShellId", value = "需要查找的箨片的id", required = true)
                           @PathVariable("sheShellId") Long sheShellId) {
        return ResultUtil.success(tSheathshellService.findById(sheShellId));
    }

    /**
     * 更新
     * @param tSheathshell
     * @return
     */
    @ApiOperation(value = "更新箨片信息", notes = "根据url的id来指定更新箨片信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tSheathshell", value = "要修改的属详细实体tSheathshell", required = true)
                         @RequestBody TSheathshell tSheathshell) {
        return ResultUtil.success(tSheathshellService.update(tSheathshell));
    }

    /**
     * 删除
     * @param sheShellId
     * @return
     */
    @ApiOperation(value = "删除箨片", notes = "根据url的id来指定删除箨片")
    @DeleteMapping("delete/{sheShellId}")
    public Result delete(@ApiParam(name = "sheShellId", value = "需删除箨片的ID", required = true)
                         @PathVariable("sheShellId") Long sheShellId) {
        tSheathshellService.delete(sheShellId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨片
     * @param tSheathshell
     * @return
     */
    @ApiOperation(value = "创建箨片", notes = "根据TSheathshell对象创建箨片")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tSheathshell", value = "要添加的箨片详细实体tSheathshell", required = true)
                       @RequestBody TSheathshell tSheathshell) {
        return ResultUtil.success(tSheathshellService.save(tSheathshell));
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
    public Result findTSheathshellNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TSheathshell> tSheathshellPage = tSheathshellService.findTSheathshellNoQuery(page, size);

        return ResultUtil.success(tSheathshellPage);
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
    public Result findTSheathshellQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TSheathshell> tSheathshellPage = tSheathshellService.findTSheathshellQuery(page, size, search);

        return ResultUtil.success(tSheathshellPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨片")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨片的id数组", required = true) @RequestParam List<Long> ids) {
        tSheathshellService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
