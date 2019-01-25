package com.wangyu.studentms.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 数据类型验证工具
 *
 * @author WangYu
 * @create 2019/01/19 22:27
 */
public class DataTypeUtils {
    /**
     * 判断数据是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNum(String str) {
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }


    /**
     * 将ResultSet得到的sql查询结果存储到json数组中
     *
     * @param rsList 传入List数据
     * @return json数组
     */
    public static JSONArray rsListToJsonArray(List<Map> rsList) {
        JSONArray jsonArray = new JSONArray();
        for (Map rowData : rsList) {
            Iterator entries = rowData.entrySet().iterator();
            JSONObject jsonObject = new JSONObject();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                jsonObject.put(key, value);
            }
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
