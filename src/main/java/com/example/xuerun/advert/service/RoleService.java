package com.example.xuerun.advert.service;

import com.example.xuerun.advert.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface RoleService {

    /**
     * 查询出所有的自动化的规则
     */
    List<Role> queryAotomatic(@Param("state")Integer state);
    /**
     * 添加一条规则
     */
    boolean insert(Role role);
    /**
     * 查找一条规则
     */
    Role queryById(@Param("roleid")Integer roleid);
    /**
     * 修改一条规则
     */
    boolean update(Role role);
    /**
     * 删除一条规则
     */
    boolean deleteById(@Param("roleid")Integer roleid);
    /**
     * 查找一条规则
     */
    Role querytitle(@Param("roletitle")String roletitle);
    /**

    Role queryById(Integer roleid);

    List<Role> queryAllByLimit(int offset, int limit);

    List<Role> queryAll(Role role);

    boolean insert(Role role);

    boolean update(Role role);

    boolean deleteById(Integer roleid);
     */
}