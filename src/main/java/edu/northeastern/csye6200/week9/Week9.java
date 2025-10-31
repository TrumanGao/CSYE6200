package edu.northeastern.csye6200.week9;

import java.util.Scanner;

public class Week9 {
    public enum Days {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    String MONDAY = "Monday";
    String TUESDAY = "Tuesday";

    public static void main(String[] args) {
        System.out.println(Days.class.getClass());
        System.out.println(Days.class.getName());
        for (Days d : Days.values()) {
            System.out.println(d);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a day name: ");
        String in = input.nextLine();

        Days day = Days.valueOf(in.trim());

        switch (day) {
            case MONDAY:
                System.out.println("Today is " + in);
        }
    }

}
