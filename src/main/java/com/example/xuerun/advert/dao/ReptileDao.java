package com.example.xuerun.advert.dao;

import com.example.xuerun.advert.entity.Reptile;

import java.util.List;

/**
 * (Reptile)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface ReptileDao {

    /**
     * 查询出所有的自动化的爬虫
     */
    List<Reptile> queryWebIdAotomatic(Integer websiteid);
    /**

    Reptile queryById(Integer reptileid);

    List<Reptile> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Reptile> queryAll(Reptile reptile);

    int insert(Reptile reptile);

    int update(Reptile reptile);

    int deleteById(Integer reptileid);
     */
}