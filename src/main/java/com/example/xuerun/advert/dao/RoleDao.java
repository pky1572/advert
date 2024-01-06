package com.example.xuerun.advert.dao;

import com.example.xuerun.advert.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Role)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
public interface RoleDao {

    /**
     * 查询出所有的自动化的规则
     */
    List<Role> queryAotomatic(@Param("state")Integer state);
    /**
     * 添加一条规则
     */
    int insert(Role role);
    /**
     * 查找一条规则
     */
    Role queryById(@Param("roleid")Integer roleid);
    /**
     * 查找一条规则
     */
    Role querytitle(@Param("roletitle")String roletitle);
    /**
     * 修改一条规则
     */
    int update(Role role);
    /**
     * 删除一条规则
     */
    int deleteById(Integer roleid);
    /**

    Role queryById(Integer roleid);

    List<Role> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Role> queryAll(Role role);

    int insert(Role role);

    int update(Role role);

    int deleteById(Integer roleid);
     */
}