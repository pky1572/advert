package com.example.xuerun.advert.service.impl;

import com.example.xuerun.advert.dao.PositionDao;
import com.example.xuerun.advert.entity.Position;
import com.example.xuerun.advert.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Position)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    @Override
    public List<Position> queryWebIdAotomatic(Integer websiteid) {
        return this.positionDao.queryWebIdAotomatic(websiteid);
    }

    @Override
    public Position queryById(Integer locationid) {
        return this.positionDao.queryById(locationid);
    }

    /**

    @Override
    public Position queryById(Integer locationid) {
        return this.positionDao.queryById(locationid);
    }

    @Override
    public List<Position> queryAllByLimit(int offset, int limit) {
        return this.positionDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Position> queryAll(Position position){
        return this.positionDao.queryAll(position);
    }

    @Override
    public boolean insert(Position position) {
        return this.positionDao.insert(position) > 0;
    }

    @Override
    public boolean update(Position position) {
        return this.positionDao.update(position) > 0;
    }

    @Override
    public boolean deleteById(Integer locationid) {
        return this.positionDao.deleteById(locationid) > 0;
    }
     */
}