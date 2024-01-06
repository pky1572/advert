package com.example.xuerun.advert.controller;

import com.example.xuerun.advert.entity.Brand;
import com.example.xuerun.advert.entity.Picture;
import com.example.xuerun.advert.entity.Role;
import com.example.xuerun.advert.entity.Website;
import com.example.xuerun.advert.service.ModelService;
import com.example.xuerun.advert.service.PictureService;
import com.example.xuerun.advert.service.RoleService;
import com.example.xuerun.advert.service.WebsiteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Picture)表控制层
 *
 * @author makejava
 * @since 2020-05-30 18:06:37
 */
@Controller
@RequestMapping(value = "/picture")
public class PictureController {
    static Logger logger = Logger.getRootLogger();
    @Autowired
    private PictureService pictureService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private WebsiteService websiteService;
    @Autowired
    private RoleController roleController;
    /**
     * 通过多条数据
     */
    @RequestMapping(value = "/picturelist",method = RequestMethod.GET)
    public String pictureList(Model model, Integer state){
        logger.info("pictureList获得多条数据"+state);
        List<Picture> pictureList = pictureService.queryAllPicture(state);
        if(pictureList.size()>0){
            model.addAttribute("pictureList",pictureList);
            if(state==1){
                logger.info("正常截图数据");
                model.addAttribute("zhuangtai","正常");
            }else if(state==2){
                logger.info("无效截图数据");
                model.addAttribute("zhuangtai","无效");
            }else if(state==0){
                logger.info("已被删除截图数据");
                model.addAttribute("zhuangtai","已被删除");
            }
            return "advert/pictureList";
        }else{
            model.addAttribute("info","未查询到结果");
            return "advert/result";
        }
    }
    /**
     * 查询单条数据
     */
    @RequestMapping(value = "/pictureedit",method = RequestMethod.GET)
    public String pictureedit(Model model, @RequestParam("pictreid")Integer pictreid){
        logger.info("pictureedit查询单条截图数据"+pictreid);
        Picture picture = pictureService.queryById(pictreid);
        List<Brand> brandList = modelService.queryAotomatic(1);
        if(!ObjectUtils.isEmpty(picture)){
            logger.info("查询单条截图数据成功");
            model.addAttribute("picture",picture);
            model.addAttribute("brandList",brandList);
            return "advert/pictureedit";
        }else{
            logger.error("查询单条截图数据出错");
            model.addAttribute("info","未查询到结果");
            return "advert/result";
        }
    }


    /**
     *
     * 删除一条截图信息，以及对应的role
     */
    @Transactional
    @RequestMapping(value = "/deletepicture",method = RequestMethod.GET)
    public String deletepicture(Model model,@RequestParam("pictreid")Integer pictreid){
        logger.info("deletepicture删除（无效）单条截图数据"+pictreid);
        Picture picture = pictureService.queryById(pictreid);
        picture.setState(0);
        if(pictureService.update(picture)){
            Role roledb = roleService.querytitle(picture.getTitle());
            if(ObjectUtils.isEmpty(roledb)){
                logger.info("删除（无效）单条截图数据成功");
                model.addAttribute("info","操作成功");
                return "advert/result";
            }else{
                roledb.setState(0);
                if(roleService.update(roledb)){
                    logger.info("删除（无效）单条截图数据成功");
                    model.addAttribute("info","操作成功");
                    return "advert/result";
                }else {
                    logger.error("删除（无效）单条截图数据失败");
                    model.addAttribute("info","操作规则失败");
                    return "advert/result";
                }
            }
        }else{
            logger.error("删除（无效）单条截图数据失败");
            model.addAttribute("info","删除失败");
            return "advert/result";
        }
    }

    public boolean operationRole(Role roledb, Picture picture, Integer modelid){
        if(!ObjectUtils.isEmpty(roledb)){
            return true;
        }else{
            Role role = new Role();
            role.setWebsiteid(picture.getWebsiteid());
            role.setWebsiteurl(picture.getWebsiteurl());
            role.setModelid(modelid);
            role.setModelname(picture.getModelname());
            role.setRoletitle(picture.getTitle());
            role.setState(2);
            if(roleService.insert(role)){
                return true;
            }{
                return false;
            }
        }
    }


    /**
     * 修改单条数据
     */
    @RequestMapping(value = "/updatepicture",method = RequestMethod.POST)
    public String updatepicture(Model model,@RequestParam("pictreid")Integer pictreid,@RequestParam("modelid")Integer modelid) {
        Picture picture = pictureService.queryById(pictreid);
        Brand brand = modelService.queryById(modelid);
        Role roledb = roleService.querytitle(picture.getTitle());
        logger.info("updatepicture修改单条截图数据"+pictreid);
        //如果原来这个截图的车型是未归类，那么代表这个车需要添加规则
        if (picture.getModelname().equals("未归类")|| StringUtils.isEmpty(picture.getModelname())) {
            //查询规则里有没有这条
            if (modelid == 1) {
                //传的值和以前一样，返回原接口
                return "redirect:/picture/pictureedit?pictreid=" + pictreid;
            } else {
                if(changeScreenshot(picture,brand,roledb,modelid,false)){
                    logger.info("修改单条截图数据成功");
                    model.addAttribute("info", "操作成功");
                    return "advert/result";
                }else {
                    logger.error("修改单条截图数据失败");
                    model.addAttribute("info", "操作失败");
                    return "advert/result";
                }
            }
        }else{
            if (modelid == 1) {
                if(changeScreenshot(picture,brand,roledb,modelid,true)){
                    logger.info("修改单条截图数据成功");
                    model.addAttribute("info", "操作成功");
                    return "advert/result";
                }else {
                    logger.error("修改单条截图数据失败");
                    model.addAttribute("info", "操作失败");
                    return "advert/result";
                }
            } else {
                if(changeScreenshot(picture,brand,roledb,modelid,false)){
                    logger.info("修改单条截图数据成功");
                    model.addAttribute("info", "操作成功");
                    return "advert/result";
                }else {
                    logger.error("修改单条截图数据失败");
                    model.addAttribute("info", "操作失败");
                    return "advert/result";
                }
            }
        }

    }

    @Transactional
    public boolean changeScreenshot(Picture picture, Brand brand, Role roledb, Integer modelid, boolean bl){
        if(bl){
            //失效规则并失效此截图
            picture.setState(0);
            if (pictureService.update(picture)) {
                if (!ObjectUtils.isEmpty(roledb)) {
                    roledb.setState(0);
                    if(roleService.update(roledb)){
                        return true;
                    }
                }
            }
            return false;
        }else{
            boolean isNew = false;
            if (ObjectUtils.isEmpty(roledb)) {
                //加一条规则，且变更此项为正常
                Role newrole = new Role();
                newrole.setModelid(modelid);
                newrole.setModelname(brand.getModelname());
                newrole.setRoletitle(picture.getTitle());
                newrole.setWebsiteid(picture.getWebsiteid());
                newrole.setWebsiteurl(picture.getArticleurl());
                newrole.setState(2);

                if (roleService.insert(newrole)) {
                    isNew = true;
                }
            } else {
                //有这条规则，启用它
                roledb.setState(1);
                if (roleService.update(roledb)) {
                    isNew = true;
                }
            }
            //规则添加后修改图片里的车型和启用此图片
            picture.setModelname(brand.getModelname());
            picture.setState(1);
            if (pictureService.update(picture)) {
                if (isNew) {
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }



    //自己添加一条截图数据
    @RequestMapping(value = "/toinsertpicture",method = RequestMethod.GET)
    public String toinsertpicture(Model model){
        List<Brand> brandList = modelService.queryAotomatic(1);
        List<Website> websiteList = websiteService.queryAotomatic(1);
        for(Brand brand:brandList){
            System.out.println(brand.getModelname());
        }
        for(Website website:websiteList){
            System.out.println(website.getWebsitename());
        }
        model.addAttribute("brandList", brandList);
        model.addAttribute("websiteList", websiteList);
        return "advert/picturinsert";
    }


    @RequestMapping(value = "/insterpicture",method = RequestMethod.POST)
    public String insterpicture(Integer websiteid, String level, Integer modelid, String title,
                                String articleurl, String pictreurl, String date, String time, Model model){
        if(StringUtils.isEmpty(websiteid)||StringUtils.isEmpty(level)||StringUtils.isEmpty(modelid)||
                StringUtils.isEmpty(title)||StringUtils.isEmpty(articleurl)||StringUtils.isEmpty(pictreurl)||
                StringUtils.isEmpty(date)||StringUtils.isEmpty(time)){
            model.addAttribute("info", "请填写所有必要参数");
            return "advert/result";
        }
        logger.info("insterpicture添加单条截图数据");
        String datetime = date+" "+time;
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date createtime = null;
        try {
            createtime = format1.parse(datetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Picture picture = new Picture();
        picture.setLevel(level);
        picture.setTitle(title);
        picture.setArticleurl(roleController.HandleString(articleurl));
        picture.setPictreurl(pictreurl);
        picture.setCreatetime(createtime);
        Website website = websiteService.queryById(websiteid);
        Brand brand = modelService.queryById(modelid);
        picture.setWebsiteid(websiteid );
        picture.setWebsiteurl(website.getWebsiteurl());
        picture.setWebsitename(website.getWebsitename());
        picture.setModelname(brand.getModelname());
        if(pictureService.insert(picture)){
            logger.info("添加单条截图数据成功");
            model.addAttribute("info", "操作成功");
            return "advert/result";
        }else{
            logger.error("添加单条截图数据失败");
            model.addAttribute("info", "操作失败");
            return "advert/result";
        }
    }
}