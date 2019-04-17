package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Chemistry;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.ChemistryService;
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
 * 化学性质控制层接口
 * Created by: 张理
 * 2018-11-14
 */
@RestController
@RequestMapping("/chemistry")
@Api(description = "化学性质")
@CacheConfig(cacheNames = "chemistry")
public class ChemistryController {
    private final ChemistryService chemistryService;

    @Autowired
    public ChemistryController(ChemistryService chemistryService) {this.chemistryService = chemistryService;}

    /**
     * 查询所有化学性质列表
     * @return
     */
    @ApiOperation(value = "获取所有化学性质列表", notes = "获取所有化学性质列表")
    @GetMapping("findAll")
    @Cacheable(value = "chemistry-findAll")
    public Result findAll() {
        return ResultUtil.success(chemistryService.findAll());
    }

    /**
     * 查询一个化学性质列表
     * @param chemId
     * @return
     */
    @ApiOperation(value = "获取化学性质详细信息", notes = "根据url的id来获取化学性质详细信息")
    @GetMapping("findId/{chemId}")
    @Cacheable(value = "chemistry-findById",key = "#chemId")
    public Result findById(@ApiParam(name = "chemId", value = "需要查找的化学性质的id", required = true)
                           @PathVariable("chemId") Long chemId) {
        return ResultUtil.success(chemistryService.findById(chemId));
    }

    /**
     * 更新
     * @param chemistry
     * @return
     */
    @ApiOperation(value = "更新化学性质信息", notes = "根据url的id来指定更新化学性质信息")
    @PutMapping("update")
    @CacheEvict(value = "chemistry-findById", key = "#chemistry.chemId", allEntries = true)
    public Result update(@ApiParam(name = "chemistry",
            value = "要修改的属详细实体chemistry", required = true)
                         @RequestBody Chemistry chemistry) {
        return ResultUtil.success(chemistryService.update(chemistry));
    }

    /**
     * 删除
     * @param chemId
     * @return
     */
    @ApiOperation(value = "删除化学性质", notes = "根据url的id来指定删除化学性质")
    @DeleteMapping("delete/{chemId}")
    @CacheEvict(value = "chemistry-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "chemId", value = "需删除化学性质的ID", required = true)
                         @PathVariable("chemId") Long chemId) {
        chemistryService.delete(chemId);
        return ResultUtil.success();
    }

    /**
     * 添加一个化学性质
     * @param chemistry
     * @return
     */
    @ApiOperation(value = "创建化学性质", notes = "根据Chemistry对象创建化学性质")
    @PostMapping("save")
    @CacheEvict(value = "chemistry-findAll", allEntries = true)
    public Result save(@ApiParam(name = "chemistry",
            value = "要添加的化学性质详细实体chemistry", required = true)
                       @RequestBody Chemistry chemistry) {
        return ResultUtil.success(chemistryService.save(chemistry));
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
    @Cacheable(value = "chemistry-findChemistryNoQuery")
    public Result findChemistryNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Chemistry> chemistryPage = chemistryService.findChemistryNoQuery(page, size);

        return ResultUtil.success(chemistryPage);
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
    public Result findChemistryQuery(@RequestParam Integer page, @RequestParam Integer size,
                                            String search) {

        Page<Chemistry> chemistryPage = chemistryService.findChemistryQuery(page, size, search);

        return ResultUtil.success(chemistryPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除化学性质")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "chemistry-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除化学性质的id数组", required = true)
                              @RequestParam List<Long> ids) {
        chemistryService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
