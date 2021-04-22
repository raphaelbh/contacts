package com.zup.apipoc.commons.utils;

public final class StringUtils {

    private StringUtils() {}

    public static boolean isNullOrEmpty(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmptyWhiteSpace(String s) {
        if(s == null || s.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
