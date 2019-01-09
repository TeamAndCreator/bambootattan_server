package com.ahau.controller.System;


import com.ahau.entity.bamboo.base.Result;
import com.ahau.service.system.RoleService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "获取角色详细信息", notes = "根据url的id来获取角色详细信息")
    @GetMapping("findId/{roleId}")
    public Result findById(@ApiParam(name = "roleId", value = "需要查找的角色的id", required = true) @PathVariable("roleId") Long roleId) {
        return ResultUtil.success(roleService.findById(roleId));
    }



}
