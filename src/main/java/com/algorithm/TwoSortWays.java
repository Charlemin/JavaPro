package com.algorithm;

/**
 * Created by Eric on 2016/8/10.
 */

import java.util.Scanner;

/**
 考拉有n个字符串字符串，任意两个字符串长度都是不同的。考拉最近学习到有两种字符串的排序方法： 1.根据字符串的字典序排序。例如：
 "car" < "carriage" < "cats" < "doggies < "koala"
 2.根据字符串的长度排序。例如：
 "car" < "cats" < "koala" < "doggies" < "carriage"
 考拉想知道自己的这些字符串排列顺序是否满足这两种排序方法，考拉要忙着吃树叶，所以需要你来帮忙验证。
 输入描述:
 输入第一行为字符串个数n(n ≤ 100)
 接下来的n行,每行一个字符串,字符串长度均小于100，均由小写字母组成

 输出描述:
 如果这些字符串是根据字典序排列而不是根据长度排列输出"lexicographically",

 如果根据长度排列而不是字典序排列输出"lengths",

 如果两种方式都符合输出"both"，否则输出"none"

 输入例子:
 3
 a
 aa
 bbb

 输出例子:
 both
 */
public class TwoSortWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] strings = new String[n];
            for (int i = 0;i < n;i ++)
                strings[i] = sc.next();
            if (isLengthsSort(strings) == true && isLexicographicallySort(strings) == true)
                System.out.println("both");
            if (isLengthsSort(strings) == false && isLexicographicallySort(strings) == false)
                System.out.println("none");
            if (isLengthsSort(strings) == true && isLexicographicallySort(strings) == false)
                System.out.println("lengths");
            if (isLengthsSort(strings) == false && isLexicographicallySort(strings) == true)
                System.out.println("lexicographically");
        }
    }

    public static boolean isLexicographicallySort(String[] strings){
        boolean flag = false;
        int length = strings.length;
        for (int i = 0;i < length - 1;i ++){
            flag = isLexicographicallySort_(strings[i],strings[i + 1]);
        }
        return flag;
    }

    public static boolean isLengthsSort(String[] strings){
        boolean flag = false;
        int length = strings.length;
        for (int i = 0;i < length - 1;i ++){
            flag = isLengthsSort_(strings[i],strings[i + 1]);
        }
        return flag;
    }

    public static boolean isLexicographicallySort_(String str_1,String str_2){
        boolean flag = false;
        if (str_1.length() > str_2.length())
            for (int i = 0;i < str_2.length();i ++) {
                if (str_1.charAt(i) < str_2.charAt(i)) {
                    flag = true;
                    break;
                }else if (str_1.charAt(i) > str_2.charAt(i))
                {
                    flag = false;
                    break;
                }
            }
        else {
            for (int i = 0;i < str_1.length();i ++)
                if (str_1.charAt(i) <= str_2.charAt(i))
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
        return flag;
    }

    public static boolean isLengthsSort_(String str_1,String str_2){
        boolean flag = false;
        if (str_1.length() < str_2.length())
            flag = true;
        return flag;
    }
}
