package com.algorithm;

import java.util.Scanner;

/**
 * Created by zhamin on 2016/7/20 0020.
 */
public class AbsNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = Integer.parseInt(sc.nextLine());
            int[] array = new int[num];
            for(int i = 0;i< num;i++)
                array[i] = sc.nextInt();
            System.out.println(getMinAbs(array));
            System.out.println(getMaxAbs(array));
        }

    }

    public static int getMinAbs(int[] array){
        int num = 0;
        int length = array.length;
        int min = Math.abs(array[0] - array[1]);
        for (int i = 0;i < length - 1;i++)
        {
            if(Math.abs(array[i] - array[i+1]) < min)
                min = Math.abs(array[i] - array[i+1]);
        }
        for (int i = 0;i < length - 1;i++)
        {
            if(Math.abs(array[i] - array[i+1]) == min)
                num ++;
        }

        return num;
    }

    public static int getMaxAbs(int[] array){
        int num = 0;
        int length = array.length;
        int max = Math.abs(array[0] - array[1]);
        for (int i = 0;i < length - 1;i++)
        {
            if(Math.abs(array[i] - array[i+1]) > max)
                max = Math.abs(array[i] - array[i+1]);
        }

        for (int i = 0;i < length - 1;i++)
        {
            if(Math.abs(array[i] - array[i+1]) == max)
                num ++;
        }

        return num;
    }
}
