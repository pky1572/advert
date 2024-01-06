package com.example.xuerun.advert.entity.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Excle {
    /**
     * 主站名称
     */
    @ExcelProperty({"主标题", "网站"})
    private String websitename;
    /**
     * 类型
     */
    @ExcelProperty({"主标题", "车型"})
    private String modelname;
    /**
     * 等级
     */
    @ExcelProperty({"主标题", "板块"})
    private String level;
    /**
     * 文章标题
     */
    @ExcelProperty({"主标题", "标题"})
    private String title;
    /**
     * 文章地址
     */
    @ExcelProperty({"主标题", "url"})
    private String articleurl;
    /**
     * 创建时间
     */
    @ExcelProperty({"主标题", "截图时间"})
    private Date createtime;
}
