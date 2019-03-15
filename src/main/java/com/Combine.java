package com;

public class Combine {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        solve(a, 8);
    }
    public static void solve(int[] a,int k){
        if (!haveAnswer(a, a.length, k)) {
            System.out.println("没有解");
        }
    }
    //前n个数中是否有和为K的解
    public static boolean haveAnswer(int[] a,int n,int k){
        if (k==0) {//k已经被凑齐
            return true;
        }
        if (n==1) {//计算到第一个元素时
            if (a[0]==k) {
                return true;
            } else{
                return false;
            }
        }
        boolean b=haveAnswer(a, n-1, k-a[n-1]);
        if (b) {//这个解中包含a[n-1]
            System.out.println(a[n-1]);
            return true;
        } else {//解中不包含a[n-1]，继续计算前面的数组中是否有解
            return haveAnswer(a, n-1, k);
        }
    }
}
