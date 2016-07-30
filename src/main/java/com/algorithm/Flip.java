package com.algorithm;

/**
 * Created by Eric on 2016/7/28.
 */

/**
 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),现在依次有一些翻转操作，
 要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后的棋盘颜色。
 给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
 测试样例：
 [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]],[[2,2],[3,3],[4,4]]
 返回：[[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
 */
public class Flip {
    public static void main(String[] args) {
      int[][] A = {{0,0,1,1},{1,0,1,0},{0,1,1,0},{0,0,1,0}};
      int[][] f = {{2,2},{3,3},{4,4}};
      Flip flip = new Flip();
      flip.flipChess(A,f);
        for (int i = 0; i < 4;i ++)
            for (int j = 0;j < 4;j ++)
                System.out.print(A[i][j] + " ");
    }
    public void flipChess(int[][] A, int[][] f) {
        for (int i = 0;i < 3;i ++){
            int x = f[i][0] - 1;
            int y = f[i][1] - 1;
            if ( 0 < x && x < 3 && 0 < y && y < 3){
                A[x][y + 1] = Math.abs(A[x][y + 1] - 1);
                A[x][y - 1] = Math.abs(A[x][y - 1] - 1);
                A[x - 1][y] = Math.abs(A[x - 1][y] - 1);
                A[x + 1][y] = Math.abs(A[x + 1][y] - 1);
            }
            if (x == 0 && y == 0) {
                A[0][1] = Math.abs(A[0][1] - 1);
                A[1][0] = Math.abs(A[1][0] - 1);
            }
            if (x == 0 && y == 3) {
                A[0][2] = Math.abs(A[0][2] - 1);
                A[1][3] = Math.abs(A[1][3] - 1);
            }
            if (x == 3 && y == 0) {
                A[2][0] = Math.abs(A[2][0] - 1);
                A[3][1] = Math.abs(A[3][1] - 1);
            }
            if (x == 3 && y == 3) {
                A[3][2] = Math.abs(A[3][2] - 1);
                A[2][3] = Math.abs(A[2][3] - 1);
            }
            if (x == 0 && 0 < y && y < 3)
            {
                A[0][y - 1] = Math.abs(A[0][y - 1] - 1);
                A[0][y + 1] = Math.abs(A[0][y + 1] - 1);
                A[1][y] = Math.abs(A[1][y] - 1);
            }
            if (x == 3 && 0 < y && y < 3)
            {
                A[3][y - 1] = Math.abs(A[3][y - 1] - 1);
                A[3][y + 1] = Math.abs(A[3][y + 1] - 1);
                A[2][y] = Math.abs(A[2][y] - 1);
            }
            if (y == 0 && 0 < x && x < 3)
            {
                A[x - 1][0] = Math.abs(A[x - 1][0] - 1);
                A[x + 1][0] = Math.abs(A[x + 1][0] - 1);
                A[x][1] = Math.abs(A[x][1] - 1);
            }
            if (y == 3 && 0 < x && x < 3)
            {
                A[x - 1][3] = Math.abs(A[x - 1][3] - 1);
                A[x + 1][3] = Math.abs(A[x + 1][3] - 1);
                A[x][2] = Math.abs(A[x][2] - 1);
            }
        }
    }
}

