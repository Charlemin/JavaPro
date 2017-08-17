package com.file;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) throws Exception{
        File file = new File("");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

    }
}
