package com.ahau.controller.bamboo.base;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.bamboo.base.Genus;
import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.echart.EchartData;
import com.ahau.entity.echart.Series;
import com.ahau.entity.echart.Visit;
import com.ahau.service.bamboo.base.GenusService;
import com.ahau.service.bamboo.base.SpecService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/genus")
@Api(description = "属")
@CacheConfig(cacheNames = "genus")
public class GenusController {
    @Autowired
    private final GenusService genusService;
    @Autowired
    private  SpecService specService;

    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public GenusController(GenusService genusService) {
        this.genusService = genusService;
    }

    /**
     * 查询所有属列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有属列表", notes = "获取所有属列表")
    @GetMapping("findAll")
    @Cacheable(value = "genus-findAll")
    public Result findAll() {
        return ResultUtil.success(genusService.findAll());
    }

    /**
     * 查询一个属
     *
     * @param genusId
     * @returnR
     */
    @ApiOperation(value = "获取属详细信息", notes = "根据url的id来获取属详细信息")
    @GetMapping("findId/{genusId}")
    @Cacheable(value = "genus-findById")
    public Result findById(@ApiParam(name = "genusId", value = "需要查找的属的id", required = true) @PathVariable("genusId") Long genusId) {
        return ResultUtil.success(genusService.findById(genusId));
    }

    /**
     * 更新
     *
     * @param genus
     * @return
     */
    @ApiOperation(value = "更新属信息", notes = "根据url的id来指定更新属信息")
    @PutMapping("update")
    @CachePut(value = "genus-update")
    public Result update(@ApiParam(name = "genus", value = "要修改的属详细实体genus", required = true)
                                     Genus genus) {
        try {
            if (genusService.IsNameChExisted(genus.getGenusNameCh(),genus.getGenusId()))
                return ResultUtil.error(500, "该竹属已存在");
            return ResultUtil.success(genusService.update(genus));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }

    }

    /**
     * 删除
     *
     * @param genusId
     */
    @ApiOperation(value = "删除属", notes = "根据url的id来指定删除属")
    @DeleteMapping("delete/{genusId}")
    @CacheEvict(value = "genus-delete")
    public Result delete(@ApiParam(name = "genusId", value = "需删除属的ID", required = true)
                         @PathVariable("genusId") Long genusId) {
        try {
            genusService.delete(genusId);
        } catch (Exception e) {
            return ResultUtil.error(1451, "提示：该属存在竹种信息，因此无法删除！");
        }

        return ResultUtil.success();
    }

    /**
     * 添加一个属
     *
     * @param genus
     * @return
     */
    @ApiOperation(value = "创建属", notes = "根据Genus对象创建属")
    @PostMapping("save")
    public Result save(@ApiParam(name = "genus", value = "要添加的属详细实体genus", required = true) @RequestBody Genus genus) {
        try {
            if (genusService.IsNameChExisted(genus.getGenusNameCh()))
                return ResultUtil.error(500, "该竹属已存在");
            return ResultUtil.success(genusService.save(genus));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(500, e.getMessage());
        }
    }

    /**
     * 分页无条件查找
     *
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
    @Cacheable(value = "genus-findGenusNoQuery")
    public Result findGenusNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<Genus> genusPage = genusService.findGenusNoQuery(page, size);

        return ResultUtil.success(genusPage);
    }

    /**
     * 分页有条件查找
     *
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
    @Cacheable(value = "genus-findGenusQuery", key = "#search")
    public Result findGenusQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {
        Page<Genus> genusPage = genusService.findGenusQuery(page, size, search);

        return ResultUtil.success(genusPage);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除属")
    @DeleteMapping("deleteByIds")
    @CacheEvict(value = "genus-deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除属的id数组", required = true) @RequestParam List<Long> ids) {
        try {
            genusService.deleteByIds(ids);
        } catch (Exception e) {
            return ResultUtil.error(1451, "提示：该属存在竹种信息，因此无法删除");
        }
        return ResultUtil.success();
    }

//    @ApiOperation(value = "导出", notes = "导出竹属数据到Excel")
//    @PostMapping("exportExcel")
//    public Result addToExcel() throws Exception {
//        // 获取数据
//        List<Genus> list = genusService.findAll();
//
//        // excel标题
//        String[] title = {"属Id", "中文名", "英文名", "拉丁名", "别名", "描述"};
//
//        // sheet文件名
//        String sheetName = "竹属";
//
//        // 将数据库中数据存到String数组中
//        String[][] values = new String[list.size()][6];
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getGenusId() != null) {
//                values[i][0] = list.get(i).getGenusId().toString();
//            }
//            values[i][1] = list.get(i).getGenusNameCh();
//            values[i][2] = list.get(i).getGenusNameEn();
//            values[i][3] = list.get(i).getGenusNameLd();
//            values[i][4] = list.get(i).getGenusNameOth();
//            values[i][2] = list.get(i).getGenusDesc();
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream("F:/竹属.xls");
//        HSSFWorkbook workbook = ExcelUtils.getHSSFWorkbook(sheetName, title, values);
//        workbook.write(fileOutputStream);
//        fileOutputStream.close();
//        return ResultUtil.success("导出成功");
//    }

//    @ApiOperation(value = "导入", notes = "导入竹属Excel文件到数据库")
//    @PostMapping("importExcel")
//    public Result importExcel(String genusPath, HttpServletRequest request) {
//        //得到上传路径的硬盘路径
//        String dir = request.getServletContext().getRealPath("/");
//
//        String path = dir + genusPath;
//
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //读取文件
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(path);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//        //sheet文件名
//        String sheetName = "Sheet1";
//        //将excel中的数据读取到String数组中
//        String[][] values = new String[0][];
//
//        try {
//            values = ExcelUtils.getValuesFromExcel(inputStream, sheetName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //将String数组中的数据封装到实体类
//        boolean insert = false;
//        for (int i = 1; i < values.length; i++) {
//            Genus genus = new Genus();
//            if (values[i][0] != null) {
//                genus.setGenusId(Long.parseLong(values[i][0]));
//            }
//            genus.setGenusNameCh(values[i][1]);
//            genus.setGenusNameEn(values[i][2]);
//            genus.setGenusNameLd(values[i][3]);
//            genus.setGenusNameOth(values[i][4]);
//            genus.setGenusDesc(values[i][5]);
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            //导入数据库
//            insert = genusService.insertOrUpdateAllColum(genus);
////            try {
////                genusService.update(genus);
////            } catch (Exception e) {
////                return ResultUtil.error(500, "导入数据出错");
////            }
////            return ResultUtil.success("导入成功");
//        }
//
//
//        if (insert) {
//            return ResultUtil.success("导入成功");
//        }else {
//            return ResultUtil.error(500,"导入失败");
//        }
//    }

    @GetMapping("/showEchartPie")
    @ApiOperation(value = "饼图", notes = "饼图")
    @Cacheable(value = "genus-showEchartPie")
    public EchartData PieData() {
        List<String> legend = new ArrayList<String>();
        List<Map> serisData=new ArrayList<Map>();
        List<Visit> list = genusService.getGenus();
        for (Visit visit : list) {
            Map map =new HashMap();
            legend.add(visit.getName());
            map.put("value", visit.getValue());
            map.put("name",visit.getName());
            serisData.add(map);
        }
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("总数比较", "pie",serisData));
        EchartData data = new EchartData(legend,null, series);
        return data;
    }


    @GetMapping("/showEchartTree")
    @ApiOperation(value = "树形", notes = "树形")
    @Cacheable(value = "genus-showEchartTree")
    public Map<String,Object> showEchartTree() {
        Map<String,Object> map =new HashMap<>();
        List<Map> map_child=new ArrayList<Map>();
        map.put("name","属");
        map.put("children",map_child);

        List<Genus> list = genusService.findAll();
        for (Genus genus : list) {
            Map<String,Object> map_child2 =new HashMap<>();
            map_child2.put("name",genus.getGenusNameCh());
            List<String> list1=specService.findGenQuery(genus);
            List<Map> map_child3=new ArrayList<Map>();
            map_child2.put("children",map_child3);
            for (String s : list1) {
                Map<String,Object> map3 =new HashMap<>();
                map3.put("name",s);
                map_child3.add(map3);
            }

            map_child.add(map_child2);
        }


   /*     for (Visit visit : list) {
            Map map =new HashMap();
            legend.add(visit.getName());
            map.put("value", visit.getValue());
            map.put("name",visit.getName());
            serisData.add(map);
        }
        List<Series> series = new ArrayList<Series>();// 纵坐标
        series.add(new Series("总数比较", "pie",serisData));
        EchartData data = new EchartData(legend,null, series);*/
        return map;
    }
//
//    @ApiOperation(value = "获取所有属数量", notes = "获取所有属数量")
//    @GetMapping("findTotalGenus")
//    public Result findTotalGenus() {
//        ModelAndView modelAndView = new ModelAndView();
//        Long sum = genusService.findTotalGenus();
//        System.out.println(sum+"..........................");
//        modelAndView.addObject("sum",sum);
//        return ResultUtil.success(sum);
//    }
}

