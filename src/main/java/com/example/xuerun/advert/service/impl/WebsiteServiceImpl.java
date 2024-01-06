package com.example.xuerun.advert.service.impl;

import com.example.xuerun.advert.dao.WebsiteDao;
import com.example.xuerun.advert.entity.Website;
import com.example.xuerun.advert.service.WebsiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Website)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {
    @Resource
    private WebsiteDao websiteDao;

    @Override
    public List<Website> queryAotomatic(Integer state) {
        return this.websiteDao.queryAotomatic(state);
    }

    @Override
    public Website queryById(Integer websiteid) {
        return this.websiteDao.queryById(websiteid);
    }

    /**

    @Override
    public Website queryById(Integer websiteid) {
        return this.websiteDao.queryById(websiteid);
    }

    @Override
    public List<Website> queryAllByLimit(int offset, int limit) {
        return this.websiteDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Website> queryAll(Website website){
        return this.websiteDao.queryAll(website);
    }

    @Override
    public boolean insert(Website website) {
        return this.websiteDao.insert(website) > 0;
    }

    @Override
    public boolean update(Website website) {
        return this.websiteDao.update(website) > 0;
    }

    @Override
    public boolean deleteById(Integer websiteid) {
        return this.websiteDao.deleteById(websiteid) > 0;
    }
     */
}