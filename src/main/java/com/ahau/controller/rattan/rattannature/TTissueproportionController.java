package com.ahau.controller.rattan.rattannature;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattannature.TTissueproportion;
import com.ahau.service.rattan.rattannature.TTissueproportionService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 藤解剖性质_组织比量控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/tTissueproportion")
@Api(description = "藤解剖性质_组织比量")
public class TTissueproportionController {
    private final TTissueproportionService tTissueproportionService;

    @Autowired
    public TTissueproportionController(TTissueproportionService tTissueproportionService) {this.tTissueproportionService = tTissueproportionService;}

    /**
     * 查询所有解剖性质_组织比量列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_组织比量列表", notes = "获取所有解剖性质_组织比量列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tTissueproportionService.findAll());
    }

    /**
     * 查询一个解剖性质_组织比量列表
     * @param stId
     * @return
     */
    @ApiOperation(value = "获取解剖性质_组织比量详细信息", notes = "根据url的id来获取解剖性质_组织比量详细信息")
    @GetMapping("findId/{stId}")
    public Result findById(@ApiParam(name = "stId", value = "需要查找的解剖性质_组织比量的id", required = true)
                           @PathVariable("stId") Long stId) {
        return ResultUtil.success(tTissueproportionService.findById(stId));
    }

    /**
     * 更新
     * @param tTissueproportion
     * @return
     */
    @ApiOperation(value = "更新解剖性质_组织比量信息", notes = "根据url的id来指定更新解剖性质_组织比量信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tTissueproportion",
            value = "要修改的属详细实体tTissueproportion", required = true)
                         @RequestBody TTissueproportion tTissueproportion) {
        return ResultUtil.success(tTissueproportionService.update(tTissueproportion));
    }

    /**
     * 删除
     * @param stId
     * @return
     */
    @ApiOperation(value = "删除解剖性质_组织比量", notes = "根据url的id来指定删除解剖性质_组织比量")
    @DeleteMapping("delete/{stId}")
    public Result delete(@ApiParam(name = "stId", value = "需删除解剖性质_组织比量的ID", required = true)
                         @PathVariable("stId") Long stId) {
        tTissueproportionService.delete(stId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_组织比量
     * @param tTissueproportion
     * @return
     */
    @ApiOperation(value = "创建解剖性质_组织比量", notes = "根据TTissueproportion对象创建解剖性质_组织比量")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tTissueproportion",
            value = "要添加的解剖性质_组织比量详细实体tTissueproportion", required = true)
                       @RequestBody TTissueproportion tTissueproportion) {
        return ResultUtil.success(tTissueproportionService.save(tTissueproportion));
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
    public Result findTTissueproportionNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TTissueproportion> tTissueproportionPage = tTissueproportionService.findTTissueproportionNoQuery(page, size);

        return ResultUtil.success(tTissueproportionPage);
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
    public Result findTTissueproportionQuery(@RequestParam Integer page, @RequestParam Integer size,
                                            String search) {

        Page<TTissueproportion> tTissueproportionPage = tTissueproportionService.findTTissueproportionQuery(page, size, search);

        return ResultUtil.success(tTissueproportionPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除解剖性质_组织比量")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除解剖性质_组织比量的id数组", required = true)
                              @RequestParam List<Long> ids) {
        tTissueproportionService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
