package com.example.xuerun.advert.controller;

import com.example.xuerun.advert.entity.Brand;
import com.example.xuerun.advert.entity.Role;
import com.example.xuerun.advert.entity.Website;
import com.example.xuerun.advert.service.ModelService;
import com.example.xuerun.advert.service.RoleService;
import com.example.xuerun.advert.service.WebsiteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController {
    static Logger logger = Logger.getRootLogger();
    @Autowired
    private RoleService roleService;
    @Resource
    private ModelService modelService;
    @Resource
    private WebsiteService websiteService;
    /**
     * 查询所有的数据
     */
    @RequestMapping(value = "/rolelist",method = RequestMethod.GET)
    public String rolelist(Model model, @RequestParam("state")Integer state){
        logger.info("rolelist查询多条规则数据"+state);
        List<Role> roleList = roleService.queryAotomatic(state);
        if(roleList.size()<=0){
            logger.error("查询多条规则数据失败");
            model.addAttribute("info","未查询到结果");
            return "advert/result";
        }
        List<Website> websiteList = websiteService.queryAotomatic(1);
        List<Brand> modelList = modelService.queryAotomatic(1);
        if(state==1){
            logger.info("启用的规则数据");
            model.addAttribute("zhuangtai","启用");
        }else if(state==2){
            logger.info("未启用的规则数据");
            model.addAttribute("zhuangtai","未启用");
        }else if(state==0){
            logger.info("已被删除的规则数据");
            model.addAttribute("zhuangtai","已被删除");
        }
        model.addAttribute("roleList",roleList);
        model.addAttribute("modelList",modelList);
        model.addAttribute("websiteList",websiteList);
        return "advert/roleList";
    }

    /**
     * 查询单条的数据
     */
    @RequestMapping(value = "/roleedit",method = RequestMethod.GET)
    public String roleedit(Model model,Integer roleid){
        logger.info("roleedit查询单条规则数据"+roleid);
        Role role = roleService.queryById(roleid);
        List<Brand> modelList = modelService.queryAotomatic(1);
        List<Website> websiteList = websiteService.queryAotomatic(1);
        model.addAttribute("websiteList",websiteList);
        model.addAttribute("role",role);
        model.addAttribute("modelList",modelList);
        return "advert/roleedit";
    }

    /**
     * 修改单条的数据
     */
    @RequestMapping(value = "/updaterole",method = RequestMethod.POST)
    public String updaterole(Model model, Role role){
        logger.info("updaterole修改单条规则数据");
        role.setRoletitle(HandleString(role.getRoletitle()));
        if(role.getWebsiteurl().length()<5||!role.getWebsiteurl().substring(0,4).equals("http")){
            role.setWebsiteurl("https://www.baidu.com/");
        }
        if(roleService.update(role)){
            logger.info("修改单条规则数据成功");
            model.addAttribute("info","成功");
            return "advert/result";
        }else{
            logger.info("修改单条规则数据失败");
            model.addAttribute("info","数据库操作失败");
            return "advert/result";
        }
    }

    /**
     * 添加单条的数据
     */
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(Model model, Role role){
        List<Brand> modelList = modelService.queryAotomatic(1);
        List<Website> websiteList = websiteService.queryAotomatic(1);
        model.addAttribute("websiteList",websiteList);
        model.addAttribute("modelList",modelList);
        return "advert/roleinsert";
    }
    @RequestMapping(value = "/insertrole",method = RequestMethod.POST)
    public String insertrole(Model model, Role role){
        logger.info("insertrole添加单条规则数据");
        role.setRoletitle(HandleString(role.getRoletitle()));
        role.setState(1);
        Brand brand = modelService.queryById(role.getModelid());
        if(role.getWebsiteurl().length()<5||!role.getWebsiteurl().substring(0,4).equals("http")){
            role.setWebsiteurl("https://www.baidu.com/");
        }
        role.setModelname(brand.getModelname());
        if(roleService.insert(role)){
            logger.info("添加单条规则数据成功");
            model.addAttribute("info","成功");
            return "advert/result";
        }else{
            logger.error("添加单条规则数据失败");
            model.addAttribute("info","数据库操作失败");
            return "advert/result";
        }
    }

    public String HandleString(String str){
        Pattern patten = Pattern.compile("[\\u4e00-\\u9fa5_a-zA-Z0-9]+");//编译正则表达式
        Matcher matcher = patten.matcher(str);// 指定要匹配的字符串
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.toString()); //结果：ab1
        while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            sb.append(matcher.group());//获取当前匹配的值
        }
        return sb.toString();
    }

}