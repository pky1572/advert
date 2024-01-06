package com.example.xuerun.advert.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * (Reptile)实体类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Data
public class Reptile implements Serializable {
    private static final long serialVersionUID = -78002412539342007L;
    /**
    * 爬虫id
    */
    private Integer reptileid;
    /**
    * 定位id(这个爬虫规则的定位位置的信息)
    */
    private Integer locationid;
    /**
    * 这个爬虫所属网站
    */
    private Integer websiteid;
    /**
    * 这个爬虫规则的区块（取这个里面的所有a标签）
    */
    private String divtitle;


}