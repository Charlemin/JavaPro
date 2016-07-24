package com.algorithm;

import java.util.Scanner;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class MoveCapitalLetter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(moveCapitalLetter(str));
        }
    }

    //将大写字母移到字符串后面，不改变相对顺序
    public static String moveCapitalLetter(String str){
        int length = str.length();
        int j;
        char[] array = str.toCharArray();
        for(int i = length - 1;i > 0;i --) {
            if (Character.isLowerCase(array[i])) {
                j = i;
                while (Character.isLowerCase(array[j]) && j >= 1)
                    j--;
                if (j == 0 && Character.isLowerCase(array[j]))
                    break;
                if (Character.isUpperCase(array[j])) {
                    char temp = array[j];
                    for (int k = j; k < i; k++) {
                        array[k] = array[k + 1];
                    }
                    array[i] = temp;
                }
            }
        }
        return String.valueOf(array);
    }
}
