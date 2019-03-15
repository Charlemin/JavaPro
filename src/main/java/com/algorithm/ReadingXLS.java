package com.algorithm;

import com.test.ZookeeperTest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.list.SetUniqueList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadingXLS {
//    public static void main(String[] args) throws Exception{
//        InputStream is = ReadingXLS.class.getClassLoader().getResourceAsStream("music.xls");
//        //FileOutputStream out = new FileOutputStream("/home/workspace/JavaPro/src/main/resources/goods.txt");
////        OutputStreamWriter outWriter = new OutputStreamWriter(out, "UTF-8");
////        BufferedWriter bufWrite = new BufferedWriter(outWriter);
//        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
//        HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
//        List<String> categoryA = SetUniqueList.decorate(new ArrayList<String>());
//        JSONArray jsonArray = new JSONArray();
//        List<String> aer = new ArrayList<String>();
//        String result = "";
//        for (int i = 1;i <=274;i ++){
//            String str = "(" + "\"tag_" + i + "\"" + "," + "\"tag_" +i + "\"" + "," + "\"小米音乐\"" + "," + (2020 + i) + "," + "\"\"" + ")";
//            aer.add(str);
//            result += str + ",";
//        }
//      for (int i = 0;i < aer.size();i ++)
//          //String aerStr = aer.get(i);
//          for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
//           HSSFRow hssfRow = hssfSheet.getRow(rowNum);
//           JSONObject jsonObject = new JSONObject();
//           if (hssfRow != null) {
//                HSSFCell three = hssfRow.getCell(2);
//                jsonObject.put("label",three.toString());
//
//                HSSFCell four = hssfRow.getCell(3);
//               jsonObject.put("value",four.toString());
////                HSSFCell five = hssfRow.getCell(4);
//                jsonArray.add(jsonObject);
//                //需要转换数据的话直接调用getValue获取字符串
//                //out.write((one + "," + two + "," + three + "," + four.toString().substring(0,four.toString().length() - 2) + "," + five + "\r\n").getBytes());
//            }
//        }
//    }
}
