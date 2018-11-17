package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Cathermorphology;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.CathermorphologyService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 解剖性质_导管形态特征控制层接口
 * Created by: 张理
 * 2018-11-14
 */
@RestController
@RequestMapping("/cathermorphology")
@Api(description = "解剖性质_导管形态特征")
public class CathermorphologyController {
    private final CathermorphologyService cathermorphologyService;

    @Autowired
    public CathermorphologyController(CathermorphologyService cathermorphologyService) {this.cathermorphologyService = cathermorphologyService;}

    /**
     * 查询所有解剖性质_导管形态特征列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_导管形态特征列表", notes = "获取所有解剖性质_导管形态特征列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(cathermorphologyService.findAll());
    }

    /**
     * 查询一个解剖性质_导管形态特征列表
     * @param chmId
     * @return
     */
    @ApiOperation(value = "获取解剖性质_导管形态特征详细信息", notes = "根据url的id来获取解剖性质_导管形态特征详细信息")
    @GetMapping("findId/{chmId}")
    public Result findById(@ApiParam(name = "chmId", value = "需要查找的解剖性质_导管形态特征的id", required = true)
                           @PathVariable("chmId") Long chmId) {
        return ResultUtil.success(cathermorphologyService.findById(chmId));
    }

    /**
     * 更新
     * @param cathermorphology
     * @return
     */
    @ApiOperation(value = "更新解剖性质_导管形态特征信息", notes = "根据url的id来指定更新解剖性质_导管形态特征信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "cathermorphology",
            value = "要修改的属详细实体cathermorphology", required = true)
                         @RequestBody Cathermorphology cathermorphology) {
        return ResultUtil.success(cathermorphologyService.update(cathermorphology));
    }

    /**
     * 删除
     * @param chmId
     * @return
     */
    @ApiOperation(value = "删除解剖性质_导管形态特征", notes = "根据url的id来指定删除解剖性质_导管形态特征")
    @DeleteMapping("delete/{chmId}")
    public Result delete(@ApiParam(name = "chmId", value = "需删除解剖性质_导管形态特征的ID", required = true)
                         @PathVariable("chmId") Long chmId) {
        cathermorphologyService.delete(chmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_导管形态特征
     * @param cathermorphology
     * @return
     */
    @ApiOperation(value = "创建解剖性质_导管形态特征", notes = "根据Cathermorphology对象创建解剖性质_导管形态特征")
    @PostMapping("save")
    public Result save(@ApiParam(name = "cathermorphology",
            value = "要添加的解剖性质_导管形态特征详细实体cathermorphology", required = true)
                       @RequestBody Cathermorphology cathermorphology) {
        return ResultUtil.success(cathermorphologyService.save(cathermorphology));
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
    public Result findCathermorphologyNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Cathermorphology> cathermorphologyPage = cathermorphologyService.findCathermorphologyNoQuery(page, size);

        return ResultUtil.success(cathermorphologyPage);
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
    public Result findCathermorphologyQuery(@RequestParam Integer page, @RequestParam Integer size,
                                            String search) {

        Page<Cathermorphology> cathermorphologyPage = cathermorphologyService.findCathermorphologyQuery(page, size, search);

        return ResultUtil.success(cathermorphologyPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除解剖性质_导管形态特征")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除解剖性质_导管形态特征的id数组", required = true)
                                  @RequestParam List<Long> ids) {
        cathermorphologyService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
