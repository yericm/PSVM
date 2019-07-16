package com.bywin.io.chapater2;

import java.io.*;

/**
 * 总结：
 *
 * 字节--->字符 ： 看不懂的--->看的懂的。  需要读。输入流。 InputStreamReader
 *
 * 字符--->字节 ： 看的懂的--->看不懂的。  需要写。输出流。 OutputStreamWriter
 *
 * 因为outputStreamWriter中接收的类型是OutputStream，所以只要是字节输出流都可以使用字符输出流操作。
 * 而InputStreamReader中接收的类型是InputStream。只要是字节输入流，都可以使用字符输入流操作。
 * created by yeric on 2019/7/16
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) throws Exception {
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\yerik\\Desktop\\test.txt", true));
//        osw.write("one di低");
//        osw.close();
        File file = new File("C:\\Users\\yerik\\Desktop\\test.txt");
        FileOutputStream fos = new FileOutputStream(file, true);
        FileInputStream fis = new FileInputStream(file);
//        fos.write("1a嗲".getBytes());
//        fos.close();
        OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK");
        osw.write("one t什么");
        osw.close();
        InputStreamReader isr = new InputStreamReader(fis, "GBK");
        int len = -1;
        while ((len = isr.read()) != -1) {
            System.out.print((char) len);
        }
    }
}
