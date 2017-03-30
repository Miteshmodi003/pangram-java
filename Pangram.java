package pangram;

import java.util.Scanner;

public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter a string: ");
		Scanner input = new Scanner(System.in);

		String str = input.nextLine();

		System.out.println("-------------------------");

		if (isPangramm(str)) {
			System.out.println("Given string is a Pangram");
		} else {
			System.out.println("Given string is not a Pangram");
		}
		input.close();
	}

	private static String matchAndReplace(String str, char lookFor, char replaceWith) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == lookFor) {
				c[i] = replaceWith;
			}
		}
		str = c.toString().valueOf(c);
		str = str.replaceAll(" ", "");
		return str;
	}

	private static boolean isPangramm(String str) {
		str = str.toLowerCase();
		str = matchAndReplace(str, '.', ' ');
		str = matchAndReplace(str, ',', ' ');
		str = matchAndReplace(str, ';', ' ');
		str = matchAndReplace(str, ':', ' ');
		str = matchAndReplace(str, '!', ' ');
		str = matchAndReplace(str, '?', ' ');
		str = matchAndReplace(str, '\'', ' ');

		boolean result = true;

		for (int i = 97; i <= 122; i++) {
			if (str.contains(Character.toString((char) i)))
				result = true;
			else {
				result = false;
				return result;
			}
		}
		return result;
	}
}
