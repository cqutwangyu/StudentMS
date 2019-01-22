package com.wangyu.studentms.util;

/**
 * 数据类型验证工具
 *
 * @author WangYu
 * @create 2019/01/19 22:27
 */
public class DataTypeUtils {
    public static boolean isNum(String str){
        return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
    }
}
