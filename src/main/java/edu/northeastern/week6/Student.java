package edu.northeastern.week6;

public class Student extends Person {
	protected int studentId;
	protected float gpa;

	public Student(String fName) {
		super(fName);
		this.firstName = fName;

	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public static void main(String[] args) {
		System.out.println(new Person("zs"));
	}
}
