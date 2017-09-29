package com.httpclient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringBuilderTest {
    protected Set tables = new HashSet();
    public static void main(String[] args) {
        StringBuilderTest sbt = new StringBuilderTest();
        System.out.println(sbt.getProfile());

    }

    protected Map getProfile() {
        //取得画像仓库标签ID
       String str = "{\n" +
               "  \"status\": 200,\n" +
               "  \"msg\": \"汽车\",\n" +
               "  \"result\": {\n" +
               "    \"tagModel\": {\n" +
               "      \"id\": 1968,\n" +
               "      \"uid\": \"01002003\",\n" +
               "      \"name\": \"是否有车\",\n" +
               "      \"uri\": \"8173\",\n" +
               "      \"owner\": \"wubin1\",\n" +
               "      \"data_type\": \"PHONE_IMEI_MD5\",\n" +
               "      \"content\": \"根据短信等数据源判断一个人有车的概率\",\n" +
               "      \"watch_user\": \"wubin1\",\n" +
               "      \"id_name\": \"ImeiMd5\",\n" +
               "      \"field_name\": \"Has_Car\",\n" +
               "      \"field_type\": \"double\",\n" +
               "      \"field_lifecycle\": 3838,\n" +
               "      \"field_update_period\": \"week\",\n" +
               "      \"god_extend\": \"search\",\n" +
               "      \"example\": \"0～1.0之间的小数，代表概率\",\n" +
               "      \"wiki\": \"\"\n" +
               "    },\n" +
               "    \"data4Log\": {\n" +
               "      \"id\": 8173,\n" +
               "      \"status\": 0,\n" +
               "      \"update_interval\": 0,\n" +
               "      \"name\": \"micloud/car_insurance_profile\",\n" +
               "      \"uri\": \"/user/h_data_platform/platform/micloud/car_insurance_profile\",\n" +
               "      \"log_preserve_time\": 0,\n" +
               "      \"is_partition\": 0,\n" +
               "      \"is_nest\": 0,\n" +
               "      \"tokafka\": 0,\n" +
               "      \"size\": 0,\n" +
               "      \"is_user_delete\": 0,\n" +
               "      \"is_add_partition\": 0,\n" +
               "      \"out_data\": 0,\n" +
               "      \"ref_table_id\": 0\n" +
               "    },\n" +
               "    \"partitions\": [\n" +
               "      \"date=20170928\",\n" +
               "      \"date=20170927\",\n" +
               "      \"date=20170926\",\n" +
               "      \"date=20170925\",\n" +
               "      \"date=20170924\",\n" +
               "      \"date=20170923\",\n" +
               "      \"date=20170922\",\n" +
               "      \"date=20170921\"\n" +
               "    ],\n" +
               "    \"fieldAlertModels\": []\n" +
               "  }\n" +
               "}";

        //从画像仓库获取信息
        JSONObject res = JSONObject.fromObject(str);
        JSONObject up = res.getJSONObject("tagModel");
        JSONObject dp = res.getJSONObject("data4Log");
        JSONArray pars = res.getJSONArray("partitions");

        //聚合表信息
        addTable(up, dp, pars);

        //返回字段相关信息
        Map result = new HashMap();
        result.put("field", dp.getString("name").replaceAll("/", ".") + "." + up.getString("field_name"));

        return result;
    }

    //聚合表信息
    public void addTable(JSONObject up, JSONObject dp, JSONArray pars) {
        //获取分区信息
        String path = dp.getString("uri");
        if (pars.size() > 0) {
            path += "/" + pars.getString(0);
        }

        //自动添加表信息
        Map table = new HashMap();
        table.put("name", dp.getString("name").replaceAll("/", "."));
        table.put("id", up.getString("id_name"));
        table.put("path", path);
        tables.add(table);
        System.out.println(tables);
    }
}
