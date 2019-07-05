package com.sun.naruto.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian.
 */
public class Collections {

    public static <E> List<E> copyAsArrayList(List<E> src) {
        if (null == src || src.size() == 0){
            return new ArrayList<>();
        }
        return new ArrayList<>(src);
    }
}
