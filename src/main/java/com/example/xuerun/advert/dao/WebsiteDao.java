package com.example.xuerun.advert.dao;

import com.example.xuerun.advert.entity.Website;

import java.util.List;

/**
 * (Website)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface WebsiteDao {

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

    List<Website> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Website> queryAll(Website website);

    int insert(Website website);

    int update(Website website);

    int deleteById(Integer websiteid);
     */
}