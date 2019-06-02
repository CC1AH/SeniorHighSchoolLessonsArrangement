package com.example.myapplication.Settings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * 文件处理 该程序解决了文件的模块化输入 输出 复制
 *
 *
 */
public class FileDealing extends ArrayList<String> {
    private static final long serialVersionUID = 1L;

    // 读取文件
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();
    }

    // 往文件写入
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    // 构造器1
    public FileDealing(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    // 构造器2
    public FileDealing(String fileName) {
        this(fileName, "\n");// 以换行号切分
    }

    // 复制写入到文件
    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try {

                for (String item : this) {
                    out.print(item);
                }
            } finally {
                out.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]){
        //it is a program for testing
    }
}

