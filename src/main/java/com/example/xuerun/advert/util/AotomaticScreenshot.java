package com.example.xuerun.advert.util;

import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

// 截取计算机当前屏幕显示的画面
// 无需引入其他jar包，Java自带组件即可完成该功能
public class AotomaticScreenshot{

    //截图 并保存
    public BufferedImage captureScreen(String fileName,String folder)throws Exception{
        //获得屏幕大小并创建一个Rectangle(区域)
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        //创建包含从屏幕中读取的像素的图像
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //截图的保存路径
        File screenFile = new File(fileName);
        if(!screenFile.getParentFile().exists()) {
            screenFile.getParentFile().mkdir();
        }
        //判断文件是否存在，不存在就创建文件
        if(!screenFile.exists()&& !screenFile .isDirectory()) {
            screenFile.mkdir();
        }
        File f = new File(screenFile, folder);
        //决定了f为文件，将图像1以.png格式写入文件f
        ImageIO.write(image, "png", f);
        return image;
    }
    public void Screenshot(String src,String data,String rd) throws Exception {
        //设置默认地址
        if(StringUtils.isEmpty(src)){
            src = "D:\\ScreenShot\\";
        }
        /*//设置文件夹以及图片名
        Date dt=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMddHHmmss");
        String data=sdf.format(dt);
        String rd=sdf1.format(dt);*/
        this.captureScreen(src+"/"  +data,rd);
    }

    public static void main(String[] args) {
        AotomaticScreenshot aotomaticOpenChrome = new AotomaticScreenshot();
        /*try {
            aotomaticOpenChrome.Screenshot("D:\\ScreenShot\\");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
