package com.ahau.controller;

import com.ahau.entity.bamboo.base.Genus;
import com.ahau.service.GenusService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(description = "属")
public class GenusController {
    private final GenusService genusService;

    @Autowired
    public GenusController(GenusService genusService) {
        this.genusService = genusService;
    }

    /**
     * 查询所有属列表
     * @return
     */
    @GetMapping("find_all")
    public List<Genus> findAll(){
        return genusService.findAll();
    }

    /**
     * 查询一个属
     * @param id
     * @return
     */
    @GetMapping("find_by_id")
    public Genus findById(Long id) {
        return genusService.findById(id);
    }

    /**
     * 更新
     * @param genus
     * @return
     */
    @PutMapping("update")
    public Genus genusUpdate(Genus genus) {
        return genusService.save(genus);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("delete")
    public void delete(Long id) {
        genusService.delete(id);
    }

    /**
     * 添加一个属
     * @param genus
     * @return
     */
    @PostMapping("save")
    public Genus genusAdd(Genus genus) {
        return genusService.save(genus);
    }
}
