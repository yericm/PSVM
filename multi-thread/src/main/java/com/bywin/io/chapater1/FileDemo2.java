package com.bywin.io.chapater1;

import java.io.File;

/**
 * 递归 获取目录下所有文件/文件夹
 * created by yeric on 2019/7/10
 */
public class FileDemo2 {
    public static void main(String[] args) {
        recursiveFiles("F:\\电子书");
    }
    private static void recursiveFiles(String path){

        // 创建 File对象
        File file = new File(path);

        // 取 文件/文件夹
        File files[] = file.listFiles();

        // 对象为空 直接返回
        if(files == null){
            return;
        }

        // 目录下文件
        if(files.length == 0){
            System.out.println(path + "该文件夹下没有文件");
        }

        // 存在文件 遍历 判断
        for (File f : files) {

            // 判断是否为 文件夹
            if(f.isDirectory()){

                System.out.print("文件夹: ");
                System.out.println(f.getAbsolutePath());

                // 为 文件夹继续遍历
                recursiveFiles(f.getAbsolutePath());


                // 判断是否为 文件
            } else if(f.isFile()){

                System.out.print("文件: ");
                System.out.println(f.getAbsolutePath());

            } else {
                System.out.print("未知错误文件");
            }

        }

    }
}
