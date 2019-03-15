package com;

import java.util.Arrays;

public class SearchForARange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,9};
        System.out.println(Arrays.toString(searchForARange(nums, 8)));
    }

    private static int[] searchForARange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }

        if (nums[right] != target) return res;
        res[0] = right;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid + 1;
            else right= mid;
        }
        res[1] = left - 1;
        return res;
    }
}
