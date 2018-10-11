package com.aborob.test;

import org.apache.commons.codec.digest.DigestUtils;

public class PoW {

    public static void main(String arg[]) {

        final String originalString = "satoshi nakamoto"; // text to hash
        final int difficulty = 5; // Increase difficulty
        pow(originalString, difficulty);

    }

    public static void pow(final String originalString, final int difficulty) {

        int nonce = 0;
        StringBuilder difficultyTargetBuilder = new StringBuilder();
        for (int i = 1; i <= difficulty; i++) {
            difficultyTargetBuilder.append("0");
        }
        final String difficultyTarget = difficultyTargetBuilder.toString();
        boolean solved = false;
        String sha256hex = null;
        while (solved == false) {
            sha256hex = DigestUtils.sha256Hex(originalString + nonce);
            final String sub = sha256hex.substring(0, difficulty);
            if (sub.equals(difficultyTarget)) {
                solved = true;
                break;
            }
            nonce++;
        }
        System.out.println("Original text: " + originalString);
        System.out.println("Targeted difficulty: " + difficulty);
        System.out.println("Valid hash: " + sha256hex);
        System.out.println("Nonce: " + nonce);
    }
}
