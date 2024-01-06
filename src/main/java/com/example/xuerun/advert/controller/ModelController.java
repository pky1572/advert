package com.example.xuerun.advert.controller;

import com.example.xuerun.advert.service.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * (Brand)表控制层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Controller
@RequestMapping(value = "/model")
public class ModelController {
    /**
     * 服务对象
     */
    @Resource
    private ModelService modelService;

    /**

    @GetMapping("selectOne")
    public Brand selectOne(Integer id) {
        return this.modelService.queryById(id);
    }
     */
}