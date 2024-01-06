package com.example.xuerun.advert.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Website)实体类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Data
public class Website implements Serializable {
    private static final long serialVersionUID = 232650271529573412L;
    /**
    * 网站id
    */
    private Integer websiteid;
    /**
    * 网站名称
    */
    private String websitename;
    /**
    * 网站url
    */
    private String websiteurl;
    /**
    * 创建时间
    */
    private Date createtime;
    /**
    * 修改时间
    */
    private Date updatetime;
    /**
    * 状态
    */
    private Integer state;


}