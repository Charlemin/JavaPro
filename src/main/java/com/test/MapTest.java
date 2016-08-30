package com.test;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Eric on 2016/8/24.
 */
public class MapTest {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag)
            System.out.println("hello");

    }

    public static Map<String, Object> resetTemplateGuid(Map<String, Object> requestMap) {
        if (requestMap.containsKey("metrics")) {
            Map<String, Object> metricsMap = (Map<String, Object>) requestMap.get("metrics");
            metricsMap.put("guid", "GUID_NOT_SET");
//			List<Map<String, Object>> metricsPoliciesMap = (List<Map<String, Object>>) metricsMap.get("policies");
//			for (Map<String, Object> policy : metricsPoliciesMap) {
//				policy.put("isenable", false);
//			}
        }
        if (requestMap.containsKey("scheduled")) {
            Map<String, Object> scheduledMap = (Map<String, Object>) requestMap.get("scheduled");
            List<Map<String, Object>> scheduledPoliciesMap = (List<Map<String, Object>>) scheduledMap.get("policies");
            for (Map<String, Object> policy : scheduledPoliciesMap) {
                policy.put("guid", "GUID_NOT_SET");
            }
        }
        return requestMap;
    }

    public static Map<String, Object> generateGuid(Map<String, Object> rootMap) {
        if (rootMap.containsKey("metrics")) {
            Map<String, Object> metricMap = (Map<String, Object>) rootMap.get("metrics");
            String guid = (String) metricMap.get("guid");
            if (guid.equals("GUID_NOT_SET")) {
                metricMap.put("guid", UUID.randomUUID().toString());
            }
        }
        if (rootMap.containsKey("scheduled")) {
            List<Map<String, Object>> policies = (List<Map<String, Object>>) ((Map<String, Object>) rootMap
                    .get("scheduled")).get("policies");
            for (Map<String, Object> policy : policies) {
                String guid = (String) policy.get("guid");
                if (guid.equals("GUID_NOT_SET")) {
                    policy.put("guid", UUID.randomUUID().toString());
                }
            }
        }
        return rootMap;
    }

    public  static Map<String, Object> stringToMap(String mapString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(mapString, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonParseException e) {
            //logger.error("JsonParseException" + e);
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            //logger.error("JsonMappingException" + e);
            e.printStackTrace();
        } catch (IOException e) {
            //logger.error("IOException" + e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new HashMap<String, Object>();
    }
}
