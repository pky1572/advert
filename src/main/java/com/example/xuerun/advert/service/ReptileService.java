package com.example.xuerun.advert.service;

import com.example.xuerun.advert.entity.Reptile;

import java.util.List;

/**
 * (Reptile)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface ReptileService {

    /**
     * 查询出所有的自动化的爬虫
     */
    List<Reptile> queryWebIdAotomatic(Integer websiteid);

    /**

    Reptile queryById(Integer reptileid);

    List<Reptile> queryAllByLimit(int offset, int limit);

    List<Reptile> queryAll(Reptile reptile);

    boolean insert(Reptile reptile);

    boolean update(Reptile reptile);

    boolean deleteById(Integer reptileid);
     */
}