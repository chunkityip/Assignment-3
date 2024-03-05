import io.github.pixee.security.BoundedLineReader;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class CountWordInstances {

	public static void main(String[] args) throws Exception {

		Path path = Paths.get(System.getProperty("user.dir")).resolve("September.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		
		HashMap<String, Integer> frequency = new HashMap<>();
	
		String alex = BoundedLineReader.readLine(reader, 5_000_000);
		while(alex != null) {
			
			
			if(!alex.trim().equals("")) {
				String [] words = alex.split(" ");
				
				for(String word : words) {
					if(word == null || word.trim().equals("")) {
						continue;
					}
					String processed = word.toLowerCase();
					processed = processed.replace(",", "");
					
					if(frequency.containsKey(processed)) {
						frequency.put(processed, 
								frequency.get(processed) + 1);
					} else {
						frequency.put(processed, 1);
					}
				}
			}
			
			alex = BoundedLineReader.readLine(reader, 5_000_000);
		}
		
		
		System.out.println(frequency);
		
		int mostFrequentlyUsed = 0;
		String theWord = null;
		
		for(String word : frequency.keySet()) {
			Integer theVal = frequency.get(word);
			if(theVal > mostFrequentlyUsed) {
				mostFrequentlyUsed = theVal;
				theWord = word;
			}
		}
		System.out.println();
				
	}

}
