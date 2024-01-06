package com.example.xuerun.advert.dao;

import com.example.xuerun.advert.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Picture)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface PictureDao {

    /**
     * 批量保存
     */
    int insertBatch(List<Picture> pictureList);
    /**
     * 查询多条
     */
    List<Picture> queryAllPicture(@Param("state")Integer state);
    /**
     * 查询单条
     */
    Picture queryById(@Param("pictreid")Integer pictreid);
    /**
     * 修改单条
     */
    int update(Picture picture);
    /**
     * 保存单条
     */
    int insert(Picture picture);
    /**

    Picture queryById(Integer pictreid);

    List<Picture> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Picture> queryAll(Picture picture);

    int insert(Picture picture);

    int update(Picture picture);

    int deleteById(Integer pictreid);
     */
}