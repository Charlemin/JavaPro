package com.algorithm;

/**
 * Created by Eric on 2016/8/25.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 原来是要到醋溜站台乘坐醋溜快车到醋溜港”，亮亮解出了地图隐藏的秘密，赶紧奔向醋溜站台，但到了之后，亮亮忧桑地发现，
 从醋溜站台到醋溜港沿途的每个车站都有很多美女被他飒爽的英姿所吸引，只要经过车站就会被这些漂亮的女孩搭讪，
 但是现在亮亮一心想要寻找楚楚街而没空去搭理她们，所以亮亮希望在抵达醋溜港的时候被搭讪的次数最少。问亮亮抵达醋溜港最少会被搭讪多少次？

 输入描述:
 第一行包含两个整数N(2<=N<=5000),M(1<=M<=50000)。N表示公有N个汽车站，M表示公有M条公路，起点为1，终点为N。
 第二行包含N个整数(0<=K<=10000)，第i个整数表示在第i站有K个美女想要搭讪亮亮。
 接下来M行，每行包含两个整数P(1<=P<=N),Q(1<=Q<=N),代表P,Q两个站是有班车直达的。

 输出描述:
 一个整数，即亮亮抵达醋溜港最少需要被搭讪的次数。

 输入例子:
 5 5
 0 1 1 3 6
 1 2
 1 4
 2 3
 3 5
 4 5

 输出例子:
 8
 */
public class Traveling {
    private static final int MAX = 1000000;//表示两个站点之间不可达

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int N = scan.nextInt();//共有N个汽车站
            int M = scan.nextInt();//共有M条公路，起点1，终点N
            int[] disturb = new int[N];//第i站有k个美女要搭讪
            for(int i = 0 ; i < N ; i++)
                disturb[i] = scan.nextInt();
            //两汽车站之间是否有班车直达
            int[][] road = new int[N][N];
            //初始情况下默认两个站点不可达
            for(int i = 0 ; i < N ; i++)
                for(int j = 0 ; j < N ; j++)
                    road[i][j] = MAX;
            //使用搭讪次数作为路径权值，根据公路情况更新road
            for(int i = 0 ; i < M ; i++){
                int start = scan.nextInt();
                int end = scan.nextInt();
                road[start - 1][end - 1] = disturb[end - 1];
                road[end - 1][start - 1] = disturb[start - 1];
            }
            searchMinDisturb(N , M , disturb , road);
        }
        scan.close();
    }
    /**
     * 计算路途中的最少搭讪次数
     * @param N 汽车站个数
     * @param M 公路条数
     * @param disturb 每个站点被搭讪的次数
     * @param road 记录某两个站点是否可达
     * */
    private static void searchMinDisturb(int N , int M , int[] disturb , int[][] road){
        int[] shortDisturb = new int[N];//保存经过车站的最少打扰次数1~N
        for(int i = 0 ; i < N ; i++)
            shortDisturb[i] = MAX;
        int[] visit = new int[N];//汽车站的访问标记
        //初始化，从汽车站1开始旅程
        shortDisturb[0] = disturb[0];
        visit[0] = 1;
        int startStation = 0;//起始位置在1号汽车站
        //还要经过n-1个站点
        for(int count = 0 ; count < N - 1 ; count++){
        //开始的时候不知道下一个站点，赋初值为-1
            int nextMinIndex = -1;
        //贪心算法容易陷入局部最优，使用Dijsktra算法求最短路径
            int minDisturb = Integer.MAX_VALUE;//如果有几个站点都满足题意，保存最小值
            for(int i = 0 ; i < N ; i++)
        //寻找下一个要前往的站点，保证有公路并且美女的搭讪次数最少
                if(visit[i] == 0 && road[startStation][i] < minDisturb){
                    nextMinIndex = i;
                    minDisturb = road[startStation][i];
                }
            shortDisturb[nextMinIndex] = minDisturb;
            visit[nextMinIndex] = 1;
        //判断下一个站点是不是终点N,如果是提前结束，如果不是继续下一次寻找
            if(nextMinIndex == N - 1)
                break;
            //更新权值矩阵
            for(int i = 0 ; i < N ; i++)
                if(visit[i] == 0 && road[startStation][nextMinIndex] + road[nextMinIndex][i] < road[startStation][i])
                    road[startStation][i] = road[startStation][nextMinIndex] + road[nextMinIndex][i];
        }
        //最少搭讪次数 = 途中遇到的搭讪次数 + 起始站1遇到的搭讪次数
        System.out.println(shortDisturb[N - 1] + shortDisturb[0]);
    }
}
