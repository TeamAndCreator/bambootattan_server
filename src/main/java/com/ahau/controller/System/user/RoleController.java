package com.ahau.controller.System.user;


import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.user.Role;
import com.ahau.service.system.user.RoleService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(description = "角色")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {this.roleService = roleService;}

    /**
     * 查询所有角色列表
     * @return
     */
    @ApiOperation(value = "获取所有角色列表", notes = "获取所有角色列表")
    @GetMapping("findAll")
    public Result findAll() {
        return ResultUtil.success(roleService.findAll());
    }

    /**
     * 查询一个角色
     * @param roleId
     * @return
     */
    @ApiOperation(value = "获取角色详细信息", notes = "根据url的id来获取角色详细信息")
    @GetMapping("findId/{roleId}")
    public Result findById(@ApiParam(name = "roleId", value = "需要查找的角色的id", required = true) @PathVariable("roleId") int roleId) {
        return ResultUtil.success(roleService.findById(roleId));
    }

    /**
     * 更新
     * @param role
     * @return
     */
    @ApiOperation(value = "更新角色信息", notes = "根据url的id来指定更新角色信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "role", value = "要修改的属详细实体role", required = true)
                         @RequestBody Role role) {
        return ResultUtil.success(roleService.update(role));
    }

    /**
     * 删除
     * @param roleId
     * @return
     */
    @ApiOperation(value = "删除角色", notes = "根据url的id来指定删除角色")
    @DeleteMapping("delete/{roleId}")
    public Result delete(@ApiParam(name = "roleId", value = "需删除角色的ID", required = true)
                         @PathVariable("roleId") int roleId) {
        roleService.delete(roleId);
        return ResultUtil.success();
    }

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    @ApiOperation(value = "创建角色", notes = "根据Role对象创建角色")
    @PostMapping("save")
    public Result save(@ApiParam(name = "role", value = "要添加的角色详细实体role", required = true) @RequestBody Role role) {
        return ResultUtil.success(roleService.save(role));
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
    public Result findRoleNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Role> rolePage = roleService.findRoleNoQuery(page, size);

        return ResultUtil.success(rolePage);
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
    public Result findRoleQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<Role> rolePage = roleService.findRoleQuery(page, size, search);

        return ResultUtil.success(rolePage);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除角色")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除角色的id数组", required = true) @RequestParam List<Integer> ids) {
        roleService.deleteByIds(ids);
        return ResultUtil.success();
    }
}
