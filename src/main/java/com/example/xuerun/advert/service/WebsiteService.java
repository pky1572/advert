package com.example.xuerun.advert.service;

import com.example.xuerun.advert.entity.Website;

import java.util.List;

/**
 * (Website)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface WebsiteService {

    /**
     * 查询出所有的自动化的网站
     */
    List<Website> queryAotomatic(Integer state);
    /**
     * 查询出一个自动化的网站
     */
    Website queryById(Integer websiteid);
    /**

    Website queryById(Integer websiteid);

    List<Website> queryAllByLimit(int offset, int limit);

    List<Website> queryAll(Website website);

    boolean insert(Website website);

    boolean update(Website website);

    boolean deleteById(Integer websiteid);
     */
}