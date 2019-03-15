package com.algorithm;

/**
 * 插入代码实现
 * @author xianyu
 * @CreatTime 下午8:16:11
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] sort ={3,2,1,4,6,5,8,9,10,7} ;
        System.out.println("排序前：");
        print(sort);
        insertSort(sort);
        System.out.println("\n排序后：");
        print(sort);
    }


    /**
     * 直接插入算法排序
     * @param a
     */
    public static void insertSort(int[] a){
        //从下标为1开始比较，知道数组的末尾
        for (int i = 1; i < a.length; i++) {
            int j;
            //将要比较的元素，拿出待比较过后再插入数组
            int tmp = a[i];
            //一次与前一元素比较，如果前一元素比要插入的元素大，则互换位置
            for (j = i-1; j >=0&&a[j]>tmp; j--) {
                a[j+1] = a[j];
            }
            //将比较的元素插入
            a[j+1] = tmp;
        }
    }

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}