package com.ahau.controller.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.base.GenusService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.Cacheable;

import java.util.List;


@RestController
@RequestMapping("/genus")
@Api(description = "属")
public class GenusController {
    private final GenusService genusService;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public GenusController(GenusService genusService) {
        this.genusService = genusService;
    }

    /**
     * 查询所有属列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有属列表", notes = "获取所有属列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(genusService.findAll());
    }

    /**
     * 查询一个属
     *
     * @param genusId
     * @returnR
     */
    @ApiOperation(value = "获取属详细信息", notes = "根据url的id来获取属详细信息")
    @GetMapping("findId/{genusId}")
    @Cacheable(value = "genus-key")
    public Result findById(@ApiParam(name = "genusId", value = "需要查找的属的id", required = true) @PathVariable("genusId") Long genusId) {
        return ResultUtil.success(genusService.findById(genusId));
    }

    /**
     * 更新
     *
     * @param genus
     * @return
     */
    @ApiOperation(value = "更新属信息", notes = "根据url的id来指定更新属信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "genus", value = "要修改的属详细实体genus", required = true)
                         @RequestBody Genus genus) {
        return ResultUtil.success(genusService.update(genus));
    }

    /**
     * 删除
     *
     * @param genusId
     */
    @ApiOperation(value = "删除属", notes = "根据url的id来指定删除属")
    @DeleteMapping("delete/{genusId}")
    public Result delete(@ApiParam(name = "genusId", value = "需删除属的ID", required = true)
                         @PathVariable("genusId") Long genusId) {
        genusService.delete(genusId);
        return ResultUtil.success();
    }

    /**
     * 添加一个属
     *
     * @param genus
     * @return
     */
    @ApiOperation(value = "创建属", notes = "根据Genus对象创建属")
    @PostMapping("save")
    public Result save(@ApiParam(name = "genus", value = "要添加的属详细实体genus", required = true) @RequestBody Genus genus) {
        return ResultUtil.success(genusService.save(genus));
    }

    /**
     * 分页无条件查找
     *
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
    public Result findGenusNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Genus> genusPage = genusService.findGenusNoQuery(page, size);

        return ResultUtil.success(genusPage);
    }

    /**
     * 分页有条件查找
     *
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
    public Result findGenusQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {
        Page<Genus> genusPage = genusService.findGenusQuery(page, size, search);
        return ResultUtil.success(genusPage);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除属")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除属的id数组", required = true) @RequestParam List<Long> ids) {
        genusService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
