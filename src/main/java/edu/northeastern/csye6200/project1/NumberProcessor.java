package edu.northeastern.csye6200.project1;

public class NumberProcessor {

	public static void main(String[] args) {

//		int arg = 281;
//		int length = String.valueOf(arg).length();
//
//		for (int i = 0; i < length; i++) {
//			arg = NumberProcessor.rotateInt(arg);
//			System.out.println(arg);
//		}

		int[] num = { 2, 2, 4, 8, 16, 32, 6 };

		System.out.println(NumberProcessor.isSummative(num));

//		System.out.println(reverseString("1"));
	}

	/**
	 *
	 * This method returns true if its integer argument is "special", otherwise it
	 * returns false A number is defined to be special if where sum of its positive
	 * divisors equals to the number itself. For example, 6 and 28 are "special
	 * whereas 4 and 18 are not.
	 *
	 */
	public static boolean isSpecial(int input) {
		if (input <= 0) {
			return false;
		}
		int sum = 0;
		boolean special = false;
		for (int i = 0; i < input; i++) {
			if (i != 0 && input % i == 0) {
				sum += i;
			}
		}
		special = sum == input;
		return special;
	}

	/**
	 *
	 * This method returns true if a number is "UniquePrime", false otherwise. A
	 * number is called "UniquePrime", if the number is a prime number and if we
	 * repeatedly move the first digit of the number to the end, the number still
	 * remains prime. For example, 197 is a prime number, if we move the first digit
	 * to the end, we will have a number 971, which is a prime number, if we again
	 * move the first digit to the end, we get 719, which is a prime number.
	 *
	 */
	public static boolean isUniquePrime(int num) {
		int length = NumberProcessor.getNumberLength(num);

		for (int i = 0; i < length; i++) {
			if (!NumberProcessor.checkPrime(num)) {
				return false;
			}
			num = NumberProcessor.rotateInt(num);
		}
		return true;
	}

	/**
	 *
	 * This method accepts an integer and returns true if the number is
	 * SquareAdditive, false otherwise. onsider a k-digit number n. Square it and
	 * add the right k digits to the left k or k-1 digits. If the resultant sum is
	 * n, then n is called a SquareAdditive number. For example, 9 is a
	 * SquareAdditive number
	 *
	 */

	public static boolean isSquareAdditive(int num) {
		int squaredNum = num * num;

		int numLength = NumberProcessor.getNumberLength(num);
		int squareLength = NumberProcessor.getNumberLength(squaredNum);

		String temp = String.valueOf(squaredNum);
		String rightStr = temp.substring(squareLength - numLength);
		String leftStr = temp.substring(0, squareLength - numLength);

		int result = (leftStr.isEmpty() ? 0 : Integer.parseInt(leftStr))
				+ (rightStr.isEmpty() ? 0 : Integer.parseInt(rightStr));
		return result == num;
	}

	/**
	 *
	 * Considering the sequence 1, 3, 6, 10, 15, 21, 28, 36, ...
	 *
	 * The method returns the nth sequence number. If n is <= 0, it returns 0
	 *
	 */

	public static int masonSequence(int num) {
		if (num <= 0) {
			return 0;
		}

		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
		}
		return sum;
	}

	/**
	 *
	 * A composite integer is called ReversibleSum if it fulfills the following two
	 * conditions:
	 *
	 * 1. The sum of its digits is the same as the sum of the digits of its prime
	 * factors. For example, 121 has two prime factors 11 * 11. The sum of the
	 * digits of the two prime factors is 1 + 1 + 1 + 1 = 4 and the sum of the
	 * digits of 121 is 1 + 2 + 1 = 4. 2. The reverse of the number equals to the
	 * number itself. For example, 121 has a reverse 121.
	 *
	 * The method returns true if the number is ReversibleSum
	 */
	public static boolean isReversibleSum(int num) {
		String strNum = String.valueOf(num);
		if (!strNum.equals(NumberProcessor.reverseString(strNum))) {
			return false;
		}
		boolean inDigit = true;
		int left = NumberProcessor.sumPrimeFactors(num, inDigit);
		System.out.println(left);
		int right = NumberProcessor.getDigitSum(num);
		System.out.println(right);
		return left == right;
	}

	/**
	 *
	 * This method returns true if the array is Incremental false otherwise. An
	 * array is called Incremental if it has the following properties: - The value
	 * of the first element equals the sum of the next two elements, which is equals
	 * to the next three elements, equals to the sum of the next four elements, etc.
	 * - It has a size of x*(x+1)/2 for some positive integer x .
	 *
	 * For example {6, 2, 4, 2, 2, 2, 1, 5, 0, 0} isIncremental, whereas {2, 1, 2,
	 * 3, 5, 6} is not
	 */

	public static boolean isIncremental(int array[]) {
		// 1. length
		int sum = 0;
		int step = 0;
		while (array.length > sum) {
			step += 1;
			sum += step;
		}
		System.out.println(array);
		if (sum != array.length) {
			return false;
		}

		// 2. value
		int index = 0;
		int targetSum = 0;
		for (int groupSize = 1; groupSize <= step; groupSize++) {
			int groupSum = 0;
			for (int i = 0; i < groupSize; i++) {
				groupSum += array[index];
				index += 1;
			}
			if (groupSize == 1) {
				targetSum = groupSum;
			} else if (groupSum != targetSum) {
				return false;
			}
		}

		return true;
	}

	/**
	 *
	 * TThis method accepts array of integers and sort the array
	 */
	public static void descendingSort(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			int maxIndex = i;

			for (int j = i + 1; j < data.length; j++) {
				if (data[j] > data[maxIndex]) {
					maxIndex = j;
				}
			}

			if (maxIndex != i) {
				int temp = data[i];
				data[i] = data[maxIndex];
				data[maxIndex] = temp;
			}
		}
	}

	/**
	 *
	 * This method returns true if the array is PairArray, false otherwise. An array
	 * is called PairArray if exactly one pair of its elements sum to 10. For
	 * example, {4,16,6, 13} is PairArray as only 4 and 6 sum to 10 The array
	 * {1,3,0,15,7} is not PairArray as more than one pair (10,0) and (3,7) sum to
	 * 10. {4,1,11} is not also PairArray as no pair sums to 10
	 *
	 *
	 */
	public static boolean isPairArray(int array[]) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == 18) {
					count++;
					if (count > 1) {
						return false;
					}
				}
			}
		}

		return count == 1;
	}

	/**
	 *
	 * this method accepts positive integer and returns an array of size n2 with
	 * elements in a specific pattern. For example, for n = 2, the method returns an
	 * array with elements {0,1,2,1}.
	 */
	public static int[] arrayPattern(int n) {
		int[] result = new int[n * n];
		int index = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				result[index++] = 0;
			}
			for (int j = i; j >= 1; j--) {
				result[index++] = j;
			}
		}

		return result;
	}

	/**
	 *
	 * This method returns true if the array is Summative, false otherwise. An array
	 * is called Summative if the nth element (n >0) of the array is the sum of the
	 * first n elements.
	 *
	 * For example, {2, 2, 4, 8, 16, 32, 64} is Summative, whereas {1, 1, 2, 4, 9,
	 * 17} is not.
	 *
	 */

	public static boolean isSummative(int array[]) {
		for (int i = 1; i < array.length; i++) {
			if (NumberProcessor.sumArrayItems(array, i) != array[i]) {
				return false;
			}
		}

		return true;
	}

	// ---------- utils functions ----------
	private static int rotateInt(int input) {
		String strInput = String.valueOf(input);
		String strRotated = strInput.substring(1) + strInput.charAt(0);
		int intRotated = Integer.parseInt(strRotated);
		return intRotated;
	}

	private static int getNumberLength(int input) {
		return String.valueOf(input).length();
	}

	private static boolean checkPrime(int input) {
		if (input < 2) {
			return false;
		}
		if (input == 2) {
			return true;
		}
		for (int i = 2; i < input; i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static String reverseString(String str) {
		String reversedStr = "";
		for (int i = 0; i < str.length(); i++) {
			String lastStr = str.substring(str.length() - i - 1, str.length() - i);
			reversedStr += lastStr;
		}
		return reversedStr;
	}

	private static int getDigitSum(int input) {
		int sum = 0;
		for (int i = 0; i < NumberProcessor.getNumberLength(input); i++) {
			String strDigit = String.valueOf(String.valueOf(input).charAt(i));
			sum += Integer.parseInt(strDigit);
		}
		return sum;
	}

	private static int sumPrimeFactors(int input, boolean inDigit) {
		if (input < 2) {
			return 0;
		}
		int sum = 0;
		while (input % 2 == 0) {
			sum += 2;
			input = input / 2;
		}
		for (int i = 3; i * i <= input; i += 2) {
			while (input % i == 0) {
				if (i >= 10 && inDigit) {
					sum += NumberProcessor.getDigitSum(i);
				} else {
					sum += i;
				}
				input = input / i;
			}
		}
		if (input > 1) {
			if (input >= 10 && inDigit) {
				sum += NumberProcessor.getDigitSum(input);
			} else {
				sum += input;
			}
		}
		return sum;
	}

	private static int sumArrayItems(int[] array, int index) {
		int i = 0;
		int sum = 0;
		while (i < index) {
			sum += array[i];
			i++;
		}
		return sum;
	}

}