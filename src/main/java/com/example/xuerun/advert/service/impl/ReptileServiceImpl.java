package com.example.xuerun.advert.service.impl;

import com.example.xuerun.advert.dao.ReptileDao;
import com.example.xuerun.advert.entity.Reptile;
import com.example.xuerun.advert.service.ReptileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Reptile)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Service("reptileService")
public class ReptileServiceImpl implements ReptileService {
    @Resource
    private ReptileDao reptileDao;

    @Override
    public List<Reptile> queryWebIdAotomatic(Integer websiteid) {
        return this.reptileDao.queryWebIdAotomatic(websiteid);
    }
    /**

    @Override
    public Reptile queryById(Integer reptileid) {
        return this.reptileDao.queryById(reptileid);
    }

    @Override
    public List<Reptile> queryAllByLimit(int offset, int limit) {
        return this.reptileDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Reptile> queryAll(Reptile reptile){
        return this.reptileDao.queryAll(reptile);
    }

    @Override
    public boolean insert(Reptile reptile) {
        return this.reptileDao.insert(reptile) > 0;
    }

    @Override
    public boolean update(Reptile reptile) {
        return this.reptileDao.update(reptile) > 0;
    }

    @Override
    public boolean deleteById(Integer reptileid) {
        return this.reptileDao.deleteById(reptileid) > 0;
    }
     */
}