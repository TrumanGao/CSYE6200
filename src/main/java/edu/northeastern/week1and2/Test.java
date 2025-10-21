package edu.northeastern.week1and2;

public class Test {

	private int x;
	private float y;

	public Test(int x, float y) {
		this.setX(x);
		this.setY(y);
	}

	private int setX(int input) {
		this.x = input;
		return this.x;
	}

	private float setY(float input) {
		this.y = input;
		return this.y;
	}


	/**
	 *
	 * @param num1 the first integer argument
	 * @param num2 the second integer argument
	 * @return sum of the two integer arguments
	 */
	public int sum(int num1, int num2)

	{

		int result = num1 + num2;

		return result;

	}

}
