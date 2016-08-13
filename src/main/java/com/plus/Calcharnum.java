package com.plus;

import java.util.Scanner;

/**
 * Created by Eric on 2016/3/29.
 */
public class Calcharnum {
    public static void main(String[] args){

        boolean flag=false;
        String input;
        Scanner scanner=new Scanner(System.in);
        input=scanner.nextLine();
        int length=input.length();
        for(int i=0;i<length;i++){
            int count=0;
            for(int j=0;j<i;j++){
                flag=false;
                if(input.charAt(i)==input.charAt(j)){
                    flag=true;
                    break;
                }
            }
            if(flag==true)
               continue;
            for(int j=i;j<length;j++)
                if (input.charAt(j) == input.charAt(i))
                    count++;
                System.out.println(input.charAt(i) + ":" + count);

        }
    }
}
