package com.bywin.io.chapater2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * created by yeric on 2019/7/15
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\yerik\\Desktop\\BufferedWriterDemo.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("stringllsdsd", 1, 5);
        bufferedWriter.newLine();
        bufferedWriter.write("abcdeiglsong", 3, 5);
        bufferedWriter.close();
        fileWriter.close();
    }
}
