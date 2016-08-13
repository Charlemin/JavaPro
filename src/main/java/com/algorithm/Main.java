package com.algorithm;

import java.util.Scanner;

/**
 * Created by Eric on 2016/7/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            while (n % m != 0){
                int temp = n % m;
                n = m;
                m = temp;
            }
            System.out.println(m);
        }
    }
}
