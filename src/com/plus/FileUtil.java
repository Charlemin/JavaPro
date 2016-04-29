package com.plus;

/**
 * Created by Administrator on 2016/3/16.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    public void readLinesFromFile(String filename) {

        BufferedReader br = null;

        try {
//构造BufferedReader对象
            br = new BufferedReader(new FileReader(filename));

            String line = null;
            while ((line = br.readLine()) != null) {

//将文本打印到控制台
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

//关闭BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        FileUtil util = new FileUtil();
        //util.readLinesFromFile("F:\\manlert\\file.txt");
        util.readLinesFromFile("C:\\Users\\Administrator\\Desktop\\file.txt");

    }
}