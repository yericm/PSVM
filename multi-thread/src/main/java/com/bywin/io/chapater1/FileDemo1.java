package com.bywin.io.chapater1;

import java.io.File;
import java.io.IOException;

/**
 * created by yeric on 2019/7/10
 */
public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\电子书");
        System.out.println(file);
        File file1 = new File("F:\\电子书", "精通Spring MVC 4.pdf");
        System.out.println(file1);
        File file2 = new File(file, "实战Java高并发程序设计（第2版 .pdf)");
        System.out.println(file2);
        File file3 = new File(file, "abc.txt");
        System.out.println(file3);
/*        if (file3.exists()) {
            file3.delete();
            System.out.println("文件已删除");
        }else {
            file3.createNewFile();
            System.out.println("文件已创建");
        }*/
        System.out.println(file2.getName() + ";" + file2.getAbsoluteFile() + ";" + file2.getAbsolutePath() + ";" + file2.isFile() + ";" + file2.isDirectory());
        System.out.println(file.listFiles().length);
        System.out.println(file.list().length);
      /*  File file4 = new File("F:\\A\\B\\C\\d.txt");
        if (!file4.exists()) {
            file4.mkdirs();
        }*/
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(file.length());
        System.out.println(file.getPath());
    }
}
