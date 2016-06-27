package com.plus;

/**
 * Created by Administrator on 2016/5/5.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array={45,89,2,64,78,99,53,1,46,6,8};
        insertSort(array);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }

    public static void insertSort(int[] a){

           if(a==null)
               return;
        for(int i=1;i<a.length;i++){
            int temp=a[i],j=i;
            if(a[j-1]>temp){
                while (j>=1&&a[j-1]>temp) {
                    a[j] = a[j - 1];
                    j--;
                }
            }
            a[j]=temp;
        }
    }
}
