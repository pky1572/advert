package com.example.xuerun.advert.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -42747285127167906L;
    /**
    * id
    */
    private Integer roleid;
    /**
    * 车型id
    */
    private Integer modelid;
    /**
    * 车型名称
    */
    private String modelname;
    /**
    * 规则，文章标题
    */
    private String roletitle;
    /**
    * 网站id
    */
    private Integer websiteid;
    /**
    * 网址
    */
    private String websiteurl;
    /**
    * 创建时间
    */
    private Date createtime;
    /**
    * 批改时间
    */
    private Date updatetime;
    /**
    * 批改状态（0不可用，1可用，2未批改）
    */
    private Integer state;


}