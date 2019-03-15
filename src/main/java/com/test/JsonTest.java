package com.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.time.DateUtils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class JsonTest {

    public static void main(String[] args) {
        String test = "[{\"key\":\"baseAttribute\",\"name\":\"鍩虹\uE505灞炴€�\",\"order\":1,\"childrenDisplayType\":\"singleSelectButton\",\"label\":\"閫夋嫨灞炴€�\",\"children\":[{\"key\":\"userSex\",\"name\":\"鎬у埆\",\"order\":0,\"description\":\"鐢ㄦ埛濉\uE0A2啓鐨勬€у埆鏁版嵁锛� 鎵嬬幆銆佽处鍙枫€侀噾铻嶏級鍜屾ā鍨嬮\uE569娴嬬殑鎬у埆鏁版嵁\",\"updatePeriod\":\"鍛ㄧ骇鏇存柊\",\"label\":\"閫夋嫨鍊�\",\"limitation\":\"\",\"childrenDisplayType\":\"multipleSelectButton\",\"end\":true,\"children\":[{\"key\":\"IGNORE\",\"name\":\"鍏ㄩ儴\"},{\"key\":\"鐢�\",\"name\":\"鐢�\"},{\"key\":\"濂�\",\"name\":\"濂�\"}]},{\"key\":\"userAge\",\"name\":\"骞撮緞\",\"order\":1,\"description\":\"鐢ㄦ埛濉\uE0A2啓鐨勫勾榫勬暟鎹\uE1C6紙鎵嬬幆銆佽处鍙枫€侀噾铻� 锛夊拰妯″瀷棰勬祴鐨勫勾榫勬暟鎹�\",\"updatePeriod\":\"鍛ㄧ骇鏇存柊\",\"label\":\"閫夋嫨鍊�\",\"limitation\":\"\",\"childrenDisplayType\":\"multipleSelectButton\",\"end\":true,\"children\":[{\"key\":\"IGNORE\",\"name\":\"鍏ㄩ儴\"},{\"key\":\"0-17宀�\",\"name\":\"0-17宀�\"},{\"key\":\"18-21宀�\",\"name\":\"18-21宀�\"},{\"key\":\"22-24宀�\",\"name\":\"22-24宀�\"},{\"key\":\"25-29宀�\",\"name\":\"25-29宀�\"},{\"key\":\"30-34宀�\",\"name\":\"30-34宀�\"},{\"key\":\"35-39宀�\",\"name\":\"35-39宀�\"},{\"key\":\"40-49宀�\",\"name\":\"40-49宀�\"},{\"key\":\"50-80宀�\",\"name\":\"50-80宀�\"}]},{\"key\":\"userDegree\",\"name\":\"瀛﹀巻\",\"order\":2,\"label\":\"閫夋嫨鍊�\",\"description\":\"鐢ㄦ埛濉\uE0A2啓鐨勫\uE11F鍘嗘暟鎹\uE1C6紙璐﹀彿銆佸井鍗氾級\",\"updatePeriod\":\"鍛ㄧ骇鏇存柊\",\"limitation\":\"\",\"childrenDisplayType\":\"multipleSelectButton\",\"end\":true,\"children\":[{\"key\":\"鍒濅腑鍙婁互涓�\",\"name\":\"鍒濅腑鍙婁互涓�\"},{\"key\":\"涓\uE15D笓/鎶€鏍�\",\"name\":\"涓\uE15D笓/鎶€鏍�\"},{\"key\":\"楂樹腑\",\"name\":\"楂樹腑\"},{\"key\":\"澶т笓\",\"name\":\"澶т笓\"},{\"key\":\"鏈\uE102\uE756\",\"name\":\"鏈\uE102\uE756\"},{\"key\":\"纭曞＋\",\"name\":\"纭曞＋\"},{\"key\":\"鍗氬＋鍙婁互涓�\",\"name\":\"鍗氬＋鍙婁互涓�\"}]}]},{\"key\":\"bindingAttribute\",\"name\":\"缁戝畾灞炴€�\",\"label\":\"閫夋嫨灞炴€�\",\"order\":3,\"childrenDisplayType\":\"singleSelectButton\",\"children\":[]},{\"key\":\"deviceAttribute\",\"name\":\"璁惧\uE62C灞炴€�\",\"order\":4,\"label\":\"閫夋嫨灞炴€�\",\"childrenDisplayType\":\"singleSelectButton\",\"children\":[]},{\"key\":\"purchaseAttribute\",\"name\":\"璐\uE15D拱灞炴€�\",\"label\":\"閫夋嫨灞炴€�\",\"order\":7,\"childrenDisplayType\":\"singleSelectButton\",\"children\":[{\"key\":\"purchaseAbility\",\"name\":\"璐\uE15D拱鑳藉姏\",\"order\":1,\"label\":\"閫夋嫨鍊�\",\"description\":\"鏍规嵁鐢ㄦ埛鐨勫巻鍙茬背甯佹秷璐规儏鍐� / 鍦ㄥ皬绫崇綉PC銆佸皬绫崇綉APP銆佺背瀹禔PP鐨勫巻鍙茶喘涔拌\uE511涓哄垽鏂\uE15E叾娑堣垂姘村钩楂樹綆\",\"updatePeriod\":\"澶╃骇鏇存柊\",\"limitation\":\"\",\"childrenDisplayType\":\"singleSelectButton\",\"children\":[]}]},{\"key\":\"behaviorAttribute\",\"name\":\"鐢ㄦ埛琛屼负\",\"order\":8,\"label\":\"閫夋嫨鏁版嵁婧�\",\"childrenDisplayType\":\"singleSelectButton\",\"children\":[]}]";
        JSONArray originalTagsList = JSONArray.fromObject(test);
        System.out.println(getCorrectResult(originalTagsList));
    }


    private static JSONArray getCorrectResult(JSONArray originalTagsList){
        for (int i = 0;i < originalTagsList.size();i ++) {
            if (originalTagsList.getJSONObject(i).getJSONArray("children").size() == 0)
                originalTagsList.remove(i);
            else {
                JSONArray children = originalTagsList.getJSONObject(i).getJSONArray("children");
                Iterator<JSONObject> childrenIterator = children.iterator();
                while (childrenIterator.hasNext()) {
                    JSONObject child = childrenIterator.next();
                    if (child.containsKey("children")) {
                        if (child.getJSONArray("children").size() == 0)
                            childrenIterator.remove();
                        else if (child.getJSONArray("children").size() == 1 &&
                                child.getJSONArray("children").getJSONObject(0).getString("key").equals("IGNORE"))
                            childrenIterator.remove();
                    }
                }
            }
        }
        return originalTagsList;
    }


    @Test
    public void test() throws Exception{
        String date = someday(0);
        System.out.println(date);
        String str = new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime() + "";
        System.out.println(str);
    }

    protected static String someday(int d) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -d);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }
}


