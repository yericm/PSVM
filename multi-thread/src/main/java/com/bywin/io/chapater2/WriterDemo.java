package com.bywin.io.chapater2;

import java.io.*;

/**
 * 文件复制
 * created by yeric on 2019/7/15
 */
public class WriterDemo {
    public static void main(String[] args) throws IOException {
        File wfile = new File("C:\\Users\\yerik\\Desktop\\writer.txt");
        File rfile = new File("C:\\Users\\yerik\\Desktop\\a.txt");
        FileWriter fw = new FileWriter(wfile);
        FileReader fr = new FileReader(rfile);
        char[] buff = new char[1024];
        int len = -1;
        while ((len = fr.read(buff)) != -1) {
            fw.write(new String(buff, 0, len));
        }
        fw.close();
        fr.close();
    }
}
