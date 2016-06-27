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
//����BufferedReader����
            br = new BufferedReader(new FileReader(filename));

            String line = null;
            while ((line = br.readLine()) != null) {

//���ı���ӡ������̨
                System.out.println(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

//�ر�BufferedReader
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