package com.ahau.controller;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.GenusService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("findAll")
    public Result findAll(){
        return ResultUtil.success(genusService.findAll());
    }

    /**
     * 查询一个属
     * @param id
     * @returnR
     */
    @ApiOperation(value = "获取属详细信息", notes = "根据url的id来获取属详细信息")
    @GetMapping("findId/{id}")
    public Result findById(@PathVariable("id") Long id) {
        return ResultUtil.success(genusService.findById(id));
    }

    /**
     * 更新
     * @param genus
     * @return
     */
    @ApiOperation(value = "更新属信息", notes = "根据url的id来指定更新属信息")
    @PutMapping("update")
    public Result genusUpdate(@RequestBody Genus genus) {
        return ResultUtil.success(genusService.save(genus));
    }

    /**
     * 删除
     * @param id
     */
    @ApiOperation(value = "删除属", notes = "根据url的id来指定删除属")
    @ApiImplicitParam(name = "genusId", value = "属ID", required = true, dataType = "Long", paramType = "path")
    @DeleteMapping("delete/{id}")
    public Result delete(@PathVariable("id") Long id) {
        genusService.delete(id);
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
}
