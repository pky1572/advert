package com.example.xuerun.advert.dao;

import com.example.xuerun.advert.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Position)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface PositionDao {

    /**
     * 查询出所有的自动化的定位
     */
    List<Position> queryWebIdAotomatic(@Param("websiteid")Integer websiteid);
    /**
     * 查询出这个定位的信息
     */
    Position queryById(@Param("locationid")Integer locationid);
    /**

    Position queryById(Integer locationid);

    List<Position> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Position> queryAll(Position position);

    int insert(Position position);

    int update(Position position);

    int deleteById(Integer locationid);
     */
}