package com.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadUtil {

    public String readFromJson(String fileName) {
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream is = loader.getResourceAsStream(fileName);
        try {
            if (is != null) {
                StringBuilder builder = new StringBuilder();
                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                String line;
                while ((line = in.readLine()) != null) {
                    if (StringUtils.isNotBlank(line))
                        builder.append(line);
                }

                return builder.toString();
            }
        } catch (IOException e) {
            System.out.println(String.format("Failed to load file : %s \n %s", fileName, e.getMessage()));
        }
        return null;
    }

    @Test
    public void generateObject(){
        JSONObject result = new JSONObject();
        JSONArray listResult = new JSONArray();
        JSONArray lists = JSONObject.fromObject(readFromJson("list.json")).getJSONArray("result");
        for (Object list : lists){
            JSONObject listToJson = JSONObject.fromObject(list);
            JSONObject oneResult = new JSONObject();
            JSONObject tagModel = listToJson.getJSONObject("tagModel");
            result.put(tagModel.getString("field_name"),tagModel.getInt("id"));
            oneResult.put("id",tagModel.getString("id"));
            oneResult.put("field_name",tagModel.getString("field_name"));
            oneResult.put("name",tagModel.getString("name"));
            listResult.add(oneResult);
        }
        System.out.println(result);
        System.out.println(listResult);
    }
}
