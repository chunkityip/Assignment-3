import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class CountWordInstances {

	public static void main(String[] args) throws Exception {

		Path path = Paths.get(System.getProperty("user.dir")).resolve("September.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		
		HashMap<String, Integer> frequency = new HashMap<>();
	
		String alex = reader.readLine();
		while(alex != null) {
			
			
			if(!"".equals(alex.trim())) {
				String [] words = alex.split(" ");
				
				for(String word : words) {
					if(word == null || "".equals(word.trim())) {
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
			
			alex = reader.readLine();
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
