package com.example.xuerun.advert.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Brand)实体类
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Data
public class Brand implements Serializable {
    private static final long serialVersionUID = 341450070382606250L;
    /**
    * id
    */
    private Integer modelid;
    /**
    * 车型
    */
    private String modelname;
    /**
    * 创建时间
    */
    private Date createtime;
    /**
    * 修改时间
    */
    private Date updatetime;
    /**
    * 状态：0弃用，1启用
    */
    private Integer state;


}