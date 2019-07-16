package com.bywin.io.chapater2;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * created by yeric on 2019/7/15
 */
public class FileWriterDemo1 {
    public static void main(String[] args) throws IOException {
//       write("C:\\Users\\yerik\\Desktop\\FileWriterDemo1.txt");
//        read("C:\\Users\\yerik\\Desktop\\FileWriterDemo1.txt");
        readArray("C:\\Users\\yerik\\Desktop\\FileWriterDemo1.txt");
    }

    /**
     * 写文件
     * @param path
     * @throws IOException
     */
    public  static void write (String path) throws IOException {
        //创建输出流对象"
        FileWriter fw = new FileWriter(path);

        //调用输出流对象写数据的方法
        //写一个字符串数据
        fw.write("HelloWorld！");
        //数据没有写到文件里，只写到缓冲区
        fw.flush();


        //flush刷新缓冲区，后面可以继续写数据
        fw.write("java");
        fw.flush();

        //释放资源
        //通知系统释放和该文件相关的资源
        //close()，刷新缓冲区，通知系统释放资源。流对象不可以再使用。后面无法继续写数据。
        fw.close();
    }

    /**
     * 读文件
     * @param path
     */
    public static void read (String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        int len = 0;
        while ((len = fileReader.read()) != -1) {
            System.out.print((char) len);
        }
        fileReader.close();
    }

    public static void readArray (String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        char[] buf = new char[1024];
        int len = -1;
        while ((len = fileReader.read(buf)) != -1) {
            System.out.print((new String(buf, 0, len)));
        }
    }
}
