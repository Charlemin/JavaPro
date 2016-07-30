package com.algorithm;

/**
 * Created by Eric on 2016/7/26.
 */

import java.util.*;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 处理:
 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加;(文件所在的目录不同，文件名和行号相同也要合并)
 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 3.输入的文件可能带路径，记录文件名称不能带路径
 */
public class CountErrors {
    public static void main(String[] args) {
        Map<String,Integer> errorsMap = new LinkedHashMap<String, Integer>();
        List<String> inputStrings = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String inputString = sc.nextLine();
            inputStrings.add(inputString);
        }
//        inputStrings.add("e:\\1\\aa3.txt 1");
//        inputStrings.add("e:\\1\\aa2.txt 3");
//        inputStrings.add("e:\\1\\aa2.txt 3");
//        inputStrings.add("e:\\1\\aa3.txt 3");
//        inputStrings.add("e:\\1\\aa3.txt 3");
//        inputStrings.add("e:\\1\\aa3.txt 3");
        Iterator inputIter = inputStrings.iterator();
        while (inputIter.hasNext()) {
            String fileName = "";
            int fileNameStart = 0;
            String input =(String) inputIter.next();
            for (int i = input.length() - 1; i >= 0; i--)
                    if (input.charAt(i) == '\\') {
                        fileNameStart = i;
                        break;
                    }
            if (fileNameStart != 0)
                    fileName = input.substring(fileNameStart + 1);
            else fileName = input;
            if (errorsMap.containsKey(fileName)) {
                    int i = errorsMap.get(fileName);
                    errorsMap.put(fileName, ++i);
            } else errorsMap.put(fileName, 1);
        }
        // 给LinkedHashMap排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(errorsMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            //降序排序
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
       if (list.size() > 8){
           int i = 0;
           for (Map.Entry<String, Integer> mapping : list) {
               i ++;
               if (i > 8) break;
               String key = mapping.getKey();
               int errors = mapping.getValue();
               String actualFileName = key.split(" ")[0];
               int line = Integer.parseInt(key.split(" ")[1]);
               if (actualFileName.length() > 16) {
                   System.out.print(actualFileName.substring(actualFileName.length() - 16) + "" + line + "" + errors + " ");
               } else
                   System.out.print(actualFileName + " " + line + " " + errors + " ");
           }

       }else {
           for (Map.Entry<String, Integer> mapping : list) {
               String key = mapping.getKey();
               int errors = mapping.getValue();
               String actualFileName = key.split(" ")[0];
               int line = Integer.parseInt(key.split(" ")[1]);
               if (actualFileName.length() > 16) {
                   System.out.print(actualFileName.substring(actualFileName.length() - 16) + "" + line + "" + errors + " ");
               } else
                   System.out.print(actualFileName + " " + line + " " + errors + " ");
           }
       }
//        Iterator iterator = errorsMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//            String key = (String) entry.getKey();
//            int errors = (Integer) entry.getValue();
//            String actualFileName = key.split(" ")[0];
//            int line = Integer.parseInt(key.split(" ")[1]);
//            if (actualFileName.length() > 16) {
//                System.out.print(actualFileName.substring(actualFileName.length() - 16) + "" + line + "" + errors + " ");
//            } else
//                System.out.print(actualFileName + " " + line + " " + errors + " ");
//        }
    }
}
