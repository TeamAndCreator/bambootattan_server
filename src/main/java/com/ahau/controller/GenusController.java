package com.ahau.controller;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.GenusService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genus")
@Api(description = "属")
public class GenusController {
    private final GenusService genusService;

    @Autowired
    public GenusController(GenusService genusService) {
        this.genusService = genusService;
    }

    /**
     * 查询所有属列表
     * @return
     */
    @ApiOperation(value = "获取所有属列表", notes = "获取所有属列表")
    @ApiImplicitParam(name = "genus", value = "属详细实体genus", required = true, dataType = "Genus")
    @GetMapping("findAll")
    public Result findAll(){
        return ResultUtil.success(genusService.findAll());
    }

    /**
     * 查询一个属
     * @param genusId
     * @returnR
     */
    @ApiOperation(value = "获取属详细信息", notes = "根据url的id来获取属详细信息")
    @ApiImplicitParam(name = "genusId", value = "属ID", required = true, dataType = "Long", paramType = "path")
    @GetMapping("findId/{genusId}")
    public Result findById(@PathVariable("genusId") Long genusId) {
        return ResultUtil.success(genusService.findById(genusId));
    }

    /**
     * 更新
     * @param genus
     * @return
     */
    @ApiOperation(value = "更新属信息", notes = "根据url的id来指定更新属信息")
    @ApiImplicitParam(name = "genus", value = "属详细实体genus", required = true, dataType = "Genus")
    @PutMapping("update")
    public Result genusUpdate(@RequestBody Genus genus) {
        return ResultUtil.success(genusService.save(genus));
    }

    /**
     * 删除
     * @param genusId
     */
    @ApiOperation(value = "删除属", notes = "根据url的id来指定删除属")
    @ApiImplicitParam(name = "genusId", value = "属ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("delete/{genusId}")
    public Result delete(@PathVariable("genusId") Long genusId) {
        genusService.delete(genusId);
        return ResultUtil.success();
    }

    /**
     * 添加一个属
     * @param genus
     * @return
     */
    @ApiOperation(value = "创建属", notes = "根据Genus对象创建属")
    @ApiImplicitParam(name = "genus", value = "属详细实体genus", required = true, dataType = "Genus")
    @PostMapping("save")
    public Result genusAdd(@RequestBody Genus genus) {
        return ResultUtil.success(genusService.save(genus));
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页无条件查找", notes = "分页无条件查找")
    @ApiImplicitParam(name = "genus", value = "属详细实体genus", required = true, dataType = "Genus")
    @GetMapping("findAllNoQuery/{page}/{size}")
    public Result findGenusNoQuery(@PathVariable("page") Integer page,@PathVariable("size") Integer size){

        Page<Genus> genusPage=genusService.findGenusNoQuery(page,size);

        return ResultUtil.success(genusPage);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param genus
     * @return
     */
    @ApiOperation(value = "分页有条件查找",notes = "分页有条件查找")
    @ApiImplicitParam(name = "genus", value = "属详细实体genus", required = true, dataType = "Genus")
    @GetMapping("findAllQuery/{page}/{size}")
    public Result findGenusQuery(@PathVariable("page") Integer page,@PathVariable("size") Integer size,@RequestBody Genus genus){

        Page<Genus> genusPage=genusService.findGenusQuery(page,size,genus);

        return ResultUtil.success(genusPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据url的id来批量删除属")
    @ApiImplicitParam(name = "genusId", value = "属ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@RequestParam List<Long> ids) {
        genusService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
