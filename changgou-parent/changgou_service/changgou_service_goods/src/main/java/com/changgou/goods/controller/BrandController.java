package com.changgou.goods.controller;


import com.changgou.entity.PageResult;
import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.goods.service.BrandService.BrandService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : Gordon Zhang
 * @Date: 4/24/2020 10:42 AM
 * @Version 1.0
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * @return
     */
    @GetMapping
    public Result findAll() {
        List<Brand> brandList = brandService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", brandList);

    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", brand);
    }

    @PostMapping("/brand")
    public Result add(@RequestBody Brand brand) {
        brandService.addBrand(brand);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @PostMapping("/{id}")
    public Result update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        brand.setId(id);
        brandService.updateBrand(brand);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @GetMapping("/search/{page}/{size}")
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        Page<Brand> brandPage = brandService.findPage(page, size);
        PageResult pageResult = new PageResult(brandPage.getTotal(), brandPage.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    @GetMapping("/search")
    public Result findList(@RequestParam HashMap searchMap) {
        List<Brand> brands = brandService.findList(searchMap);
        return new Result(true, StatusCode.OK, "查询成功", brands);
    }

    @GetMapping("/searchPage/{page}/{size}")
    public Result findPage(@RequestParam HashMap searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Brand> brandPage = brandService.findPage(searchMap, page, size);
        PageResult pageResult = new PageResult(brandPage.getTotal(), brandPage.getResult());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    @GetMapping("/categoryName/{category}")
    public Result findListByCategoryName(@PathVariable String category) {
        List<HashMap> brandList = brandService.findListByCategoryName(category);
        return new Result(true, StatusCode.OK, "查询成功", brandList);
    }
}
