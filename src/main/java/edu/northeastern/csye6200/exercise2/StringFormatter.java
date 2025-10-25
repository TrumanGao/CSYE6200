package edu.northeastern.csye6200.exercise2;

public class StringFormatter {

	/**
	 * A method which tells us whether the input character c is whitespace or not.
	 * For the purposes of this method, whitespace is spaces, newlines, and tab
	 * characters. If the character c is one of the whitespace characters, this
	 * method will return true, otherwise it will return false.
	 */
	public static boolean isWhiteSpace(char c) {
		return (c == ' ') || (c == '\n') || (c == '\t');
	}

	/**
	 * Starting from position 'from', this method finds the position of the first
	 * non-whitespace character in 's' (in other words, the position of the start of
	 * the next word). Thus, if s="hello world" and from=5, the method would return
	 * 6, i.e. the start position of the word "world". If there are no more words in
	 * the string, the method will return s.length().
	 */
	public static int getNextWordStart(String s, int from) {
		int pos = from;
		while (pos < s.length() && isWhiteSpace(s.charAt(pos))) {
			pos++;
		}
		return pos;
	}

	/**
	 * Starting from position 'from', this method finds the position of the first
	 * whitespace character in 's' (in other words, the position just after the end
	 * of the current word). Thus, if s="hello world" and from=2, the method would
	 * return 5, i.e. the position of the space right after the end of the word
	 * "hello". If the current word is at the end of the string, the method will
	 * return s.length().
	 */
	public static int getNextWordEnd(String s, int from) {
		int pos = from;
		while (pos < s.length() && !isWhiteSpace(s.charAt(pos))) {
			pos++;
		}
		return pos;
	}

	/**
	 * This method takes an input string, and reformats it so that the length of
	 * each line is at most 'size'. It does this by reading words from the input one
	 * by one, and appending to a line of output, moving on to the next line if the
	 * size of the line is exceeded. The output is returned as an array of strings,
	 * with each string representing one line of output.
	 */
	public static String[] format(String s, int size) {
		// save the current position in the input string and the
		// size of the current line of output
		int pos = 0, sizeCurrent = 0;

		// we'll store the output text in 'result', with each line separated
		// by newlines
		String result = "";

		int sLength = s.length();

		// keep going until we reach the end of the input string
		while (pos < sLength) {

			// find the location of the start of the next word
			pos = getNextWordStart(s, pos);
			int start = pos;

			// find the location of the end of the word
			pos = getNextWordEnd(s, pos);
			int end = pos;

			// use the start and end to get the word
			String nextWord = s.substring(start, end);
			int len = nextWord.length();

			if (nextWord.isEmpty()) {
				continue;
			}
//			System.out.println("------" + nextWord + "-----");
//			System.out.println(nextWord);

			if (sizeCurrent > 0 && sizeCurrent + 1 + len > size) {
				// case 1, the current line is not empty, but adding this word
				// would cause us to go over the line length. Restart from
				// the next line
				result += "\n";
				sizeCurrent = 0;
			} else if (sizeCurrent > 0) {
				// case 2, we're not at the beginning of the line, so add
				// a space before including this world
				result += " ";
				sizeCurrent += 1;
			}

			// regardless of the case, we want to add this word to the end of the line
			result += nextWord;
			sizeCurrent += len;
		}

		String[] lines = result.split("\n");

		// we've used newlines to separate lines, so let's use the newlines
		// as markers to turn the output into an array of Strings
		return lines;
	}

	/**
	 * A method which prints out the contents of the input. The input is an array of
	 * Strings, so this method should print out each string line by line, with one
	 * string per line.
	 */
	public static void printAll(String[] lines) {
		// TODO: enter the code to print all of the input lines here
		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
	}

	/**
	 * The main method will take a text, reformat it to 25-character lines, print
	 * the result, then do the same with 70-character lines.
	 */
	public static void main(String[] args) {

		// the text to print:
		String text = "" + "Mostly, when you see programmers, " + "they aren't doing anything. "
				+ "One of the attractive things about programmers " + "is that you cannot tell whether or not they are "
				+ "working simply by looking at them. " + "Very often they're "
				+ "sitting there seemingly drinking coffee and gossiping, " + "or just staring into space. "
				+ "What the programmer is trying to do is " + "get a handle on all the individual and unrelated "
				+ "ideas that are scampering around in his head. " + "- Charles M. Strauss";

		// first, format the text to 25-character lines, and use printAll
		// to print the result. Note that the format method returns an
		// array of Strings, in which each string represents one line.
		System.out.println("Output formatted to max 25 character lines:");
		System.out.println("-------------------------");
		String[] formatted = format(text, 25);
//		System.out.println(formatted);
		printAll(formatted);
		System.out.println("-------------------------");

		// do the same thing, but with 70-character lines
		System.out.println();
		System.out.println("Output formatted to max 70 character lines:");
		System.out.println("----------------------------------------------------------------------");
		formatted = format(text, 70);
//		System.out.println(formatted);
		printAll(formatted);
		System.out.println("----------------------------------------------------------------------");
	}
}