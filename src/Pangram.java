import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pangram {

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

		if (isPangram(str)) {
			System.out.println(str + " is a Pangram which contains a string using every letter of English alphabet at least once.");
		} else {
			System.out.println(str + " is not Pangram which does not have every letter of English alphabet.");
		}

	}

	private static boolean isPangram(String line) {
		char[] chars = line.toCharArray();
		int distinctValues = 0;

		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars.length; j++) {
				if (i != j && chars[i] != chars[j] && Character.isLetter(chars[i])) {
					distinctValues++;
					if (distinctValues == 26) {
						return true;
					}
				}
			}
		}
		return false;

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
