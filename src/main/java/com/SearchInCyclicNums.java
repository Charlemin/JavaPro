package com;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class SearchInCyclicNums {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9,10,1,2,3};
        System.out.println(searchInCyclicNums(nums, 8));
    }

    private static int searchInCyclicNums(int[] nums, int k) {
        int location;
        if (null == nums || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        int temp = nums[0];
        while (left <= right) {
            location = (left + right) / 2;
            if (nums[location] == k)
                return location;
            if (nums[location] >= temp) {
                if (k >= temp && k < nums[location])
                    right = location -1;
                else left = location + 1;
            } else {
                if (k > nums[location] && k <= nums[right])
                    left = location + 1;
                else right = location -1;
            }
        }
       return -1;
    }
}
