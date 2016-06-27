package com.plus;

/**
 * Created by Administrator on 2016/5/5.
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array={45,89,2,64,78,99,53,1,46,6,8};
        selectSort(array);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }

    public static void selectSort(int array[]){

        int length=array.length;
        int flag;
        int temp;
        for(int i=0;i<length;i++){
            flag=i;
            temp=array[i];
            for(int j=i;j<length;j++){
                if(temp>array[j]) {
                    temp = array[j];
                    flag=j;
                }
            }
            if(temp!=array[i]) {
                array[flag] = array[i];
                array[i] = temp;
            }
        }

    }
}
