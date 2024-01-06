package com.example.xuerun.advert.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;

/**
 * (Picture)实体类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Data
public class Picture implements Serializable {
    private static final long serialVersionUID = -61767422845687364L;
    /**
    *  图片id
    */
    private Integer pictreid;
    /**
    * 主站id
    */
    private Integer websiteid;
    /**
    * 主站url
    */
    private String websiteurl;
    /**
    * 主站名称
    */
    private String websitename;
    /**
    * 文章地址
    */
    private String articleurl;
    /**
    * 文章标题
    */
    private String title;
    /**
    * 截图保存地址
    */
    private String pictreurl;
    /**
    * 类型
    */
    private String modelname;
    /**
    * 等级
    */
    private String level;
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