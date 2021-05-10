//Nicholas Justus
//4/25/21
package green.eggs.and.ham;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class mainClass {
	final static String FILEIN = "Data-A.txt"; 
	final static String FILEOUT = "output.txt";
	public static void main(String[] args) throws IOException {
		//Readers
		FileReader reader = new FileReader(FILEIN);
		FileWriter writer = new FileWriter(FILEOUT, true);
		BufferedReader buffer = new BufferedReader(reader);
		
		//Patterns
		Pattern patternSam = Pattern.compile("\\bSam", Pattern.CASE_INSENSITIVE);
		Pattern patternGreen = Pattern.compile("\\bGreen", Pattern.CASE_INSENSITIVE);
		Pattern patternHam = Pattern.compile("\\bHam", Pattern.CASE_INSENSITIVE);
		
		//Logic
		for (String line = buffer.readLine(); line != null; line = buffer.readLine()){
			if (patternSam.matcher(line).find()||patternGreen.matcher(line).find()||patternHam.matcher(line).find()){
				writer.write(line.replaceAll("Sam", "Pam")
						.replaceAll("sam", "pam")
						.replaceAll("Green", "Pink")
						.replaceAll("green", "pink")
						.replaceAll("Ham", "Spam")
						.replaceAll("ham", "spam")
						+ "\n");
				System.out.println("Matched");
			}
			else {
				writer.write(line + "\n");
			}
		}
		reader.close();
		writer.close();
		buffer.close();
	}
}