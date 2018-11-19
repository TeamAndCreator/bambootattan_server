package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TCathetermorphology;
import com.ahau.service.rattan.rattannature.TCathetermorphologyService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤解剖性质_导管形态特征控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tCathetermorphology")
@Api(description = "藤解剖性质_导管形态特征")
public class TCathetermorphologyController {
    private final TCathetermorphologyService tCathetermorphologyService;

    @Autowired
    public TCathetermorphologyController(TCathetermorphologyService tCathetermorphologyService) {this.tCathetermorphologyService = tCathetermorphologyService;}

    /**
     * 查询所有解剖性质_导管形态特征列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_导管形态特征列表", notes = "获取所有解剖性质_导管形态特征列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tCathetermorphologyService.findAll());
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
        return ResultUtil.success(tCathetermorphologyService.findById(chmId));
    }

    /**
     * 更新
     * @param tCathetermorphology
     * @return
     */
    @ApiOperation(value = "更新解剖性质_导管形态特征信息", notes = "根据url的id来指定更新解剖性质_导管形态特征信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tCathetermorphology",
            value = "要修改的属详细实体tCathetermorphology", required = true)
                         @RequestBody TCathetermorphology tCathetermorphology) {
        return ResultUtil.success(tCathetermorphologyService.update(tCathetermorphology));
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
        tCathetermorphologyService.delete(chmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_导管形态特征
     * @param tCathetermorphology
     * @return
     */
    @ApiOperation(value = "创建解剖性质_导管形态特征", notes = "根据TCathetermorphology对象创建解剖性质_导管形态特征")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tCathetermorphology",
            value = "要添加的解剖性质_导管形态特征详细实体tCathetermorphology", required = true)
                       @RequestBody TCathetermorphology tCathetermorphology) {
        return ResultUtil.success(tCathetermorphologyService.save(tCathetermorphology));
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
    public Result findTCathetermorphologyNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TCathetermorphology> tCathetermorphologyPage = tCathetermorphologyService.findTCathetermorphologyNoQuery(page, size);

        return ResultUtil.success(tCathetermorphologyPage);
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
    public Result findTCathetermorphologyQuery(@RequestParam Integer page, @RequestParam Integer size,
                                            String search) {

        Page<TCathetermorphology> tCathetermorphologyPage = tCathetermorphologyService.findTCathetermorphologyQuery(page, size, search);

        return ResultUtil.success(tCathetermorphologyPage);
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
        tCathetermorphologyService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
