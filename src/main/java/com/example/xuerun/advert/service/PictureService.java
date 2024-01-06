package com.example.xuerun.advert.service;

import com.example.xuerun.advert.entity.Picture;

import java.util.List;

/**
 * (Picture)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface PictureService {

    /**
     * 批量保存
     */
    boolean insertBatch(List<Picture> pictureList);
    /**
     * 查询多条
     */
    List<Picture> queryAllPicture(Integer state);
    /**
     * 查询单条
     */
    Picture queryById(Integer pictreid);
    /**
     * 修改单条
     */
    boolean update(Picture picture);
    /**
     * 保存单条
     */
    boolean insert(Picture picture);
    /**
    Picture queryById(Integer pictreid);

    List<Picture> queryAllByLimit(int offset, int limit);

    List<Picture> queryAll(Picture picture);

    boolean insert(Picture picture);

    boolean update(Picture picture);

    boolean deleteById(Integer pictreid);
     */
}