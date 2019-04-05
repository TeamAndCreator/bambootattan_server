package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TUnderstem;
import com.ahau.service.rattan.rattanforms.TUnderstemService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tUnderstem")
@Api(description = "藤地下茎")
public class TUnderstemController {
    private final TUnderstemService tUnderstemService;

    @Autowired
    public TUnderstemController(TUnderstemService tUnderstemService) {this.tUnderstemService = tUnderstemService;}

    /**
     * 查询所有地下茎列表
     * @return
     */
    @ApiOperation(value = "获取所有地下茎列表", notes = "获取所有地下茎列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tUnderstemService.findAll());
    }

    /**
     * 查询一个地下茎列表
     * @param underStemId
     * @return
     */
    @ApiOperation(value = "获取地下茎详细信息", notes = "根据url的id来获取地下茎详细信息")
    @GetMapping("findId/{underStemId}")
    public Result findById(@ApiParam(name = "underStemId", value = "需要查找的地下茎的id", required = true)
                           @PathVariable("underStemId") Long underStemId) {
        return ResultUtil.success(tUnderstemService.findById(underStemId));
    }

    /**
     * 更新
     * @param tUnderstem
     * @return
     */
    @ApiOperation(value = "更新地下茎信息", notes = "根据url的id来指定更新地下茎信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tUnderstem", value = "要修改的属详细实体tUnderstem", required = true)
                         @RequestBody TUnderstem tUnderstem) {
        return ResultUtil.success(tUnderstemService.update(tUnderstem));
    }

    /**
     * 删除
     * @param underStemId
     * @return
     */
    @ApiOperation(value = "删除地下茎", notes = "根据url的id来指定删除地下茎")
    @DeleteMapping("delete/{underStemId}")
    public Result delete(@ApiParam(name = "underStemId", value = "需删除地下茎的ID", required = true)
                         @PathVariable("underStemId") Long underStemId) {
        tUnderstemService.delete(underStemId);
        return ResultUtil.success();
    }

    /**
     * 添加一个地下茎
     * @param tUnderstem
     * @return
     */
    @ApiOperation(value = "创建地下茎", notes = "根据TUnderstem对象创建地下茎")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tUnderstem", value = "要添加的地下茎详细实体tUnderstem", required = true)
                       @RequestBody TUnderstem tUnderstem) {
        return ResultUtil.success(tUnderstemService.save(tUnderstem));
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
    public Result findTUnderstemNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TUnderstem> tUnderstemPage = tUnderstemService.findTUnderstemNoQuery(page, size);

        return ResultUtil.success(tUnderstemPage);
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
    public Result findTUnderstemQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TUnderstem> tUnderstemPage = tUnderstemService.findTUnderstemQuery(page, size, search);

        return ResultUtil.success(tUnderstemPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除地下茎")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除地下茎的id数组", required = true) @RequestParam List<Long> ids) {
        tUnderstemService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
