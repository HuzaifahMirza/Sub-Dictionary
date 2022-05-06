import java.util.Scanner;
//Huzaifah Mirza 40136913
//COMP249 
//Assignment #4 part #1
//April 15, 2022
//This program accepts a txt file and returns a new file in which all the text in the original file has been processed into a list of all the words used in the text. 

/**
 * @author Huzaifah Mirza
 *
 */
public class Driver {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				"Welcome to the text file processing program. This program was brought to you by Huzaifah Mirza.");

		SubDictionary dict = new SubDictionary();
		Scanner in = new Scanner(System.in);
//		dict.convertInputFile("New Text Document.txt");
//		PersonOfTheCentury.txt
		System.out.println("please enter a file name.");
		String s = in.nextLine();
		dict.convertInputFile(s);

	}

}
