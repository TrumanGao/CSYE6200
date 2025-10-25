package edu.northeastern.csye6200.week5;

public class Week5 {
	private int id;
	private String name;
	private float gpa;

	public Week5 (int id, String name, float gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}

	public int setID(int input) {
		if (input < 0) {
			System.out.println("unexpected input");
		}
		return this.id = input;
	}

	public int getID() {
		return this.id;
	}

	public String setName(String input) {
		return this.name = input;
	}

	public String getName() {
		return this.name;
	}

	public float setGpa(float input) {
		if (input < 0 || input > 4) {
			System.out.println("unexpected input");
			return this.gpa;
		}
		return this.gpa = input;
	}

	public float getGpa() {
		return this.gpa;
	}
}