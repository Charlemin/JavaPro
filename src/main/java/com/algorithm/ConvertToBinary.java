package com.algorithm;

/**
 * Created by Eric on 2016/8/3.
 */

import java.util.Scanner;

/**
 描述:
 输入一串整数，将每个整数转换为二进制数，如果倒数第三个Bit是“0”，则输出“0”，如果是“1”，则输出“1”。
 运行时间限制:	10 Sec
 内存限制:	128 MByte
 输入:
 一串整数，长度小于1024，整数以空格隔开
 输出:
 1/0的整数串，空格隔开
 样例输入:
 240 0
 样例输出:
 0 0
 */
public class ConvertToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String inputString = sc.nextLine();
            String[] nums = inputString.split(" ");
            int[] convert_nums = new int[nums.length];
            for (int i = 0;i < nums.length;i ++)
                convert_nums[i] = Integer.parseInt(nums[i]);
            for (int i = 0;i < nums.length;i ++) {
                String binaryString = Integer.toBinaryString(convert_nums[i]);
                if (binaryString.length() < 3)
                    System.out.println(0 + " ");
                else {
                    if (binaryString.charAt(binaryString.length() - 3) == '1')
                        System.out.print(1 + " ");
                    else System.out.print(0 + " ");
                }
            }
        }
    }
}
