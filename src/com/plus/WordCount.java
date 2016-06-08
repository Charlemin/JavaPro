package com.plus;

/**
 * Created by Administrator on 2016/6/1.
 */
public class WordCount {


    public static void main(String[] args) {

        System.out.println(wordcount("i am eric"));
    }
    public static int wordcount(String str){

        int count=0;
        int word=0;
        for(int i=0;i<str.length();i++){
            if(String.valueOf(str.charAt(i))=="")
                word=0;
            else if(word==0)
            {
                word=1;
                count++;
            }

        }
        return count;
    }
}
