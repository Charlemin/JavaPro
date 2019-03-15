package com;

import java.util.ArrayList;
import java.util.List;

public class ChildList {

    public static void main(String[] args) {
        childList("abbcbccacbbcbaaba");
        System.out.println();
        childList("ababba");
        int[] a = new int[]{1,2,3,4,5};
        int[] ab = {1,2,3,4,5};
    }
    public static void childList(String str) {
        List<Character> list = new ArrayList<>();
        list.add(str.charAt(str.length() -1 ));
        for (int i = str.length() -2; i >0; i --) {
            if (str.charAt(i ) >= list.get(list.size() -1))
                list.add(str.charAt(i ));
        }

        for (int j = list.size(); j > 0;j --)
            System.out.print(list.get(j -1 ));
    }
}
