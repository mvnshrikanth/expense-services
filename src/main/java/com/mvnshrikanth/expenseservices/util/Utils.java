package com.mvnshrikanth.expenseservices.util;

import java.time.LocalDateTime;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDateTime today() {
        return LocalDateTime.now();
    }

}
