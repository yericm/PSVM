package com.bywin.io.chapater2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * created by yeric on 2019/7/10
 */
public class FileOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        //1.创建一个字节输出流，关联磁盘磁盘文件，如果文件存在直接使用，如果不存在，则自动创建，然后将数据写入
        FileOutputStream fos = new FileOutputStream("D:1/1.txt", true);

        //2.写入内容：
        //方式①：写入一个字节        void write(int b) ： 将指定字节写入此文件输出流。
        fos.write(97);//写入的是：a

        //方式②：写入文字              void write(byte[] b) ：将 b.length 个字节从指定 byte 数组写入此文件输出流中。
        fos.write("这是即将写入的文字2323".getBytes());

        //方式③：写入指定字节          void write(byte[] b, int off, int len) ：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
        byte[] b = new byte[] {97,98,99,65,66,67};
        fos.write(b, 0, 4);//写入从b数组起始位置为0 开始 的4个字节    (在这里写入的即是：abcA)

        //3.关闭流
        fos.close();
    }
}
