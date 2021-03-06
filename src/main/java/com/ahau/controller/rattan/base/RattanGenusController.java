package com.ahau.controller.rattan.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.base.RattanGenus;
import com.ahau.service.rattan.base.RattanGenusService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  藤属控制层接口
 *  Created by: 张理
 *  2018-11-18
 */
@RestController
@RequestMapping("/rattanGenus")
@Api(description = "藤属")
public class RattanGenusController {
    private final RattanGenusService rattanGenusService;

    @Autowired
    public RattanGenusController(RattanGenusService rattanGenusService) {
        this.rattanGenusService = rattanGenusService;
    }

    /**
     * 查询所有属列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有属列表", notes = "获取所有属列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(rattanGenusService.findAll());
    }

    /**
     * 查询一个属
     *
     * @param genusId
     * @returnR
     */
    @ApiOperation(value = "获取属详细信息", notes = "根据url的id来获取属详细信息")
    @GetMapping("findId/{genusId}")
    public Result findById(@ApiParam(name = "genusId", value = "需要查找的属的id", required = true) @PathVariable("genusId") Long genusId) {
        return ResultUtil.success(rattanGenusService.findById(genusId));
    }

    /**
     * 更新
     *
     * @param rattanGenus
     * @return
     */
    @ApiOperation(value = "更新属信息", notes = "根据url的id来指定更新属信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "rattanGenus", value = "要修改的属详细实体rattanGenus", required = true)
                                     RattanGenus rattanGenus) {
        try{
            if (rattanGenusService.IsNameChExisted(rattanGenus.getGenusNameCh(),rattanGenus.getGenusId()))
                return ResultUtil.error(500,"该藤属已存在");
            return ResultUtil.success(rattanGenusService.update(rattanGenus));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
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
        try {
            rattanGenusService.delete(genusId);
        } catch (Exception e) {
            return ResultUtil.error(1451, "提示：该属存在藤种信息，因此无法删除！");
        }
        return ResultUtil.success();
    }

    /**
     * 添加一个属
     *
     * @param rattanGenus
     * @return
     */
    @ApiOperation(value = "创建属", notes = "根据RattanGenus对象创建属")
    @PostMapping("save")
    public Result save(@ApiParam(name = "rattanGenus", value = "要添加的属详细实体rattanGenus", required = true) @RequestBody RattanGenus rattanGenus) {
        try {
            if (rattanGenusService.IsNameChExisted(rattanGenus.getGenusNameCh()))
                return ResultUtil.error(500, "该藤属已存在");
            return ResultUtil.success(rattanGenusService.save(rattanGenus));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
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
    public Result findRattanGenusNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<RattanGenus> rattanGenusPage = rattanGenusService.findRattanGenusNoQuery(page, size);

        return ResultUtil.success(rattanGenusPage);
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
    public Result findRattanGenusQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {
        Page<RattanGenus> rattanGenusPage = rattanGenusService.findRattanGenusQuery(page, size, search);

        return ResultUtil.success(rattanGenusPage);
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
        try {
            rattanGenusService.deleteByIds(ids);
        } catch (Exception e) {
            return ResultUtil.error(1451, "提示：该属存在藤种信息，因此无法删除");
        }
        return ResultUtil.success();
    }
}
