package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TLeaf;
import com.ahau.service.rattan.rattanforms.TLeafService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tLeaf")
@Api(description = "藤叶")
public class TLeafController {
    private final TLeafService tLeafService;

    @Autowired
    public TLeafController(TLeafService tLeafService) {this.tLeafService = tLeafService;}

    /**
     * 查询所有藤叶列表
     * @return
     */
    @ApiOperation(value = "获取所有藤叶列表", notes = "获取所有藤叶列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tLeafService.findAll());
    }

    /**
     * 查询一个藤叶列表
     * @param leafId
     * @return
     */
    @ApiOperation(value = "获取藤叶详细信息", notes = "根据url的id来获取藤叶详细信息")
    @GetMapping("findId/{leafId}")
    public Result findById(@ApiParam(name = "leafId", value = "需要查找的藤叶的id", required = true)
                           @PathVariable("leafId") Long leafId) {
        return ResultUtil.success(tLeafService.findById(leafId));
    }

    /**
     * 更新
     * @param tLeaf
     * @return
     */
    @ApiOperation(value = "更新藤叶信息", notes = "根据url的id来指定更新藤叶信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tLeaf", value = "要修改的属详细实体tLeaf", required = true)
                         @RequestBody TLeaf tLeaf) {
        return ResultUtil.success(tLeafService.update(tLeaf));
    }

    /**
     * 删除
     * @param leafId
     * @return
     */
    @ApiOperation(value = "删除藤叶", notes = "根据url的id来指定删除藤叶")
    @DeleteMapping("delete/{leafId}")
    public Result delete(@ApiParam(name = "leafId", value = "需删除藤叶的ID", required = true)
                         @PathVariable("leafId") Long leafId) {
        tLeafService.delete(leafId);
        return ResultUtil.success();
    }

    /**
     * 添加一个藤叶
     * @param tLeaf
     * @return
     */
    @ApiOperation(value = "创建藤叶", notes = "根据TLeaf对象创建藤叶")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tLeaf", value = "要添加的藤叶详细实体tLeaf", required = true)
                       @RequestBody TLeaf tLeaf) {
        return ResultUtil.success(tLeafService.save(tLeaf));
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
    public Result findTLeafNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TLeaf> tLeafPage = tLeafService.findTLeafNoQuery(page, size);

        return ResultUtil.success(tLeafPage);
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
    public Result findTLeafQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TLeaf> tLeafPage = tLeafService.findTLeafQuery(page, size, search);

        return ResultUtil.success(tLeafPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除藤叶")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除藤叶的id数组", required = true) @RequestParam List<Long> ids) {
        tLeafService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
