package com.thomblweed.loops;

import java.util.ArrayList;
import java.util.List;

public class Loops {

    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome(-123321);
        System.out.println(isPalindrome);
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

        List<Integer> evenNumbers = new ArrayList<>();

        int temp = 0;
        while (number > 0) {
            temp = number % 10;
            if ((temp % 2) == 0)
                evenNumbers.add(temp);
            number = number / 10;
        }

        int response = 0;

        for (Integer evenNumber : evenNumbers) {
            response = response + evenNumber;
        }

        return response;
    }
}
