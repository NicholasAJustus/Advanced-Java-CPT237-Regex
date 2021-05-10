//Nicholas Justus
//4/25/21
package html.links;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainClass {
	final static String FILEIN = "Data-C.txt"; 
	final static String FILEOUT = "output.txt";
	public static void main(String[] args) throws IOException {
		//Readers
		FileReader reader = new FileReader(FILEIN);
		FileWriter writer = new FileWriter(FILEOUT, true);
		BufferedReader buffer = new BufferedReader(reader);
		
		//Patterns
		Pattern patternA = Pattern.compile("(?<=href=\").*?(?=\")");
		
		//Logic
		for (String line = buffer.readLine(); line != null; line = buffer.readLine()){
			Matcher id = patternA.matcher(line);
			if (!line.contains("link")&&!line.contains("<!--")){
				while (id.find()){
					if (!id.group().equals("#")) {
						writer.write( id.group() + "\n");
						System.out.println("Matched " + id.group());
					}
				}
			}
		}
		reader.close();
		writer.close();
		buffer.close();
	}
}