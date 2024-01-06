package com.example.xuerun.advert.service.impl;

import com.example.xuerun.advert.dao.ModelDao;
import com.example.xuerun.advert.entity.Brand;
import com.example.xuerun.advert.service.ModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Brand)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Service("modelService")
public class ModelServiceImpl implements ModelService {
    @Resource
    private ModelDao modelDao;

    @Override
    public List<Brand> queryAotomatic(Integer state) {
        return this.modelDao.queryAotomatic(state);
    }

    @Override
    public Brand queryById(Integer modelid) {
        return this.modelDao.queryById(modelid);
    }

    /**

    @Override
    public Brand queryById(Integer modelid) {
        return this.modelDao.queryById(modelid);
    }

    @Override
    public List<Brand> queryAllByLimit(int offset, int limit) {
        return this.modelDao.queryAllByLimit(offset, limit);
    }


    @Override
    public List<Brand> queryAll(Brand model){
        return this.modelDao.queryAll(model);
    }

    @Override
    public boolean insert(Brand model) {
        return this.modelDao.insert(model) > 0;
    }

    @Override
    public boolean update(Brand model) {
        return this.modelDao.update(model) > 0;
    }

    @Override
    public boolean deleteById(Integer modelid) {
        return this.modelDao.deleteById(modelid) > 0;
    }
     */
}