package numer0n.util;

import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Random;
import numer0n.constant.GameConfig;

public class NumeronNumberGenerator {
    private static final Random random = new Random();

    public static String generateUniqueDigitNumber() {
        LinkedHashSet<Integer> digits = new LinkedHashSet<>();

        while (digits.size() < GameConfig.NUMBER_DIGITS) {
            int nextDigit = random.nextInt(10);

            digits.add(nextDigit);
        }

        Iterator<Integer> it = digits.iterator();
        StringBuilder randomNumber = new StringBuilder();

        while (it.hasNext()) {
            randomNumber.append(it.next());
        }

        return randomNumber.toString();
    }
}
