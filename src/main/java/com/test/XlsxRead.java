package com.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class XlsxRead {
    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        File file = new File("/opt/user.xlsx");
        try {
            InputStream is = new FileInputStream(file);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
            // 获取每一个工作薄
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                // 获取当前工作薄的每一行
                for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    JSONObject jsonObject = new JSONObject();
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        //读取第一列数据
                        XSSFCell one = xssfRow.getCell(0);
                        //读取第二列数据
                        XSSFCell two = xssfRow.getCell(1);
                        jsonObject.put("mail",getValue(two));
                        //读取第四列数据
                        XSSFCell four = xssfRow.getCell(3);
                        jsonObject.put("department",getValue(four));
                        //读取第五列数据
                        XSSFCell five = xssfRow.getCell(4);
                        jsonObject.put("position",getValue(five));


                        //System.out.println(String.format("%s,%s,%s,%s",getValue(one),getValue(two),getValue(four),getValue(five)));
                        //System.out.println(getValue(two));
                        jsonArray.add(jsonObject);


                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(jsonArray);
        System.out.println(jsonArray.size());
    }

    private static String getValue(XSSFCell xssfRow) {

        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }
}
