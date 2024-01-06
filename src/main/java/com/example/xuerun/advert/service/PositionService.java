package com.example.xuerun.advert.service;

import com.example.xuerun.advert.entity.Position;

import java.util.List;

/**
 * (Position)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface PositionService {


    /**
     * 查询出所有的自动化的定位
     */
    List<Position> queryWebIdAotomatic(Integer websiteid);
    /**
     * 查询出这个定位的信息
     */
    Position queryById(Integer locationid);
    /**

    Position queryById(Integer locationid);

    List<Position> queryAllByLimit(int offset, int limit);

    List<Position> queryAll(Position position);

    boolean insert(Position position);

    boolean update(Position position);

    boolean deleteById(Integer locationid);
     */
}