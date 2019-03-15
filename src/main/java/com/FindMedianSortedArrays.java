package com;

public class FindMedianSortedArrays {

    public static double  findMedianSortedArrays(int[] A,int B[]) {
        int m=A.length;
        int n=B.length;
        if(m>n) {//保证m<n 意思就是B的长度大于等于A的长度
            int[] temp=A;A=B; B=temp;
            int tmp=m;m=n;n=tmp;
        }
        int iMin=0,iMax=m,halfLen=(n+m+1)/2;
        while(iMin<=iMax) {
            int i=(iMin+iMax)/2;
            int j=halfLen-i;
            if(i<iMax&&B[j-1]>A[i]) {
                iMin=iMin+1;
            }
            else if(i>iMin&&A[i-1]>B[j]) {
                iMax=iMax-1;
            }
            else {
                int maxLeft=0;
                if(i==0) {maxLeft=B[j-1];}
                else if(j==0) {maxLeft=A[i-1];}
                else {maxLeft=Math.max(A[i-1], B[j-1]);}
                if((m+n)%2==1) {return maxLeft;}
                int minRight=0;
                if(i==m) {minRight=B[j];
                }else if(j==n) {minRight=A[i];}
                else {minRight=Math.min(B[j], A[i]);}
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]= {2,3,4,5,6};
        double c = findMedianSortedArrays(a,b);
        System.out.println(c);
    }
}
