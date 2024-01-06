package com.example.xuerun.advert.dao;

import com.example.xuerun.advert.entity.Brand;

import java.util.List;

/**
 * (Brand)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface ModelDao {

    /**
     * 查询出所有的自动化的车型
     */
    List<Brand> queryAotomatic(Integer state);
    /**
     * 查询出这个车型的信息
     */
    Brand queryById(Integer modelid);
    /**

    Brand queryById(Integer modelid);

    List<Brand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Brand> queryAll(Brand model);


    int insert(Brand model);

    int update(Brand model);

    int deleteById(Integer modelid);
*/
}