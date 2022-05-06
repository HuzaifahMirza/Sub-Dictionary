import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//Huzaifah Mirza 40136913
//COMP249 
//Assignment #4 part #1
//April 15, 2022

/**
* @author Huzaifah Mirza
*
*/
public class SubDictionary {

	/**converts input file into subdictionary
	 * @param file
	 */
	public void convertInputFile(String file) {
		char[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		ArrayList<String> raw = new ArrayList<String>();
		Scanner in = null;
		int i = 0;
		try {
			in = new Scanner(new FileInputStream(file));
			while (in.hasNext()) {
				boolean hasnum = false;
				String s = in.next();
				String[] array = s.split("");
				for (int k = 0; k < array.length; k++) {
					if (array[k].matches("[0-9]")) {
						s = "";
						hasnum = true;
						break;
					}

				}
				if (!hasnum) {
					s = s.toUpperCase();
					s = removePunc(s);
					if ((s.length() < 2) && !s.equals("A") && !s.equals("I")) {
						s = "";
					}
				}

				if (!s.isBlank() && !raw.contains(s)) {
					raw.add(s);

				}

			}
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found or does not exist.");
			Scanner input = new Scanner(System.in);
			System.out.println("please enter a file name.");
			String s = input.nextLine();
			convertInputFile(s);
		}
		raw.sort(null);
	

		try {
			File text = new File("SubDictionary.txt");
			PrintWriter out = new PrintWriter(text);

			out.print("This sub-dictionary contains " + raw.size() + " entries.\n");
			for (int j = 0; j < arr.length; j++) {
				out.write("\n");
				out.println(arr[j] + "\n= =");

				while ((i < raw.size())) {
					if (arr[j] == raw.get(i).charAt(0)) {
						if (raw.get(i).equals("MC")) {
							out.println("MC²");

						} else {
							out.println(raw.get(i));

						}
						i++;
					} else {
						break;
					}

				}

			}

			out.close();
			System.out.println("File converted successfully and saved as SubDictionary.txt");
		}

		catch (FileNotFoundException e) {
			System.out.println("File could not be generated.");
		}

	}

	/**removes all punctuation and apostrophes from the entries
	 * @param s
	 * @return
	 */
	public String removePunc(String s) {
		String x = "’";
		if (s.contains(x)) {
			s = s.substring(0, s.length() - 2);
		}
		if (!s.equals("MC²")) {
			return s.replaceAll("[^a-zA-Z ]", "");
		}
		return s;

	}

}
