package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Culm;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.CulmService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 竹秆控制层接口
 * Created by: 张理
 * 2018-11-12
 */
@RestController
@RequestMapping("/culm")
@Api(description = "竹秆")
public class CulmController {
    private final CulmService culmService;

    @Autowired
    public CulmController(CulmService culmService) {this.culmService = culmService;}

    /**
     * 查询所有竹秆列表
     * @return
     */
    @ApiOperation(value = "获取所有竹秆列表", notes = "获取所有竹秆列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(culmService.findAll());
    }

    /**
     * 查询一个竹秆列表
     * @param culmId
     * @return
     */
    @ApiOperation(value = "获取竹秆详细信息", notes = "根据url的id来获取竹秆详细信息")
    @GetMapping("findId/{culmId}")
    public Result findById(@ApiParam(name = "culmId", value = "需要查找的竹秆的id", required = true) @PathVariable("culmId") Long culmId) {
        return ResultUtil.success(culmService.findById(culmId));
    }

    /**
     * 更新
     * @param culm
     * @return
     */
    @ApiOperation(value = "更新竹秆信息", notes = "根据url的id来指定更新竹秆信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "culm", value = "要修改的属详细实体culm", required = true)
                         @RequestBody Culm culm) {
        return ResultUtil.success(culmService.update(culm));
    }

    /**
     * 删除
     * @param culmId
     * @return
     */
    @ApiOperation(value = "删除竹秆", notes = "根据url的id来指定删除竹秆")
    @DeleteMapping("delete/{culmId}")
    public Result delete(@ApiParam(name = "culmId", value = "需删除竹秆的ID", required = true)
                         @PathVariable("culmId") Long culmId) {
        culmService.delete(culmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个竹秆
     * @param culm
     * @return
     */
    @ApiOperation(value = "创建竹秆", notes = "根据Culm对象创建竹秆")
    @PostMapping("save")
    public Result save(@ApiParam(name = "culm", value = "要添加的竹秆详细实体culm", required = true) @RequestBody Culm culm) {
        return ResultUtil.success(culmService.save(culm));
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
    public Result findCulmNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Culm> culmPage = culmService.findCulmNoQuery(page, size);

        return ResultUtil.success(culmPage);
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
    public Result findCulmQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Culm> culmPage = culmService.findCulmQuery(page, size, search);

        return ResultUtil.success(culmPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除竹秆")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除竹秆的id数组", required = true) @RequestParam List<Long> ids) {
        culmService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
