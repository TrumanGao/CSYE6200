package edu.northeastern.week5;

public class Week5Practice {
	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("Unexpected arguments");
			return;
		}

		// convert datatype
		int arg0 = Integer.valueOf(args[0]);

		// convert datatype
		float arg2 = Float.valueOf(args[2]);

		// create instance
		Week5 week5 = new Week5(arg0, args[1], arg2);

		week5.setID(arg0);
		int id = week5.getID();
		System.out.println(id);

		week5.setName(args[1]);
		String name = week5.getName();
		System.out.println(name);

		week5.setGpa(arg2);
		float gpa = week5.getGpa();
		System.out.println(id);
	}
}