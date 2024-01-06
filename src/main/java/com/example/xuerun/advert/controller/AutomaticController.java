package com.example.xuerun.advert.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.xuerun.advert.entity.*;
import com.example.xuerun.advert.entity.vo.Excle;
import com.example.xuerun.advert.service.*;
import com.example.xuerun.advert.util.AutomaticOpenChrome;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller("controller")
public class AutomaticController {

    static Logger logger = Logger.getRootLogger();
    @Resource
    private PositionService positionService;
    @Resource
    private ModelService modelService;
    @Resource
    private PictureService pictureService;
    @Resource
    private ReptileService reptileService;
    @Resource
    private RoleService roleService;
    @Resource
    private WebsiteService websiteService;

    AutomaticOpenChrome automaticOpenChrome = new AutomaticOpenChrome();

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/screenshot",method = RequestMethod.GET)
    public String screenshot(Model model){
       if(screenshotol()){
           model.addAttribute("info","成功");
           return "advert/result";
       }else{
           model.addAttribute("info","截图操作出错");
           return "advert/result";
       }
    }

    public boolean screenshotol(){
        logger.info(outdata()+"截图开始");
        try{
            AutomaticScreenshot(1);
        }catch (Exception e){
            logger.error(outdata()+"截图出错");
            return false;
        }
        logger.info(outdata()+"截图完成");
        return true;
    }

    /**
     * 输出excle
     */
    @RequestMapping(value = "/pictureExcle",method = RequestMethod.GET)
    public String pictureExcle(Model model){
        if(StringUtils.isEmpty(pictureExcleol())){
            model.addAttribute("info","执行出错");
            return "advert/result";
        }
        model.addAttribute("info",pictureExcleol());
        return "advert/result";
    }

    public String pictureExcleol(){
        logger.info(outdata()+"excle输出开始");
        List<Picture> pictureList = pictureService.queryAllPicture(1);
        simpleWrite(data(pictureList));
        logger.info(outdata()+"excle输出完成");
        return "成功";
    }

    private List<Excle> data(List<Picture> pictureList) {
        //设置文件夹以及图片名
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String data=sdf.format(dt);
        //截图的保存路径
        File screenFile = new File("D:\\截图\\"+data);
        String url = "D:\\截图\\"+data+"\\";
        if(!screenFile.getParentFile().exists()) {
            screenFile.getParentFile().mkdir();
        }
        //判断文件是否存在，不存在就创建文件
        if(!screenFile.exists()&& !screenFile .isDirectory()) {
            screenFile.mkdir();
        }

        List<Excle> list = new ArrayList<Excle>();
        for (Picture picture:pictureList) {
            Excle excle = new Excle();
            excle.setArticleurl(picture.getArticleurl());
            excle.setCreatetime(picture.getCreatetime());
            excle.setLevel(picture.getLevel());
            excle.setModelname(picture.getModelname());
            excle.setTitle(picture.getTitle());
            excle.setWebsitename(picture.getWebsitename());
            try {
                copy(picture.getPictreurl(),url+picture.getTitle()+".png");
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(excle);
        }
        return list;
    }

    public void copy(String url1, String url2) throws Exception {
        FileInputStream in = new FileInputStream(new File(url1));
        FileOutputStream out = new FileOutputStream(new File(url2));
        byte[] buff = new byte[512];
        int n = 0;
        System.out.println("复制文件：" + "\n" + "源路径：" + url1 + "\n" + "目标路径："
                + url2);
        while ((n = in.read(buff)) != -1) {
            out.write(buff, 0, n);
        }
        out.flush();
        in.close();
        out.close();
        logger.info(url2+"复制完成");
    }

    public void simpleWrite(List<Excle> excleList) {

        String  fileName = "导出模板" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = EasyExcel.write(fileName, Excle.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(excleList, writeSheet);
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    public void AutomaticScreenshot(Integer setupid){

        /*查出规则,设置,车型，网站*/
        List<Role> roleList = roleService.queryAotomatic(1);
        List<Brand> brandList = modelService.queryAotomatic(1);
        List<Website> websiteList = websiteService.queryAotomatic(1);
        /*自动循环打开网址，并截图*/
        for (Website website:websiteList) {

            //获取此页面的定位元素与滚动元素
            List<Position> positionList = positionService.queryWebIdAotomatic(website.getWebsiteid());
             //获取这个网址固定位置的数据
            List<Reptile> reptileList = reptileService.queryWebIdAotomatic(website.getWebsiteid());
            List<Picture> pictureList = automaticOpenChrome.OpenChrome(website, positionList,reptileList,"D:\\ScreenShot");

            for(Picture picture:pictureList){
                picture.setState(2);
                picture.setModelname("未归类");
                for(Role role:roleList){
                    if((picture.getTitle()).indexOf(role.getRoletitle())!=-1){
                        picture.setModelname(role.getModelname());
                        picture.setState(1);
                        break;
                    }
                }
            }
            pictureService.insertBatch(pictureList);
        }
    }

    public String outdata(){
        //设置文件夹以及图片名
        Date dt=new Date();
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmm");
        return sdf1.format(dt);
    }

    //批量失效一周前的截图文件

}
