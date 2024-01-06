package com.example.xuerun.advert.service.impl;

import com.example.xuerun.advert.dao.PictureDao;
import com.example.xuerun.advert.entity.Picture;
import com.example.xuerun.advert.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Picture)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {
    @Resource
    private PictureDao pictureDao;

    @Override
    public boolean insertBatch(List<Picture> pictureList) {
        return this.pictureDao.insertBatch(pictureList) > 0;
    }

    @Override
    public List<Picture> queryAllPicture(Integer state) {
        return this.pictureDao.queryAllPicture(state);
    }

    @Override
    public Picture queryById(Integer pictreid) {
        return this.pictureDao.queryById(pictreid);
    }

    @Override
    public boolean insert(Picture picture) {
        return this.pictureDao.insert(picture) > 0;
    }

    @Override
    public boolean update(Picture picture) {
        return this.pictureDao.update(picture) > 0;
    }


    /**

    @Override
    public Picture queryById(Integer pictreid) {
        return this.pictureDao.queryById(pictreid);
    }

    @Override
    public List<Picture> queryAllByLimit(int offset, int limit) {
        return this.pictureDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Picture> queryAll(Picture picture){
        return this.pictureDao.queryAll(picture);
    }

    @Override
    public boolean insert(Picture picture) {
        return this.pictureDao.insert(picture) > 0;
    }

    @Override
    public boolean update(Picture picture) {
        return this.pictureDao.update(picture) > 0;
    }

    @Override
    public boolean deleteById(Integer pictreid) {
        return this.pictureDao.deleteById(pictreid) > 0;
    }
     */
}