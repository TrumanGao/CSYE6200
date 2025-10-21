package edu.northeastern.week6;

public class Person {
	protected Address address;
	protected String firstName;
	protected String lastName;
	int age;

	public Person(String firstName) {
		this.firstName = firstName;
		Student s = new Student("a");
	}

//	public Person() {
//
//	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
