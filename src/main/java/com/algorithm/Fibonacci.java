package com.algorithm;

/**
 * Created by Eric on 2016/8/10.
 */

import java.util.Scanner;

/**
 Fibonacci数列是这样定义的：
 F[0] = 0
 F[1] = 1
 for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，
 你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 输入描述:
 输入为一个正整数N(1 ≤ N ≤ 1,000,000)

 输出描述:
 输出一个最小的步数变为Fibonacci数"

 输入例子:
 15

 输出例子:
 2
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int i = sc.nextInt();
            int temp_1 = 0;
            int temp_2 = 1;
            int temp = 0;
            while (temp <= i) {
                temp = temp_1 + temp_2;
                temp_1 = temp_2;
                temp_2 = temp;
                }
                int length = Math.min(i - temp_1, temp_2 - i);
                System.out.println(length);
            }
         }
    }

/**
 #include <iostream>
 #include <vector>
 #include <algorithm>
 #include <map>
 #include <math.h>
 using namespace std;

 // 深搜
 void dfs(map<int,int> & mp, map<int,int>::iterator i,int curUseCnt, int & cnt, int curSum, int curPro)
 {
 //cout << "cur sum " << curSum << "\t" << "curPro:" << curPro << endl;
 if (curSum > curPro)
 {
 //cout << "enter the loop " <<curSum <<"\t"<< curPro<< endl;
 //cout << "i first:" << i->first << "curUseCnt: " << curUseCnt<< endl;
 cnt ++;
 //return ;
 }
 if (i == mp.end())
 {
 //cout << "mp end " << endl;
 return;
 }

 for(map<int,int> ::iterator j = (++i);j!=mp.end();j++)
 {
 for(int k = 0; k <= j ->second;k++)
 {
 //cout << "j ->first" << j->first << "\t" << "k:" << k << endl;
 dfs(mp,j,k,cnt,curSum + (k * j->first), curPro * (pow(j->first,k)));
 }

 }


 }

 int main() {
 //out << "Hello, World!" << endl;

 int n;
 while (cin >> n)
 {
 //vector<int> v (n,0);
 map<int,int> mp;
 for(int i=0; i< n;i++)
 {
 int t;
 cin >> t;
 if (mp.find(t) == mp.end())
 {
 mp[t] = 1;
 }
 else
 {
 mp[t] ++;
 }
 }
 int cnt = 0;
 //        dfs(mp,mp.begin(),0,cnt,0,1);
 map<int,int>::iterator i = mp.begin();
 for (int k =0; k <= i->second;k++)
 {

 dfs(mp, i, k, cnt, k * (i->first), pow(i->first, k));
 //cout << "cnt" << cnt << endl;
 }
 //sort(v.begin(),v.end());
 cout << cnt << endl;




 }

 return 0;
 }


 */
