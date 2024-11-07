package com.itgroup.data.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public static boolean isEmpty(CharSequence source) {
        return source == null || source.isEmpty();
    }

    public static boolean isNotEmpty(CharSequence source) {
        return !isEmpty(source);
    }

    public static boolean isDigit(String source) {
        if (isEmpty(source)) {
            return false;
        }
        if (source.contains(".") && source.indexOf(".") != source.lastIndexOf(".")) {
            return false;
        }
        for (int i = 0; i < source.length(); i++) {
            if (!Character.isDigit(source.charAt(i)) & source.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotDigit(String source) {
        return !isDigit(source);
    }
}
