package com.plus;

/**
 * Created by Administrator on 2016/5/5.
 */
public class QuickSort {

    public static void main(String[] args) {

        int[] array={45,89,2,64,78,99,53,1,46,6,8};
        int low=0;
        int high=array.length-1;
        quickSort(array,low,high);
        for(int i=0;i<=high;i++)
            System.out.println(array[i]);

    }

    //快排递归实现
    public static void quickSort(int array[],int low,int high){

        int i,j;
        int index;
        if(low>=high)
            return;
        i=low;
        j=high;
        index=array[i];
        while (i<j){
            while (i<j&&array[j]>=index)
                j--;
            if(i<j)
                array[i++]=array[j];
            while (i<j&&array[i]<index)
                i++;
            if(i<j)
                array[j--]=array[i];
        }
        array[i]=index;
        quickSort(array,low,i-1);
        quickSort(array,i+1,high);

    }
}
