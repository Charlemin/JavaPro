package com.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Eric on 2016/6/24.
 */
public class JsonNodee {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String json=" [\n" +
                "      {\n" +
                "        \"starttime\": 1459759432433,\n" +
                "        \"endtime\": 1459799432393,\n" +
                "        \"instanceduring\": 12,\n" +
                "        \"instanceafter\": 4,\n" +
                "        \"priority\": 3,\n" +
                "        \"repeatday\": [1,2,3,4,5,6,7],\n" +
                "        \"isenable\": true,\n" +
                "        \"scheduledtype\": \"RECURRING\",\n" +
                "        \"afternumber\": 2,\n" +
                "        \"guid\": \"e25670d4-d40b-4cf1-b5c2-e776be5c2023\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"starttime\": 1458894770681,\n" +
                "        \"endtime\": 1458895070681,\n" +
                "        \"instanceduring\": 7,\n" +
                "        \"instanceafter\": 7,\n" +
                "        \"priority\": 3,\n" +
                "        \"repeatday\": [],\n" +
                "        \"isenable\": true,\n" +
                "        \"scheduledtype\": \"ONCE\",\n" +
                "        \"afternumber\": 3,\n" +
                "        \"guid\": \"c67ca247-3846-460b-80cc-3605e890fd04\"\n" +
                "      }\n" +
                "    ]";
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            Map<String,Object>[] policies = objectMapper.readValue(json, new TypeReference<Map<String, Object >[]>(){});
            for(Map<String,Object> policy : policies)
                System.out.println(policy.get("starttime"));
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
