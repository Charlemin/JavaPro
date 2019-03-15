package com;

import java.util.Arrays;

public class NonRecursivlyQuickSort {

    public static int partion(int[] array,int low,int hign){

        int tmp=array[low];
        while(low<hign){
            while(low<hign&&array[hign]>=tmp){
                --hign;
            }
            if(low>=hign){
                break;
            }else{
                array[low]=array[hign];
            }
            while(low<hign&&array[low]<=tmp){
                ++low;
            }
            if(low>=hign){
                break;
            }else{
                array[hign]=array[low];
            }

        }
        array[low]=tmp;
        return low;

    }
    //快速排序的非递归用栈来做
    public static void quickSort(int[]array){
        int[]stack=new int[array.length];
        int top=0;
        int low=0;
        int hign=array.length-1;
        int par=partion(array,low,hign);
        //入栈
        if(par>low+1){
            stack[top++]=low;
            stack[top++]=par-1;
        }
        if(par<hign-1){
            stack[top++]=par+1;
            stack[top++]=hign;
        }
        //出栈
        while(top>0){
            hign=stack[--top];
            low=stack[--top];
            par=partion(array,low,hign);
            if(par>low+1){
                stack[top++]=low;
                stack[top++]=par-1;
            }
            if(par<hign-1){
                stack[top++]=par+1;
                stack[top++]=hign;

            }

        }
    }

    public static void quickSort(int[] arr, int i, int j) {
        int left = i;
        int right = j;
        int temp = arr[i];
        if (i >= j)
            return;
        while (left != right) {
            while (left < right && arr[right] >= temp)
                right --;
            if (left < right)
                arr[left] = arr[right];
            while (left < right && arr[left] <= temp)
                left ++;
            if (left < right)
                arr[right] = arr[left];
        }
        arr[left] = temp;
        quickSort(arr, i, left - 1);
        quickSort(arr, left + 1, j);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array={20,3,5,0,32,22,11,8,7,9};
        quickSort(array, 0, 9);
        System.out.println(Arrays.toString(array));
    }
}
