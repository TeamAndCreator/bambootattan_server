package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TSheath;
import com.ahau.service.rattan.rattanforms.TSheathService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tSheath")
@Api(description = "藤箨鞘")
public class TSheathController {
    private final TSheathService tSheathService;

    @Autowired
    public TSheathController(TSheathService tSheathService) {this.tSheathService = tSheathService;}

    /**
     * 查询所有箨鞘列表
     * @return
     */
    @ApiOperation(value = "获取所有箨鞘列表", notes = "获取所有箨鞘列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tSheathService.findAll());
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
        return ResultUtil.success(tSheathService.findById(sheId));
    }

    /**
     * 更新
     * @param tSheath
     * @return
     */
    @ApiOperation(value = "更新箨鞘信息", notes = "根据url的id来指定更新箨鞘信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tSheath", value = "要修改的属详细实体tSheath", required = true)
                         @RequestBody TSheath tSheath) {
        return ResultUtil.success(tSheathService.update(tSheath));
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
        tSheathService.delete(sheId);
        return ResultUtil.success();
    }

    /**
     * 添加一个箨鞘
     * @param tSheath
     * @return
     */
    @ApiOperation(value = "创建箨鞘", notes = "根据TSheath对象创建箨鞘")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tSheath", value = "要添加的箨鞘详细实体tSheath", required = true)
                       @RequestBody TSheath tSheath) {
        return ResultUtil.success(tSheathService.save(tSheath));
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
    public Result findTSheathNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TSheath> tSheathPage = tSheathService.findTSheathNoQuery(page, size);

        return ResultUtil.success(tSheathPage);
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
    public Result findTSheathQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TSheath> tSheathPage = tSheathService.findTSheathQuery(page, size, search);

        return ResultUtil.success(tSheathPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除箨鞘")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除箨鞘的id数组", required = true) @RequestParam List<Long> ids) {
        tSheathService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
