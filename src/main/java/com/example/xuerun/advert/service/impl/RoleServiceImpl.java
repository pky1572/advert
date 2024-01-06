package com.example.xuerun.advert.service.impl;

import com.example.xuerun.advert.dao.RoleDao;
import com.example.xuerun.advert.entity.Role;
import com.example.xuerun.advert.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;


    @Override
    public List<Role> queryAotomatic(Integer state) {
        return this.roleDao.queryAotomatic(state);
    }

    @Override
    public boolean insert(Role role) {
        return this.roleDao.insert(role) > 0;
    }

    @Override
    public Role queryById(Integer roleid) {
        return this.roleDao.queryById(roleid);
    }

    @Override
    public boolean update(Role role) {
        return this.roleDao.update(role) > 0;
    }

    @Override
    public boolean deleteById(Integer roleid) {
        return this.roleDao.deleteById(roleid) > 0;
    }

    @Override
    public Role querytitle(String roletitle) {
        return this.roleDao.querytitle(roletitle);
    }

    /**

    @Override
    public Role queryById(Integer roleid) {
        return this.roleDao.queryById(roleid);
    }

    @Override
    public List<Role> queryAllByLimit(int offset, int limit) {
        return this.roleDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Role> queryAll(Role role){
        return this.roleDao.queryAll(role);
    }
    

    @Override
    public boolean insert(Role role) {
        return this.roleDao.insert(role) > 0;
    }

    @Override
    public boolean update(Role role) {
        return this.roleDao.update(role) > 0;
    }


     */
}