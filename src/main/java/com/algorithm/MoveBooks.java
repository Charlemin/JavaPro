package com.algorithm;

/**
 * Created by Eric on 2016/8/3.
 */

import java.util.Scanner;

/**
 描述:
 有N堆书围成一圈，每堆有M本书。现在想将这些书重新堆成一堆。每次只能将相邻的两堆书合并成一堆，经过N-1次合并最终完成N堆书合并成一堆。
 每次合并会得到一个合并得分，该得分为两堆书的书本个数之和。完成所有合并的总得分为每次合并的得分之和。请问如何最轻松的完成合并任务，
 即合并的总得分最小？

 运行时间限制:	无限制
 内存限制:	无限制
 输入:
 输入若干以一个空格分隔的正整数，第一个数为书的总堆数N，后续的N个数为每堆书的数量M。其中N<=100，M<=50。
 输出:
 输出搬移的最小总得分
 样例输入:
 5 1 2 3 4 5
 样例输出:
 33
 答案提示:
 */
public class MoveBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] books = new int[n];
            for (int i = 0;i < n;i ++)
                books[i] = sc.nextInt();
            System.out.println(minBooks(books));
        }
    }

    public static int maxBook(int[] a)
    {
        int n=a.length;
        int[][] s=new int[a.length][a.length+1];
        for(int j=2;j<=n;j++)
            for(int i=0;i<n;i++)
            {
                s[i][j]=s[i][1]+s[(i+1)%n][j-1]+sum(a,i,j);
                for(int k=2;k<=j-1;k++)
                {
                    int t=(i+k)%n;
                    int temp=s[i][k]+s[t][j-k]+sum(a,i,j);
                    if(s[i][j]<temp)
                    {
                        s[i][j]=temp;
                    }
                }
            }
        int temp=s[0][n];
        for(int i=1;i<n;i++)
        {

            if(s[i][n]>temp)
                temp=s[i][n];
        }
        return temp;
    }
    public static int  minBooks(int[] a)
    {
        int n=a.length;
        int[][] s=new int[a.length][a.length+1];
        for(int j=2;j<=n;j++)
            for(int i=0;i<n;i++)
            {
                s[i][j]=s[i][1]+s[(i+1)%n][j-1]+sum(a,i,j);
                for(int k=2;k<=j-1;k++)
                {
                    int t=(i+k)%n;
                    int temp=s[i][k]+s[t][j-k]+sum(a,i,j);


                    if(s[i][j]>temp)
                    {
                        s[i][j]=temp;
                    }
                }
            }
        int temp=s[0][n];
        for(int i=1;i<n;i++)
        {

            if(s[i][n]<temp)
                temp=s[i][n];
        }
        return temp;

    }
    public static int sum(int[] a,int i,int j)
    {
        int sum=0;
        int length=a.length;

        for(int k=i;k<i+j;k++)
        {
            int t=k;
            if(k>length-1) t=t%length;
            sum+=a[t];
        }
        return sum;
    }
}
