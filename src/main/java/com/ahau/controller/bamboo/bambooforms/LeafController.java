package com.ahau.controller.bamboo.bambooforms;

import com.ahau.entity.bamboo.bambooforms.Leaf;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bambooforms.LeafService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 竹叶控制层接口
 * Created by: 张理
 * 2018-11-12
 */
@RestController
@RequestMapping("/leaf")
@Api(description = "竹叶")
public class LeafController {
    private final LeafService leafService;

    @Autowired
    public LeafController(LeafService leafService) {this.leafService = leafService;}

    /**
     * 查询所有竹叶列表
     * @return
     */
    @ApiOperation(value = "获取所有竹叶列表", notes = "获取所有竹叶列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(leafService.findAll());
    }

    /**
     * 查询一个竹叶列表
     * @param leafId
     * @return
     */
    @ApiOperation(value = "获取竹叶详细信息", notes = "根据url的id来获取竹叶详细信息")
    @GetMapping("findId/{leafId}")
    public Result findById(@ApiParam(name = "leafId", value = "需要查找的竹叶的id", required = true)
                           @PathVariable("leafId") Long leafId) {
        return ResultUtil.success(leafService.findById(leafId));
    }

    /**
     * 更新
     * @param leaf
     * @return
     */
    @ApiOperation(value = "更新竹叶信息", notes = "根据url的id来指定更新竹叶信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "leaf", value = "要修改的属详细实体leaf", required = true)
                         @RequestBody Leaf leaf) {
        return ResultUtil.success(leafService.update(leaf));
    }

    /**
     * 删除
     * @param leafId
     * @return
     */
    @ApiOperation(value = "删除竹叶", notes = "根据url的id来指定删除竹叶")
    @DeleteMapping("delete/{leafId}")
    public Result delete(@ApiParam(name = "leafId", value = "需删除竹叶的ID", required = true)
                         @PathVariable("leafId") Long leafId) {
        leafService.delete(leafId);
        return ResultUtil.success();
    }

    /**
     * 添加一个竹叶
     * @param leaf
     * @return
     */
    @ApiOperation(value = "创建竹叶", notes = "根据Leaf对象创建竹叶")
    @PostMapping("save")
    public Result save(@ApiParam(name = "leaf", value = "要添加的竹叶详细实体leaf", required = true)
                       @RequestBody Leaf leaf) {
        return ResultUtil.success(leafService.save(leaf));
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
    public Result findLeafNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Leaf> leafPage = leafService.findLeafNoQuery(page, size);

        return ResultUtil.success(leafPage);
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
    public Result findLeafQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Leaf> leafPage = leafService.findLeafQuery(page, size, search);

        return ResultUtil.success(leafPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除竹叶")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除竹叶的id数组", required = true) @RequestParam List<Long> ids) {
        leafService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
