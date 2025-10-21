package edu.northeastern.week1and2;

import java.util.Scanner;

public class Days {
	public static void main(String[] args) {
		char ch;
		boolean flag = true;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("Please enter the first letter of a day____");
			ch = input.next().charAt(0);

			switch (ch) {
			case 'm':
			case 't':
			case 'w':
			case 'r':
			case 'f':
			case 'M':
			case 'T':
			case 'W':
			case 'R':
			case 'F':
				System.out.println("It is week day");
				break;
			case 's':
			case 'n':
			case 'S':
			case 'N':
				System.out.println("Yay!!! It is weekend");
				break;
			default:
				System.out.println("Wrong day");
				flag = false;
			}
		} while (flag == true);

	}
}