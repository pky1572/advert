package com.example.xuerun.advert.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * (Position)实体类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Data
public class Position implements Serializable {
    private static final long serialVersionUID = -26591097042957712L;
    /**
    * 定位id
    */
    private Integer locationid;
    /**
    * 网站id
    */
    private Integer websiteid;
    /**
    * 定位xpath
    */
    private String region;
    /**
    * 滚动区域定位(鼠标停留位置)
    */
    private String scrollarea;
    /**
    * 等级
    */
    private String level;


}