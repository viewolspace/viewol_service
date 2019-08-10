package com.viewol.util;

/**
 * 返回字符串中，数字+字母+汉子总个数
 */
public class WordsStatUtil {

    public static void main(String arg[]) {
        String str = null;

        System.out.print(wordCount(FilterHtmlUtil.html2Text(str)));
    }

    public static int wordCount(String content) {
        int chineseCount = 0;
        int englishCount = 0;
        int digitCount = 0;

        for (int i = 0; i < content.length(); i++) {
            char charTemp = content.charAt(i);
            if ((charTemp >= 'a' && charTemp <= 'z') || (charTemp >= 'A' && charTemp <= 'Z')) {
                englishCount++;
            } else if (charTemp >= '0' && charTemp <= '9') {
                digitCount++;
            } else {
                chineseCount++;
            }
        }

        return englishCount + digitCount + chineseCount;
    }
}