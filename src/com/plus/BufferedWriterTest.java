package com.plus;

import java.io.*;

/**
 * Created by Eric on 2016/3/17.
 */
public class BufferedWriterTest {

    public static void main(String[] args){

        BufferedWriter bufferedWriter = null;
        //String file="dnjfneufreuiwf frgte grwetgtw " ;
        String inputpath="E:\\count.txt";
        String outputpath="E:\\file.txt";
        BufferedReader bufferedReader=null;
        String line="";
        try {
            bufferedReader=new BufferedReader(new FileReader(inputpath));
            bufferedWriter = new BufferedWriter(new FileWriter(outputpath));
            while ((line=bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {

            System.out.println("输出文件成功！");
//            try {
//                if(bufferedWriter!=null)
//                    bufferedWriter.flush();
//                    //bufferedWriter.close();
//            }
//
//            catch (IOException e){
//                e.printStackTrace();
//            }
        }
    }
}
