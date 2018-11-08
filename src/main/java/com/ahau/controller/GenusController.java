package com.ahau.controller;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.GenusService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
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
    @GetMapping("findAll")
    public Result findAll(){
        return ResultUtil.success(genusService.findAll());
    }

    /**
     * 查询一个属
     * @param id
     * @returnR
     */
    @GetMapping("findId/{id}")
    public Result findById(@PathVariable("id") Long id) {
        return ResultUtil.success(genusService.findById(id));
    }

    /**
     * 更新
     * @param genus
     * @return
     */
    @PutMapping("update")
    public Result genusUpdate(@RequestBody Genus genus) {
        return ResultUtil.success(genusService.save(genus));
    }

    /**
     * 删除
     * @param id
     */
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
    @PostMapping("save")
    public Result genusAdd(@RequestBody Genus genus) {
        return ResultUtil.success(genusService.save(genus));
    }
}
