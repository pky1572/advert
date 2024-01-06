package com.example.xuerun.advert.controller;

import com.example.xuerun.advert.entity.Website;
import com.example.xuerun.advert.service.WebsiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Website)表控制层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Controller
@RequestMapping(value = "/website")
public class  WebsiteController {
    /**
     * 服务对象
     */
    @Resource
    private WebsiteService websiteService;


    /**
     * 查询所有的数据
     */
    @RequestMapping(value = "/websitelist",method = RequestMethod.GET)
    public String websitelist(Model model, @RequestParam("state")Integer state){
        List<Website> websiteList = websiteService.queryAotomatic(1);
        model.addAttribute("websiteList",websiteList);
        return "advert/rolelist";
    }

}