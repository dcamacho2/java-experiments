package randomNum;

/*
 * This program produces three flavors of Random Zoombini names:
 * 	(1) American, (2) Korean, (3) Japanese
 *
 * To call this program from the command line use:
 *
 * 	> java Zoombinis $(s) $(n) $(f)
 *
 * where $(s) is the seed for the random number generator,
 * 	$(n) is the number of Zoombini names to be generated
 * 	$(f) is the flavor of Zoombini names (from 1-3)
 *
 * The default values are as follows:  s=0, n=16, f=1.
 * If s=0, then no seed is given to the random number generator
 */

import java.util.*;

public class Zoombinis {
	/*
	 * Characteristics of the Name based on the 3 Cultures:
	 * 
	 * (1) American: short, typically 1 or 2 syllable names usually with a
	 * terminating consonant on the final syllable (2) Korean: very likely to
	 * have 3 syllable names (spaces in between), third syllable almost always
	 * has a terminating consonant (3) Japanese: Longer names, usually 3 to 5
	 * syllables in length, with almost no terminating consonants
	 */
	// Selected Chars and Strings
	// Basic Vowels
	public final static char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };
	// Basic Consonants
	public final static char[] CONSONANTS = { 'b', 'c', 'd', 'f', 'g', 'h',
			'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
			'y', 'z' };
	// Select Digraphs
	public final static String[] DIGRAPHS = { "tr", "sh", "ch", "gl", "ph" };
	// Select Diphthongs
	public final static String[] DIPHTHONGS = { "ai", "oi", "ia", "oe", "ou" };
	// T-Consonants
	public final static String[] TCONSONANTS = { "t", "s", "n", "th", "l",
			"b", "m" };

	// Following variables set the default values for the command line
	// arguments.
	public static int s = 0;
	public static int n = 16;
	public static int f = 1;

	public static Random generator = new Random();

	// Flags for syllable generation
	public static boolean finalSyl = false;
	public static boolean firstSyl = false;

	// Basic Functions
	static boolean isVowel(char c) {
		return (Arrays.asList(VOWELS).contains(c));
	}

	static boolean isConstanant(char c) {
		return (Arrays.asList(CONSONANTS).contains(c));
	}

	public static String randomVowel() {
		int randInt = generator.nextInt(Integer.MAX_VALUE);
		if (randInt % 5 < 4) {
			randInt = generator.nextInt(Integer.MAX_VALUE);
			return "" + VOWELS[randInt % 5];
		} else {
			randInt = generator.nextInt(Integer.MAX_VALUE);
			return DIPHTHONGS[randInt % 5];
		}
	}

	public static String randomConsonant() {
		int randInt = generator.nextInt(Integer.MAX_VALUE);
		if (randInt % 5 < 4) {
			randInt = generator.nextInt(Integer.MAX_VALUE);
			return "" + CONSONANTS[randInt % 21];
		} else {
			randInt = generator.nextInt(Integer.MAX_VALUE);
			return DIGRAPHS[randInt % 5];
		}
	}

	public static String randomSyllable() {
		String tempStr = "";
		tempStr += randomConsonant();
		if (firstSyl)
			tempStr = Character.toUpperCase(tempStr.charAt(0))
					+ tempStr.substring(1);
		tempStr += randomVowel();
		int randInt = generator.nextInt(Integer.MAX_VALUE);
		int randInt2 = generator.nextInt(Integer.MAX_VALUE);
		switch (f) {
		case 1: // American
			if (finalSyl) { // if terminating syllable
				tempStr += (randInt % 10 < 9) ? TCONSONANTS[randInt2 % 7] : ""; 
			} else {
				tempStr += (randInt % 2 < 1) ? TCONSONANTS[randInt2 % 7] : ""; 
			}
			break;
		case 2: // Korean
			if (finalSyl) { // if terminating syllable
				tempStr += (randInt % 100 < 95) ? TCONSONANTS[randInt2 % 7]
						: ""; 
			} else {
				tempStr += (randInt % 2 < 1) ? TCONSONANTS[randInt2 % 7] : ""; 
			}
			break;
		case 3: // Japanese
			tempStr += (randInt % 10 == 9) ? TCONSONANTS[randInt2 % 7] : ""; 
			break;
		}
		firstSyl = false;
		finalSyl = false;
		return tempStr;
	}

	public static String randomName() {
		String tempStr = "";
		int randInt = generator.nextInt(Integer.MAX_VALUE);
		switch (f) {
		case 1:
			firstSyl = true;
			if (randInt % 10 == 0) {
				for (int i = 0; i < 5; i++) {
					if (i == 4)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			} else if (randInt % 10 == 1) {
				for (int i = 0; i < 4; i++) {
					if (i == 3)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			} else if (randInt % 10 == 2) {
				for (int i = 0; i < 2; i++) {
					if (i == 1)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			} else if (randInt % 10 >= 5) {
				for (int i = 0; i < 2; i++) {
					tempStr += randomSyllable();
					finalSyl = true;
				}
			} else {
				tempStr += randomSyllable();
			}
			break;
		case 2:
			if (randInt % 100 == 1) {
				for (int i = 0; i < 4; i++) {
					firstSyl = true;
					if (i == 4)
						finalSyl = true;
					tempStr += randomSyllable() + " ";
				}
			} else if (randInt % 100 == 3) {
				for (int i = 0; i < 4; i++) {
					firstSyl = true;
					if (i == 3)
						finalSyl = true;
					tempStr += randomSyllable() + " ";
				}
			} else if (randInt % 100 == 2) {
				for (int i = 0; i < 2; i++) {
					firstSyl = true;
					if (i == 1)
						finalSyl = true;
					tempStr += randomSyllable() + " ";
				}
			} else if (randInt % 100 == 1) {
				finalSyl = true;
				tempStr += randomSyllable() + " ";
			} else {
				for (int i = 0; i < 3; i++) {
					firstSyl = true;
					if (i == 2)
						finalSyl = true;
					tempStr += randomSyllable() + " ";
				}
			}
			break;
		case 3:
			firstSyl = true;
			if (randInt % 20 == 0) {
				tempStr += randomSyllable();
			} else if (randInt % 20 == 1) {
				for (int i = 0; i < 2; i++) {
					if (i == 1)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			} else if (randInt % 20 >= 7) {
				for (int i = 0; i < 3; i++) {
					if (i == 2)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			} else if (randInt % 20 >= 13) {
				for (int i = 0; i < 4; i++) {
					if (i == 3)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			} else {
				for (int i = 0; i < 5; i++) {
					if (i == 4)
						finalSyl = true;
					tempStr += randomSyllable();
				}
			}
			break;
		}
		return tempStr;
	}

	public static void main(String[] args) {
		/*
		 * Command line arguments with default values of: s = 0 (random seed) n
		 * = 16 f = 1
		 */
		if (args.length > 0) {
			s = Integer.parseInt(args[0]);
		}
		if (args.length > 1) {
			n = Integer.parseInt(args[1]);
		}
		if (args.length > 2) {
			f = Integer.parseInt(args[2]);
		}
		generator = (s != 0) ? new Random(s) : new Random();
		for (int i = 0; i < n; i++) {
			System.out.println(randomName());
		}
	}
}
