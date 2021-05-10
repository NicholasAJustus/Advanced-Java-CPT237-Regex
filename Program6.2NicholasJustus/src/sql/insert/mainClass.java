//Nicholas Justus
//4/25/21
package sql.insert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainClass {
	final static String FILEIN = "Data-B.txt"; 
	final static String FILEOUT = "output.txt";
	public static void main(String[] args) throws IOException {
		//Readers
		FileReader reader = new FileReader(FILEIN);
		FileWriter writer = new FileWriter(FILEOUT, true);
		BufferedReader buffer = new BufferedReader(reader);
		
		//Patterns
		Pattern patternId = Pattern.compile("(?<=id=).*?(?=,)");
		Pattern patternName = Pattern.compile("(?<=cn=).*?(?=,)");
		Pattern patternCity = Pattern.compile("(?<=city=).*", Pattern.CASE_INSENSITIVE);
		
		//Logic
		for (String line = buffer.readLine(); line != null; line = buffer.readLine()){
			Matcher id = patternId.matcher(line);
			Matcher name = patternName.matcher(line);
			Matcher city = patternCity.matcher(line);
			if (id.find()&&name.find()&&city.find()){
				writer.write("INSERT INTO employee (id, name, city) VALUES (" + 
						id.group() + ", " +
						"\"" + name.group() + "\", " +
						"\"" + city.group() + "\"" +
						")\n");
				System.out.println("Matched");
			}
		}
		reader.close();
		writer.close();
		buffer.close();
	}
}