package com.stuartyee.deadofwintergameaid.utilities;

import java.util.Random;

public class DiceRoller {
    static Random random = new Random();

    public static int[] rollDice(int num) {
        int[] results = new int[num];
        for (int i = 0; i < num; i++) {
            results[i] = random.nextInt(6) +1;
        }
        return results;
    }

    public static String rollExposure() {
        String outcome = "Blank, no effect";
        int result = random.nextInt(12);
        if (result == 0) {
            outcome = "BITTEN!";
        } else if (result < 3) {
            outcome = "Frost bite!";
        } else if (result < 6) {
            outcome = "Wounded";
        }
        return outcome;
    }
}
