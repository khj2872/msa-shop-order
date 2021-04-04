package com.msa.shop.order.util;

import java.util.UUID;

public class Util {
    public static String makeRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
}
