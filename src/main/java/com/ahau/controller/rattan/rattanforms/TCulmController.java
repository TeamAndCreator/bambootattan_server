package com.ahau.controller.rattan.rattanforms;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.rattan.rattanforms.TCulm;
import com.ahau.service.rattan.rattanforms.TCulmService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tCulm")
@Api(description = "藤秆")
public class TCulmController {
    private final TCulmService tCulmService;

    @Autowired
    public TCulmController(TCulmService tCulmService) {this.tCulmService = tCulmService;}

    /**
     * 查询所有藤秆列表
     * @return
     */
    @ApiOperation(value = "获取所有藤秆列表", notes = "获取所有藤秆列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(tCulmService.findAll());
    }

    /**
     * 查询一个藤秆列表
     * @param culmId
     * @return
     */
    @ApiOperation(value = "获取藤秆详细信息", notes = "根据url的id来获取藤秆详细信息")
    @GetMapping("findId/{culmId}")
    public Result findById(@ApiParam(name = "culmId", value = "需要查找的藤秆的id", required = true) @PathVariable("culmId") Long culmId) {
        return ResultUtil.success(tCulmService.findById(culmId));
    }

    /**
     * 更新
     * @param tCulm
     * @return
     */
    @ApiOperation(value = "更新藤秆信息", notes = "根据url的id来指定更新藤秆信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "tCulm", value = "要修改的属详细实体tCulm", required = true)
                         @RequestBody TCulm tCulm) {
        return ResultUtil.success(tCulmService.update(tCulm));
    }

    /**
     * 删除
     * @param culmId
     * @return
     */
    @ApiOperation(value = "删除藤秆", notes = "根据url的id来指定删除藤秆")
    @DeleteMapping("delete/{culmId}")
    public Result delete(@ApiParam(name = "culmId", value = "需删除藤秆的ID", required = true)
                         @PathVariable("culmId") Long culmId) {
        tCulmService.delete(culmId);
        return ResultUtil.success();
    }

    /**
     * 添加一个藤秆
     * @param tCulm
     * @return
     */
    @ApiOperation(value = "创建藤秆", notes = "根据TCulm对象创建藤秆")
    @PostMapping("save")
    public Result save(@ApiParam(name = "tCulm", value = "要添加的藤秆详细实体tCulm", required = true) @RequestBody TCulm tCulm) {
        return ResultUtil.success(tCulmService.save(tCulm));
    }






//    @ApiOperation(value = "查找种", notes = "根据TCulm对象查找种")
//    @GetMapping(value = "findBySpec/{specId}")
//    public Result findBySpec(@ApiParam(name = "specId", value = "需要查找的种的Id", required = true) @PathVariable("specId") Long specId) {
//        try {
//            TCulm tCulm = tCulmService.findBySpecId(specId);
//            if (tCulm != null) {
//                return ResultUtil.error(500, "已存在该种");
//            } else {
//                return ResultUtil.success();
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ResultUtil.error(e.hashCode(), e.getMessage());
//        }
//    }

//    @ApiOperation(value = "查找种", notes = "根据TCulm对象查找种")
//    @GetMapping("findBySpec/{spec}")
//    public Result findBySpec(Spec spec) {
//        TCulm tCulm = tCulmService.findBySpec(spec);
//        if (tCulm != null) {
//            return ResultUtil.error(500, "已添加该种竹子的竹秆数据");
//        }
//        return ResultUtil.success(tCulmService.findBySpec(spec));
//    }

//    public Result findBySpec(Spec spec) {
//        try {
//            TCulm tCulm = tCulmService.findBySpec(spec);
//            if (tCulm != null)
//                return ResultUtil.error(500, "已添加该种竹子的竹竿数据");
//            return ResultUtil.success();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResultUtil.error(e.hashCode(), e.getMessage());
//        }
//    }



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
    public Result findTCulmNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<TCulm> tCulmPage = tCulmService.findTCulmNoQuery(page, size);

        return ResultUtil.success(tCulmPage);
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
    public Result findTCulmQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<TCulm> tCulmPage = tCulmService.findTCulmQuery(page, size, search);

        return ResultUtil.success(tCulmPage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除藤秆")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除藤秆的id数组", required = true) @RequestParam List<Long> ids) {
        tCulmService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
