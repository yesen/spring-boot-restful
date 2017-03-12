package com.code.generate;

/**
 * Created by home on 2017/3/12.
 */
public class StringRef {

    //去掉下划线， 下划线后面第一个字符大写， 第一个字符小写
    public static String lowerProccess(String str) {
        return underlineProccess(str, false);
    }

    //去掉下划线， 下划线后面第一个字符大写， 第一个字符大写
    public static String upperProccess(String str) {
        return underlineProccess(str, true);
    }

    // 去掉下划线， 下划线后面第一个字符大写， firstToUpperCase ：第一个字符是否大写
    public static String underlineProccess(String str, boolean firstToUpperCase) {
        if (str != null) {
            str = str.toLowerCase();
            str = strProccess("_", str);
            if (firstToUpperCase)
                str = str.substring(0, 1).toUpperCase() + str.substring(1);
            return str;
        }
        return null;
    }

    //去掉下划线 "_" 替换 大写
    public static String strProccess(String replaceStr, String str) {
        if (str != null) {
            int index = str.indexOf(replaceStr);
            if (index > -1) {
                String header = str.substring(0, index);
                String tail = str.substring(index + replaceStr.length());
                tail = tail.substring(0, 1).toUpperCase() + tail.substring(1);
                str = strProccess(replaceStr, header + tail);
            }
        }
        return str;
    }
}
