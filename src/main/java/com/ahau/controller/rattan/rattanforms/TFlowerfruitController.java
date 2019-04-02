package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TFlowerfruit;
import com.ahau.service.rattan.rattanforms.TFlowerfruitService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tFlowerfruit")
@Api(description = "藤花果形态")
public class TFlowerfruitController {
    private final TFlowerfruitService tFlowerfruitService;

    @Autowired
    public TFlowerfruitController(TFlowerfruitService tFlowerfruitService) {this.tFlowerfruitService = tFlowerfruitService;}

    /**
     * 查询所有花果形态列表
     * @return
     */
    @ApiOperation(value = "获取所有花果形态列表", notes = "获取所有花果形态列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tFlowerfruitService.findAll());
    }

    /**
     * 查询一个花果形态列表
     * @param flofruitId
     * @return
     */
    @ApiOperation(value = "获取花果形态详细信息", notes = "根据url的id来获取花果形态详细信息")
    @GetMapping("findId/{flofruitId}")
    public Result findById(@ApiParam(name = "flofruitId", value = "需要查找的花果形态的id", required = true)
                           @PathVariable("flofruitId") Long flofruitId) {
        return ResultUtil.success(tFlowerfruitService.findById(flofruitId));
    }

    /**
     * 更新
     * @param tFlowerfruit
     * @return
     */
    @ApiOperation(value = "更新花果形态信息", notes = "根据url的id来指定更新花果形态信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tFlowerfruit", value = "要修改的属详细实体tFlowerfruit", required = true)
                         @RequestBody TFlowerfruit tFlowerfruit) {
        return ResultUtil.success(tFlowerfruitService.update(tFlowerfruit));
    }

    /**
     * 删除
     * @param flofruitId
     * @return
     */
    @ApiOperation(value = "删除花果形态", notes = "根据url的id来指定删除花果形态")
    @DeleteMapping("delete/{flofruitId}")
    public Result delete(@ApiParam(name = "flofruitId", value = "需删除花果形态的ID", required = true)
                         @PathVariable("flofruitId") Long flofruitId) {
        tFlowerfruitService.delete(flofruitId);
        return ResultUtil.success();
    }

    /**
     * 添加一个花果形态
     * @param tFlowerfruit
     * @return
     */
    @ApiOperation(value = "创建花果形态", notes = "根据TFlowerfruit对象创建花果形态")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tFlowerfruit", value = "要添加的花果形态详细实体tFlowerfruit", required = true)
                       @RequestBody TFlowerfruit tFlowerfruit) {
        return ResultUtil.success(tFlowerfruitService.save(tFlowerfruit));
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
    public Result findTFlowerfruitNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TFlowerfruit> tFlowerfruitPage = tFlowerfruitService.findTFlowerfruitNoQuery(page, size);

        return ResultUtil.success(tFlowerfruitPage);
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
    public Result findTFlowerfruitQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TFlowerfruit> tFlowerfruitPage = tFlowerfruitService.findTFlowerfruitQuery(page, size, search);

        return ResultUtil.success(tFlowerfruitPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除花果形态")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除花果形态的id数组", required = true) @RequestParam List<Long> ids) {
        tFlowerfruitService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
