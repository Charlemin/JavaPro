package com.plus;

/**
 * Created by Eric on 2016/3/30.
 */
public class InsertNum {

    public static void main(String[] args){

        int i,j;
        int a[]={2,3,5,6,7};
        int b[]={1,2,4,6,5,7,8,9};
        int c[]=new int[a.length+b.length];
        for( i=0;i<a.length;i++)
            c[i]=a[i];
        for(i=0,j=a.length;i<b.length;i++,j++)
            c[j]=b[i];
        BubbleSort.Asc_Sort(c);
        for(j=0;j<c.length;j++)
            System.out.print(c[j]+" ");
    }
}
