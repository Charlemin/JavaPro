package com.util;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadUtil {

    public  String readFromJson(String fileName) {
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
}
