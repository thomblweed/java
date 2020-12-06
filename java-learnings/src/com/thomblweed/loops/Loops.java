package com.thomblweed.loops;

import java.util.ArrayList;
import java.util.List;

public class Loops {

    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome(-123321);
        System.out.println(isPalindrome);

        hasSharedDigit(12, 23);
    }

    public static boolean isPalindrome(int number) {
        int reverse = 0;
        int startNumber = number;

        while (number != 0) {
            int lastDigit = number % 10;
            reverse = (reverse * 10) + lastDigit;
            number = number / 10;
        }

        if (startNumber == reverse)
            return true;

        return false;
    }

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0)
            return -1;

        String numberString = String.valueOf(number);
        int firstDigit = Integer.parseInt(numberString.substring(0, 1));
        int lastDigit = number % 10;

        return firstDigit + lastDigit;
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0)
            return -1;

        List<Integer> evenDigits = getEvenDigits(number);

        int response = 0;

        for (Integer evenNumber : evenDigits) {
            response = response + evenNumber;
        }

        return response;
    }

    private static List<Integer> getEvenDigits(int number) {
        List<Integer> evenDigits = new ArrayList<>();

        int temp = 0;
        while (number > 0) {
            temp = number % 10;
            if ((temp % 2) == 0)
                evenDigits.add(temp);
            number = number / 10;
        }

        return evenDigits;
    }

    public static boolean hasSharedDigit(int startInclusive, int endInclusive) {
        if (startInclusive < 10 || startInclusive > 99)
            return false;
        if (endInclusive < 10 || endInclusive > 99)
            return false;

        int startFirstDigit = Integer.parseInt(String.valueOf(startInclusive).substring(0, 1));
        int startLastDigit = startInclusive % 10;

        int endFirstDigit = Integer.parseInt(String.valueOf(endInclusive).substring(0, 1));
        int endLastDigit = endInclusive % 10;

        if (startFirstDigit == endFirstDigit || startLastDigit == endLastDigit
                || startFirstDigit == endLastDigit || startLastDigit == endFirstDigit)
            return true;

        return false;
    }
}
