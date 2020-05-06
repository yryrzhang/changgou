package com.changgou.goods.dao;

import com.changgou.goods.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author : Gordon Zhang
 * @Date: 4/24/2020 10:24 AM
 * @Version 1.0
 */
public interface BrandMapper extends Mapper<Brand> {

    @Select("SELECT name,image FROM tb_brand WHERE id IN " +
            "(SELECT brand_id FROM tb_category_brand WHERE category_id IN " +
            "(SELECT id FROM tb_category WHERE NAME=#{name}) )order by seq")
    public List<HashMap> findListByCategoryName(@Param("name") String
                                                        categoryName);
}
