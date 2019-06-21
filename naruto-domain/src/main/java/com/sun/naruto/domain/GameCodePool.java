package com.sun.naruto.domain;

import java.util.ArrayList;

/**
 * @author sunjian.
 */
public class GameCodePool {
    private static ArrayList<String> codePool = new ArrayList<>();
    private static final int size = 10;

    static {
        for (int i = 1; i <= size; i++) {
            codePool.add(String.valueOf(i));
        }
    }

    public static String generateCode() {
        return codePool.remove(0);
    }

    public static void recycleCode(String code) {
        codePool.add(code);
    }
}
