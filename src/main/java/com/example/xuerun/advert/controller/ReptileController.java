package com.example.xuerun.advert.controller;

import com.example.xuerun.advert.service.ReptileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * (Reptile)表控制层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Controller
@RequestMapping(value = "/reptile")
public class ReptileController {
    /**
     * 服务对象
     */
    @Resource
    private ReptileService reptileService;

    /**

    @GetMapping("selectOne")
    public Reptile selectOne(Integer id) {
        return this.reptileService.queryById(id);
    }
     */
}