package com.ahau.controller.bamboo.bamboonature;

import com.ahau.entity.bamboo.bamboonature.Vascularbundelmorphology;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.bamboo.bamboonature.VascularbundelmorphologyService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 解剖性质_维管束形态特征控制层接口
 * Created by: 张理
 * 2018-11-18
 */
@RestController
@RequestMapping("/vascularbundelmorphology")
@Api(description = "解剖性质_维管束形态特征")
@CacheConfig(cacheNames = "vascularbundelmorphology")
public class VascularbundelmorphologyController {
    private final VascularbundelmorphologyService vascularbundelmorphologyService;

    @Autowired
    public VascularbundelmorphologyController(VascularbundelmorphologyService vascularbundelmorphologyService) {this.vascularbundelmorphologyService = vascularbundelmorphologyService;}

    /**
     * 查询所有解剖性质_维管束形态特征列表
     * @return
     */
    @ApiOperation(value = "获取所有解剖性质_维管束形态特征列表", notes = "获取所有解剖性质_维管束形态特征列表")
    @GetMapping("findAll")
    @Cacheable(value = "vascularbundelmorphology-findAll")
    public Result findAll() {
        return ResultUtil.success(vascularbundelmorphologyService.findAll());
    }

    /**
     * 查询一个解剖性质_维管束形态特征列表
     * @param vbmId
     * @return
     */
    @ApiOperation(value = "获取解剖性质_维管束形态特征详细信息", notes = "根据url的id来获取解剖性质_维管束形态特征详细信息")
    @GetMapping("findId/{vbmId}")
    @Cacheable(value = "vascularbundelmorphology-findById",key = "#vbmId")
    public Result findById(@ApiParam(name = "vbmId", value = "需要查找的解剖性质_维管束形态特征的id", required = true)
                           @PathVariable("vbmId") Long vbmId) {
        return ResultUtil.success(vascularbundelmorphologyService.findById(vbmId));
    }

    /**
     * 更新
     * @param vascularbundelmorphology
     * @return
     */
    @ApiOperation(value = "更新解剖性质_维管束形态特征信息", notes = "根据url的id来指定更新解剖性质_维管束形态特征信息")
    @PutMapping("update")
    @CacheEvict(value = "vascularbundelmorphology-findById", key = "#vascularbundelmorphology.vbmId", allEntries = true)
    public Result update(@ApiParam(name = "vascularbundelmorphology",
            value = "要修改的属详细实体vascularbundelmorphology", required = true)
                         @RequestBody Vascularbundelmorphology vascularbundelmorphology) {
        return ResultUtil.success(vascularbundelmorphologyService.update(vascularbundelmorphology));
    }

    /**
     * 删除
     * @param vbmId
     * @return
     */
    @ApiOperation(value = "删除解剖性质_维管束形态特征", notes = "根据url的id来指定删除解剖性质_维管束形态特征")
    @DeleteMapping("delete/{vbmId}")
    @CacheEvict(value = "vascularbundelmorphology-findAll", allEntries = true)
    public Result delete(@ApiParam(name = "vbmId", value = "需删除解剖性质_维管束形态特征的ID", required = true)
                         @PathVariable("vbmId") Long vbmId) {
        vascularbundelmorphologyService.delete(vbmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个解剖性质_维管束形态特征
     * @param vascularbundelmorphology
     * @return
     */
    @ApiOperation(value = "创建解剖性质_维管束形态特征", notes = "根据Vascularbundelmorphology对象创建解剖性质_维管束形态特征")
    @PostMapping("save")
    @CacheEvict(value = "vascularbundelmorphology-findAll", allEntries = true)
    public Result save(@ApiParam(name = "vascularbundelmorphology",
            value = "要添加的解剖性质_维管束形态特征详细实体vascularbundelmorphology", required = true)
                       @RequestBody Vascularbundelmorphology vascularbundelmorphology) {
        return ResultUtil.success(vascularbundelmorphologyService.save(vascularbundelmorphology));
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
    @Cacheable(value = "vascularbundelmorphology-findVascularbundelmorphologyNoQuery")
    public Result findVascularbundelmorphologyNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Vascularbundelmorphology> vascularbundelmorphologyPage = vascularbundelmorphologyService.findVascularbundelmorphologyNoQuery(page, size);

        return ResultUtil.success(vascularbundelmorphologyPage);
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
    public Result findVascularbundelmorphologyQuery(@RequestParam Integer page, @RequestParam Integer size,
                                            String search) {

        Page<Vascularbundelmorphology> vascularbundelmorphologyPage = vascularbundelmorphologyService.findVascularbundelmorphologyQuery(page, size, search);

        return ResultUtil.success(vascularbundelmorphologyPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除解剖性质_维管束形态特征")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "vascularbundelmorphology-findAll", allEntries = true)
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除解剖性质_维管束形态特征的id数组", required = true)
                              @RequestParam List<Long> ids) {
        vascularbundelmorphologyService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
