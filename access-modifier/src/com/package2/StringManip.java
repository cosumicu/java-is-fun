package com.package2;

import java.util.Locale;

public class StringManip {
    public void print() {
        System.out.println("Class C");
    }

    public static int stringLength(String string1) {
        return string1.length();
    }

    public static int stringLength(String string1, String string2) {
        return string1.length() + string2.length();
    }

    public static String stringConcat(String string1, String string2) {
        return string2.concat(string1);
    }

    public static String stringUpperCase(String string) {
        return string.toUpperCase(Locale.ROOT);
    }
}
