package com.theresourceroom.api.util;

import java.security.SecureRandom;
import java.util.Random;

public class SecureSalt {

    public static String generateSalt () {

        final char[] allAllowed = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();

        //Use cryptographically secure random number generator
        Random random = new SecureRandom();

        StringBuilder salt = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            salt.append(allAllowed[random.nextInt(allAllowed.length)]);
        }
        return salt.toString();
    }
}
