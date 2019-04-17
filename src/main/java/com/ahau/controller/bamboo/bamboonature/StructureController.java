package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Structure;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.StructureService;
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
 * 结构性质控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/structure")
@Api(description = "结构性质")
@CacheConfig(cacheNames = "structure")
public class StructureController {
    private final StructureService structureService;

    @Autowired
    public StructureController(StructureService structureService) {this.structureService = structureService;}

    /**
     * 查询所有结构性质列表
     * @return
     */
    @ApiOperation(value = "获取所有结构性质列表", notes = "获取所有结构性质列表")
    @GetMapping("findAll")
    @Cacheable(value = "structure-findAll")
    public Result findAll() {
        return ResultUtil.success(structureService.findAll());
    }

    /**
     * 查询一个结构性质列表
     * @param stId
     * @return
     */
    @ApiOperation(value = "获取结构性质详细信息", notes = "根据url的id来获取结构性质详细信息")
    @GetMapping("findId/{stId}")
    @Cacheable(value = "structure-findById",key = "#stId")
    public Result findById(@ApiParam(name = "stId", value = "需要查找的结构性质的id", required = true)
                           @PathVariable("stId") Long stId) {
        return ResultUtil.success(structureService.findById(stId));
    }

    /**
     * 更新
     * @param structure
     * @return
     */
    @ApiOperation(value = "更新结构性质信息", notes = "根据url的id来指定更新结构性质信息")
    @PutMapping("update")
    @CacheEvict(value = "structure-findById", key = "#structure.stId", allEntries = true)
    public Result update(@ApiParam(name = "structure",
            value = "要修改的属详细实体structure", required = true)
                         @RequestBody Structure structure) {
        return ResultUtil.success(structureService.update(structure));
    }

    /**
     * 删除
     * @param stId
     * @return
     */
    @ApiOperation(value = "删除结构性质", notes = "根据url的id来指定删除结构性质")
    @DeleteMapping("delete/{stId}")
    @CacheEvict(value = "structure-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "stId", value = "需删除结构性质的ID", required = true)
                         @PathVariable("stId") Long stId) {
        structureService.delete(stId);
        return ResultUtil.success();
    }

    /**
     * 添加一个结构性质
     * @param structure
     * @return
     */
    @ApiOperation(value = "创建结构性质", notes = "根据Structure对象创建结构性质")
    @PostMapping("save")
    @CacheEvict(value = "structure-findAll", allEntries = true)
    public Result save(@ApiParam(name = "structure",
            value = "要添加的结构性质详细实体structure", required = true)
                       @RequestBody Structure structure) {
        return ResultUtil.success(structureService.save(structure));
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
    @Cacheable(value = "structure-findStructureNoQuery")
    public Result findStructureNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Structure> structurePage = structureService.findStructureNoQuery(page, size);

        return ResultUtil.success(structurePage);
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
    public Result findStructureQuery(@RequestParam Integer page, @RequestParam Integer size,
                                   String search) {

        Page<Structure> structurePage = structureService.findStructureQuery(page, size, search);

        return ResultUtil.success(structurePage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除结构性质")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "structure-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除结构性质的id数组", required = true)
                              @RequestParam List<Long> ids) {
        structureService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
