package com.example.xuerun.advert.util;

import com.example.xuerun.advert.entity.Picture;
import com.example.xuerun.advert.entity.Position;
import com.example.xuerun.advert.entity.Reptile;
import com.example.xuerun.advert.entity.Website;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AutomaticOpenChrome {

    public List<Picture> OpenChrome(Website website, List<Position> positionList, List<Reptile> reptileList, String saveaddress){

        //新增一个预操作对象
        ChromeOptions options =new ChromeOptions();
        //取消 chrome正受到自动测试软件的控制的信息栏
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //options.addArguments("disable-infobars");
        //指定浏览器驱动chromedriver存放地址
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\10591\\Desktop\\chromedriver.exe");
        //初始化浏览器名为driver
        WebDriver driver=new ChromeDriver(options);
        //窗口最大化
        driver.manage().window().maximize();
        //鼠标悬浮
        Actions action = new Actions(driver);
        //通过定位将页面滚动条拖到位置
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //打开网址
        String url = website.getWebsiteurl();
        if(!StringUtils.isEmpty(url)){
            driver.get(url);
        }else{
            System.out.println("网址为空");
        }

        List<Picture> pictureList = new ArrayList<>();
        //循环坐标截图
        for(Position position : positionList){
            AotomaticScreenshot aotomaticScreenshot = new AotomaticScreenshot();
            //定位到固定位置
            WebElement search_text = driver.findElement(By.xpath(position.getRegion()));
            //移动到元素element对象的“底端”与当前窗口的“底部”对齐
            js.executeScript("arguments[0].scrollIntoView();", search_text);
            //鼠标悬浮到此位置（主要是针对滚屏，滚动图片之类的）
            action.moveToElement(driver.findElement(By.xpath(position.getScrollarea()))).perform();
            //截图操作
            String screenshoturl = null;
            try {
                //设置文件夹以及图片名
                Date dt=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
                String data=sdf.format(dt);
                String rd=sdf1.format(dt)+".png";
                Thread.sleep(2000);
                aotomaticScreenshot.Screenshot(saveaddress,data,rd);
                screenshoturl = saveaddress+'\\'+data+"\\"+rd;
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<Picture> pList = new ArrayList<>();
            List<Picture> pt = new ArrayList<>();
            //循环坐标获取页面的<a>标签的内容，
            for (Reptile reptile:reptileList) {
                if(reptile.getLocationid()==position.getLocationid()){
                    String html = driver.findElement(By.xpath(reptile.getDivtitle())).getAttribute("innerHTML");
                    //System.out.println("xxxxxxxxxxxxxxxx"+html);
                    pt = Analysis(html,website,screenshoturl,position.getLevel());
                    if(!ObjectUtils.isEmpty(pt)){
                        for(Picture picture:pt){
                            pList.add(picture);
                        }
                    }
                    continue;
                }
                pt=null;
            }
            for(Picture picture:pList){
                pictureList.add(picture);
            }
        }
        //关闭并退出浏览器
        driver.quit ();
        return pictureList;
    }
    


    public List<Picture> Analysis(String html,Website website,String screenshoturl,String level){
        List<Picture> pictureList = new ArrayList<>();
        List<String> list = AnalysisRegEx(html,"<a[^>]*?href=[\"\"'](?<url>[^\"\"']*?)[\"\"'][^>]*?>(?<text>[\\w\\W]*?)</a>");
        String url = website.getWebsiteurl();
        int websiteid = website.getWebsiteid();
        String websitename = website.getWebsitename();
        //循环坐标获取页面的<a>标签的内容，
        for (String str:list) {
            //System.out.println(str);
            Picture picture = new Picture();
            picture.setWebsiteid(websiteid);
            picture.setWebsitename(websitename);
            picture.setWebsiteurl(url);
            picture.setArticleurl(AnalysisRegEx(str,"http([^\"]*)").get(0));
            String title = HandleString(AnalysisRegEx(str,">[^<]*</").get(0));
            picture.setTitle(title);
            System.out.println(str+title);
            picture.setPictreurl(screenshoturl);
            picture.setLevel(level);
            pictureList.add(picture);
        }
        return pictureList;
    }

    public List<String> AnalysisRegEx(String str,String reg){
        Pattern patten = Pattern.compile(reg);//编译正则表达式
        Matcher matcher = patten.matcher(str);// 指定要匹配的字符串
        List<String> matchStrs = new ArrayList<>();
        while (matcher.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchStrs.add(matcher.group());//获取当前匹配的值
        }
        return matchStrs;
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
