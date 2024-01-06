package com.example.xuerun.advert.entity.vo;

import lombok.Data;

@Data
public class TemporaryData {
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
     * 定位id
     */
    private Integer id;

}
