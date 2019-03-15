package com.algorithm;

public class ReverseInt {

    public static void main(String[] args) {
        //System.out.println(reverse(2147483647));
        System.out.println(reverseInteger(1234567897));
    }


    public static int reverse(int x) {
        char[] arrs = Integer.toString(x).toCharArray();
        char temp=0;
        if(x>0){
            int z=0,y=arrs.length-1;
            while(z < arrs.length/2){
                temp = arrs[z];
                arrs[z] = arrs[y];
                arrs[y] = temp;
                z++;
                y--;
            }
        }
        else{
            int z=1,y=arrs.length-1;
            while(z < (arrs.length-1)/2){
                temp = arrs[z];
                arrs[z] = arrs[y];
                arrs[y] = temp;
                z++;
                y--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arrs.length;i++){
            sb.append(arrs[i]);
        }
        int res = Integer.parseInt(sb.toString());
        if(res > Integer.MAX_VALUE){
            return 0;
        }
        return res;
    }

    public static int reverseInteger(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            x = x / 10; //不断取前几位
            if (temp / 10 != res) {
                res = 0;
                break;
            }
            res = temp;
        }
        return res;
    }
}
