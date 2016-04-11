package com.plus;
import  java.util.Scanner;
import java.lang.Math;
/**
 * Created by Eric on 2016/3/28.
 */
public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[2];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = scanner.nextLine();
        }
        int length = strings.length;
        int a[][] = new int[length][2];
        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            String[] strings1 = strings[i].split(" ");
            System.out.println(strings1[1]);
           for (int k = 0; k < length; k++){
              a[k][0] = Integer.parseInt(strings1[0]);
              a[k][1] = Integer.parseInt(strings1[1]);
    }
        }
        for (int i = 0; i < length; i++) {
            for(b[i]=0;b[i]<a[i][0];b[i]++)
                if(Math.abs(b[i]-a[i][0])<=Math.abs(a[i][1]-a[i][0]))
                    System.out.println(b[i]);
        }
    }
}