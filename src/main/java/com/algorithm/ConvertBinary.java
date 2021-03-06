package com.algorithm;

/**
 * Created by Administrator on 2016/7/20 0020.
 */
public class ConvertBinary {
    public static void main(String[] args) {

        ConvertBinary main = new ConvertBinary();
        System.out.println(main.reverseBinary(11));//二进制表示1011

    }

    //将整数二进制反转后的整数
    public int reverseBinary(int num){
        String temp = "";
        while (num != 0){
            temp += num%2;
            num /= 2;
        }
        int length = temp.length();
        System.out.println(temp);
        int reverseNum = 0;
        for(int i = 0;i < length ;i++){
            int j = Integer.parseInt(String.valueOf(temp.charAt(length - i - 1)));
            double tempNum = j * Math.pow(2,i);
            reverseNum += tempNum;
        }
        return reverseNum;
    }
}
