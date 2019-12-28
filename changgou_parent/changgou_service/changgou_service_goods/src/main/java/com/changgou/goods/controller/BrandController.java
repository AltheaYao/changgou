package com.changgou.goods.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.server.BrandServer;
import com.changgou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandServer brandServer;

    //查询所有品牌
    @GetMapping
    public Result findAll(){
        List<Brand> brandList = null;
        try {
            brandList = brandServer.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"获取数据失败");
        }
        return new Result(true, StatusCode.OK,"获取数据成功",brandList);
    }

    //查询所有品牌
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id){
        Brand brand = null;
        try {
            brand = brandServer.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"获取数据失败");
        }
        return new Result(true, StatusCode.OK,"获取数据成功",brand);
    }
    //添加品牌
    @PostMapping
    public Result add(@RequestBody Brand brand){

        try {
             brandServer.add(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"储存数据失败");
        }
        return new Result(true, StatusCode.OK,"储存数据成功");
    }
    //修改品牌
    @PutMapping
    public Result edit(@RequestBody Brand brand){

        try {
            brandServer.edit(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"修改数据失败");
        }
        return new Result(true, StatusCode.OK,"修改数据成功");
    }
    //删除品牌
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id){

        try {
         brandServer.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"删除品牌失败");
        }
        return new Result(true, StatusCode.OK,"删除品牌成功");
    }
    //根据条件查询
    @GetMapping("/findByQuery/{keyWord}")
    public Result findByQuery(@PathVariable String keyWord){
        List<Brand> brandList=null;
        try {
         brandList = brandServer.findByQuery(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,StatusCode.ERROR,"删除品牌失败");
        }
        return new Result(true, StatusCode.OK,"删除品牌成功",brandList);
    }
}
