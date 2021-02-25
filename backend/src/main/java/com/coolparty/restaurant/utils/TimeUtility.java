package com.coolparty.restaurant.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public final class TimeUtility {

    private TimeUtility() {

    }

    public static LocalDateTime convertToLocalDateTime(final Timestamp ts) {
        if (ts != null) {
            return ts.toLocalDateTime();
        }
        return null;
    }
}
