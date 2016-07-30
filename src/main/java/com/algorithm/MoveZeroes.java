package com.algorithm;

import java.util.logging.Level;

/**
 * Created by Eric on 2016/7/8.
 */
public class MoveZeroes {

    public static void main(String[] args) {

        int[] array = {1,0,2,3};
        moveZeroes(array);
        for(int i = 0;i< array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println(containsDuplicate(array));
    }

    public static void moveZeroes(int[] nums) {
        for(int i = 0,j = 0;i < nums.length;i ++)
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
    }

    public int guess(int num){
        return 0;
    }

    //折半查找要找的数
    public int guessNumber(int n) {
        if (guess(n) == 0) return n;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2, t = guess(mid);
            if (t == 0) return mid;
            else if (t == 1) left = mid;
            else right = mid;
        }
        return left;
    }

    //判断一个数是不是2的指数
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    //判断数组中是不是存在重复的数
    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        boolean flag = false,tag= false;
        int count;
        for(int i=0;i<length;i++) {
            count = 0;
            flag=false;
            for(int j=0;j<i;j++)
                if(nums[i]==nums[j]) {
                    flag = true;
                    break;
                }
            if(flag==true)
                continue;
            for(int l=i;l<length;l++)
                if(nums[l]==nums[i])
                    count++;
            if(count > 1) {
                tag = true;
                break;
            }
        }
        return tag;
    }
}
