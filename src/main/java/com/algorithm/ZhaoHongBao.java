package com.algorithm;

import java.util.Scanner;

/**
 * Created by Eric on 2016/4/11.
 */

/**
 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。
 写出具体算法思路和代码实现，要求算法尽可能高效。
 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 若没有金额超过总数的一半，返回0。
 测试样例：
 [1,2,3,2,2],5

 返回：2
 */
public class ZhaoHongBao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String inputString = sc.nextLine();
            String giftString = inputString.substring(1,inputString.length() - 3);
            String[] gifts_num_string = giftString.split(",");
            int[] gifts = new int[gifts_num_string.length];
            for (int i = 0;i < gifts.length;i ++)
                gifts[i] = Integer.parseInt(gifts_num_string[i]);
            System.out.println(new ZhaoHongBao().getValue(gifts,gifts.length));
        }
    }

    public int getValue(int[] gifts, int n) {
        int gift = -1;
        for(int i = 0;i < n;i ++) {
            boolean flag = false;
            int count = 0;
            for (int j = 0; j < i; j ++)
                if (gifts[j] == gifts[i]) {
                    flag = true;
                    break;
                }
            if (flag == true)
                continue;
            for (int k = i; k < n; k ++)
                if (gifts[k] == gifts[i]) {
                    count ++;
                }
            if (count > n / 2)
                gift = gifts[i];
        }
        if (gift != -1)
            return gift;
        else return 0;
    }
}
