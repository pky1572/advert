package com.example.xuerun.advert.service;

import com.example.xuerun.advert.entity.Brand;

import java.util.List;

/**
 * (Brand)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface ModelService {

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

    List<Brand> queryAllByLimit(int offset, int limit);

    List<Brand> queryAll(Brand model);

    boolean insert(Brand model);

    boolean update(Brand model);

    boolean deleteById(Integer modelid);
     */
}