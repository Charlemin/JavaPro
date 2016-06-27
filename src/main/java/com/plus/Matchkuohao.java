package com.plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Eric on 2016/3/17.
 */
public class Matchkuohao {

    public static  boolean match(String expression){

        int a=0,b=0;
        char[] expression_char=expression.toCharArray();
        for(int i=0;i<expression_char.length;i++){
            if(expression_char[i]=='(')
                a++;
            else
                b++;
        }
        return a==b?true:false;
    }

    public static void main(String[] args){


        BufferedReader bf;
        String express;
        System.out.println("请输入表达式");
        bf=new BufferedReader(new InputStreamReader(System.in));
       try {
           express=bf.readLine();
           System.out.println(match(express));
       }
       catch(IOException e){
           e.printStackTrace();
       }
    }
}
