package com.plus;

/**
 * Created by Eric on 2016/3/17.
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderTest {

    public static void main(String[] args)throws Exception{
        //�ļ�����·���ĳ����Լ����ļ�·��
        FileReader fr=new FileReader("E:\\count.txt");
        //���Ի��ɹ���Ŀ¼�µ������ı��ļ�
        BufferedReader br=new BufferedReader(fr);
        while(br.readLine()!=null){
            String s=br.readLine();
            System.out.println(s);
        }
        br.close();
    }

}