package edu.northeastern.exercise1;

/**
 * Consider the following quadratic equation: ax² + bx + c Write a program that
 * solves such quadratic equation. In the main method of your program, you will
 * declare three local variables a, b, c with initial values 4, 8, and 3
 * respectively Then, you will find the roots of the equation assuming that any
 * of the three alternative outcomes are possible (i.e. the equation has either
 * zero roots (no real roots) or one root or two roots). Finally, your program
 * should print one of the following three messages depending on how many roots
 * the quadratic has: Zero roots: No real roots The root is: x The two roots
 * are: x and y
 *
 * Make sure to adhere exactly to the formatting above or your program will fail
 * the test cases. In case of two roots, you must print the smaller one first
 * (i.e, if x > y , y will be displayed first).
 */
public class Quadratic {
	public static void main(String[] args) {
		// ax² + bx + c
		double a = 4;
		double b = 8;
		double c = 3;

		double discriminant = b * b - 4 * a * c;

		if (discriminant < 0) {
			// zero roots
			System.out.println("Zero roots: No real roots");
		} else if (discriminant == 0) {
			// one root
			double x = -b / (2 * a);
			System.out.println("The root is: " + x);
		} else {
			// two roots
			double x = (-b + Math.sqrt(discriminant)) / (2 * a);
			double y = (-b - Math.sqrt(discriminant)) / (2 * a);
			System.out.println("The two roots are: " + Math.min(x, y) + " and " + Math.max(x, y));
		}

	}
}