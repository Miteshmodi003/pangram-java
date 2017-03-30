import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pangram_CoreJava {
	

	public static void main(String[] args) {
		System.out.print("Enter a string: ");

		String str = "";
		BufferedReader br;
		
		br = new BufferedReader(new InputStreamReader(System.in));

		try {
			str = br.readLine().toLowerCase();
			str = matchAndReplace(str, '.', ' ');
			str = matchAndReplace(str, ',', ' ');
			str = matchAndReplace(str, ';', ' ');
			str = matchAndReplace(str, ':', ' ');
			str = matchAndReplace(str, '!', ' ');
			str = matchAndReplace(str, '?', ' ');
			str = matchAndReplace(str, '\'', ' ');

			System.out.println("--------------------------");

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(isPangram(str));

	}

	private static String isPangram(String line) {
		int duplicate = 0;

		/*
		 * initial value should be false in case character array length does not
		 * equal to 26
		 */
		boolean result = false;

		String l = line + " is a pangram which has 26 distinct alphabets with no duplicates and no numbers!";

		/* convert a string into an array of characters */
		char[] charArray = line.toCharArray();

		/*
		 * verify if the string length is exactly 26 which is the first
		 * condition
		 */
		if (charArray.length == 26) {

			/* loop (iterate) through entire char array using for loop */
			for (int i = 0; i < charArray.length; i++) {

				/*
				 * if any character at given index is not alphabet, return false
				 * instantly!
				 */
				if (!Character.isLetter(charArray[i])) {
					result = false;
					return charArray[i] + " at index, i = " + i + " is not an Alphabet, so this string is not pangram";
				}
				/*
				 * nested for loop to compare character at i index against
				 * characters at index j by iterating through each of them
				 */
				for (int j = 0; j < charArray.length; j++) {

					/*
					 * verifies that if i and j are not same AND there aren't
					 * any duplicate characters
					 */
					if (i != j && charArray[i] == charArray[j]) {
						duplicate++;
						if (duplicate > 1) {
							return charArray[i] + " at index, i = " + i + " and " + charArray[j] + " at index, j = " + j
									+ " are Duplicate, so if duplicates are not allowed, this string is not pangram";
						}
					}
				}
			}
		} else {
			l = "String length is more than 26 or less than 26";
		}
		return l;
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
}
