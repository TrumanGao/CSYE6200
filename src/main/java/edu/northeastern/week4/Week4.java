package edu.northeastern.week4;

public class Week4 {
	public static void main(String[] args) {
		System.out.println("main 参数：" + args);

		char [] chaArr = {'h', 'e', 'l', 'l', 'o'};
		String str = new String(chaArr);

		System.out.println(chaArr.getClass());
		System.out.println(str.getClass());

	}
}
