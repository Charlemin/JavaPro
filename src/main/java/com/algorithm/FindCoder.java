package com.algorithm;

/**
 * Created by Eric on 2016/7/28.
 */

import java.util.*;

/**
 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，并将其作为一个新的数组返回。结果字符串的顺序按照"Coder"出现的次数递减排列，若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
 给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。同时保证一定存在包含coder的字符串。
 测试样例：
 ["i am a coder","Coder Coder","Code"],3
 返回：["Coder Coder","i am a coder"]
 */
public class FindCoder {
    public static void main(String[] args) {

        String[] A = {"coder","dccoderrlcoderxxpicoderhcoderbiwcoderdcoderrcodermcoderdbvcodertrwvycoderimvcoderuswfccoderczecoderczncoderkfuehcoderocoderiuvccoderfwcodervdiycoderifqjcoder","vxroicoderdqcoderfvcodermtyrcoderlcoderwrygcoder","hcoderwzmjccoderamfmvcoderazmcoderhcodersnuccoderceocodermsmifcoderpwpcodertqbqcoderentbcoderxsgpkcoderrqrbcoderucoder"};
        String[] result =new FindCoder().findCoder(A,4);
        for (int i = 0;i < result.length;i ++)
            System.out.println(result[i]);
    }

    public String[] findCoder(String[] A, int n) {
        Map<String,Integer> codersMap = new LinkedHashMap<String, Integer>();
        for (int i = 0;i < n;i ++)
        {
            int count = countStr(A[i],"Coder") + countStr(A[i],"coder");
            if (count > 0)
            codersMap.put(A[i],count);
        }
        // 给LinkedHashMap排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(codersMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序排序
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        String[] result = new String[list.size()];
        int i = 0;
        for (Map.Entry<String,Integer> coderMap : list) {
            result[i++] = coderMap.getKey();
            System.out.println(coderMap.getKey() + " " + coderMap.getValue());
        }
        return result;
    }

    //查找字符串中含有某个子串的个数
    public  int countStr(String str1, String str2) {
        int counter = 0;
        if (str1.indexOf(str2) == -1) {
            return 0;
        } else {
            for (int i = 0;i <= str1.length() - 5;i ++)
                if (str1.substring(i,i + 5).equals(str2))
                    counter ++;
        }
        return counter;
    }
}
