package com.thomblweed;

public class Helpers {

    public static boolean isOdd(int number) {
        if (number < 0 || ((number % 2) == 0))
            return false;

        return true;
    }

    public static int sumOdd(int start, int end) {

        if ((start < 1 || end < 1) || end < start) {
            return -1;
        }

        int sumTotal = 0;

        for (int i = start; i <= end; i++) {
            if (isOdd(i))
                sumTotal = sumTotal + i;
        }

        return sumTotal;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12)
            return -1;
        if (year < 1 || year > 9999)
            return -1;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year))
                    return 29;
                return 28;
            default:
                return -1;
        }
    }

    public static void printNumberInWord(int number) {
        switch (number) {
            case 0:
                System.out.println("ZERO");
                break;
            case 1:
                System.out.println("ONE");
                break;
            case 2:
                System.out.println("TWO");
                break;
            case 3:
                System.out.println("THREE");
                break;
            case 4:
                System.out.println("FOUR");
                break;
            case 5:
                System.out.println("FIVE");
                break;
            case 6:
                System.out.println("SIX");
                break;
            case 7:
                System.out.println("SEVEN");
                break;
            case 8:
                System.out.println("EIGHT");
                break;
            case 9:
                System.out.println("NINE");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (temperature < 25 || temperature > 45)
            return false;

        if (summer && temperature <= 45)
            return true;

        if (temperature <= 35)
            return true;

        return false;
    }

    public static void printEqual(int param1, int param2, int param3) {
        if (param1 < 0 || param2 < 0 || param3 < 0) {
            System.out.println("Invalid Value");
            return;
        }

        if (param1 == param2 && param2 == param3) {
            System.out.println("All numbers are equal");
            return;
        }

        if (param1 != param2 && param1 != param3 && param2 != param3) {
            System.out.println("All numbers are different");
            return;
        }

        System.out.println("Neither all are equal or different");
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        double minutesInYear = 60 * 24 * 365;
        long years = (long) (minutes / minutesInYear);
        int days = (int) (minutes / 60 / 24) % 365;

        System.out.println(minutes + " min = " + years + " y and " + days + " d");
    }

    public static double area(double radius) {
        if (radius < 0)
            return -1.0;

        return radius * radius * Math.PI;
    }

    public static double area(double x, double y) {
        if (x < 0 || y < 0)
            return -1.0;

        return x * y;
    }

    public static boolean hasTeen(int number1, int number2, int number3) {
        if (number1 >= 13 && number1 <= 19) {
            return true;
        }

        if (number2 >= 13 && number2 <= 19) {
            return true;
        }

        if (number2 >= 13 && number2 <= 19) {
            return true;
        }

        return false;
    }

    public static boolean isTeen(int number) {
        if (number >= 13 && number <= 19) {
            return true;
        }

        return false;
    }

    public static boolean hasEqualSum(int number1, int number2, int number3) {
        int sumResult = number1 + number2;
        if (sumResult != number3)
            return false;

        return true;
    }

    public static boolean areEqualByThreeDecimalPlaces(double decimal1, double decimal2) {
        double trimmedDouble1 = trimDouble(decimal1);
        double trimmedDouble2 = trimDouble(decimal2);

        if (trimmedDouble1 == trimmedDouble2)
            return true;

        return false;
    }

    public static double trimDouble(double value) {
        String doubleString = Double.toString(value);

        String[] splitString = doubleString.split("\\.");
        String decimalStringValue = splitString[1];
        String first3Chars = (decimalStringValue.length() >= 3 ? decimalStringValue.substring(0, 3)
                : decimalStringValue.substring(0, decimalStringValue.length() - 1));

        return Double.parseDouble(splitString[0] + "." + first3Chars);
    }

    public static boolean isLeapYear(int year) {
        if (!(year >= 1) || !(year <= 9999)) {
            return false;
        }

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay) {
        if (!isBarking) {
            return isBarking;
        }

        if (hourOfDay > 23 || hourOfDay < 0) {
            return false;
        }

        if (hourOfDay < 8 || hourOfDay > 22) {
            return true;
        }

        return false;
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int megaBytes = kiloBytes / 1024;
        int remainingKiloBytes = kiloBytes % 1024;
        System.out.println(
                kiloBytes + " KB = " + megaBytes + " MB and " + remainingKiloBytes + " KB");
    }
}
