package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Understem;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.UnderstemService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地下茎控制层接口
 * Created by: 张理
 * 2018-11-13
 */
@RestController
@RequestMapping("/understem")
@Api(description = "地下茎")
@CacheConfig(cacheNames = "understem")
public class UnderstemController {
    private final UnderstemService understemService;

    @Autowired
    public UnderstemController(UnderstemService understemService) {this.understemService = understemService;}

    /**
     * 查询所有地下茎列表
     * @return
     */
    @ApiOperation(value = "获取所有地下茎列表", notes = "获取所有地下茎列表")
    @GetMapping("findAll")
    @Cacheable(value = "understem-findAll")
    public Result findAll() {
        return ResultUtil.success(understemService.findAll());
    }

    /**
     * 查询一个地下茎列表
     * @param underStemId
     * @return
     */
    @ApiOperation(value = "获取地下茎详细信息", notes = "根据url的id来获取地下茎详细信息")
    @GetMapping("findId/{underStemId}")
    @Cacheable(value = "understem-findById",key = "#underStemId")
    public Result findById(@ApiParam(name = "underStemId", value = "需要查找的地下茎的id", required = true)
                           @PathVariable("underStemId") Long underStemId) {
        return ResultUtil.success(understemService.findById(underStemId));
    }

    /**
     * 更新
     * @param understem
     * @return
     */
    @ApiOperation(value = "更新地下茎信息", notes = "根据url的id来指定更新地下茎信息")
    @PutMapping("update")
    @CacheEvict(value = "understem-findById", key = "#understem.underStemId", allEntries = true)
    public Result update(@ApiParam(name = "understem", value = "要修改的属详细实体understem", required = true)
                         @RequestBody Understem understem) {
        return ResultUtil.success(understemService.update(understem));
    }

    /**
     * 删除
     * @param underStemId
     * @return
     */
    @ApiOperation(value = "删除地下茎", notes = "根据url的id来指定删除地下茎")
    @DeleteMapping("delete/{underStemId}")
    @CacheEvict(value = "understem-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "underStemId", value = "需删除地下茎的ID", required = true)
                         @PathVariable("underStemId") Long underStemId) {
        understemService.delete(underStemId);
        return ResultUtil.success();
    }

    /**
     * 添加一个地下茎
     * @param understem
     * @return
     */
    @ApiOperation(value = "创建地下茎", notes = "根据Understem对象创建地下茎")
    @PostMapping("save")
    @CacheEvict(value = "understem-findAll", allEntries = true)
    public Result save(@ApiParam(name = "understem", value = "要添加的地下茎详细实体understem", required = true)
                       @RequestBody Understem understem) {
        return ResultUtil.success(understemService.save(understem));
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
    @Cacheable(value = "understem-findUnderstemNoQuery")
    public Result findUnderstemNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Understem> understemPage = understemService.findUnderstemNoQuery(page, size);

        return ResultUtil.success(understemPage);
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
    public Result findUnderstemQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Understem> understemPage = understemService.findUnderstemQuery(page, size, search);

        return ResultUtil.success(understemPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除地下茎")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "understem-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除地下茎的id数组", required = true) @RequestParam List<Long> ids) {
        understemService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
