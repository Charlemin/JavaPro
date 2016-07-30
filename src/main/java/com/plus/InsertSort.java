package com.plus;

/**
 * Created by Administrator on 2016/5/5.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array={45,89,2,64,78,99,53,1,46,6,8};
        insertSort2(array);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }
    //直接插入排序，从小到大排列
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
    //直接插入排序，从大到小排列
    public static void insertSort2(int[] array){
        if(array == null)
            return;
        for (int i = 1;i < array.length;i++){
            int temp = array[i];int j = i;
            if (temp > array[j -1])
                while (j >= 1 && temp > array[j -1]){
                       array[j] = array[j -1];
                       j --;
                }
                array[j] = temp;
        }
    }
}
