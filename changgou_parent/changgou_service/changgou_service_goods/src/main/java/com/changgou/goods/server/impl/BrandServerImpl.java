package com.changgou.goods.server.impl;

import com.changgou.goods.dao.BrandDao;
import com.changgou.goods.server.BrandServer;
import com.changgou.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServerImpl implements BrandServer {
    @Autowired
    private BrandDao brandDao;
    //查询所有品牌列表
    @Override
    public List<Brand> findAll() {
        return brandDao.selectAll();
    }
    //根据id查询品牌
    @Override
    public Brand findById(Integer id) {
        return brandDao.selectByPrimaryKey(id);
    }
    //添加品牌
    @Override
    public void add(Brand brand) {
        //insert 那么所有的字段都会添加一遍即使没有值
        //inserSelective就会只给有值的字段赋值
        brandDao.insertSelective(brand);
    }
    //修改品牌
    @Override
    public void edit(Brand brand) {
        brandDao.updateByPrimaryKey(brand);
    }
    //删除品牌
    @Override
    public void deleteById(Integer id) {
        brandDao.deleteByPrimaryKey(id);
    }
    //根据条件查询
    @Override
    public List<Brand> findByQuery(String keyWord) {
        List<Brand> brandList=null;
        if (keyWord!=null&&keyWord.length()>0&&!"".equals(keyWord)) {
            Example exception = new Example(Brand.class);
            Example.Criteria criteria = exception.createCriteria();
           criteria.andLike("name","%"+keyWord+"%");
            criteria.orLike("letter","%"+keyWord+"%");
            brandList=brandDao.selectByExample(exception);
        }
        return brandList;
    }
}
