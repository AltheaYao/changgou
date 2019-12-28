package com.changgou.goods.server;

import com.changgou.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandServer {
    List<Brand> findAll();

    Brand findById(Integer id);

    void add(Brand brand);

    void edit(Brand brand);

    void deleteById(Integer id);

    List<Brand> findByQuery(String keyWord);
}
