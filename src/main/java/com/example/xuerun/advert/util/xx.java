package com.example.xuerun.advert.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class xx {
        public static void main(String[] args) throws Exception {
            String url1 = "D:\\a.txt";// 源文件路径
            String url2 = "D:\\ScreenShot\\r.txt";// 目标路径（复制到E盘，重命名为b.txt）
            copy(url1, url2);
        }

        private static void copy(String url1, String url2) throws Exception {
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
            System.out.println("复制完成");
        }

}
