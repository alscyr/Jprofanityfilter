package filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import existenceTrie.TST;

public class Filter {
	
	private String filename;
	private TST tst;
	
	public Filter(String filename) {
		this.filename = filename;
		this.tst = new TST();
		load(filename);
	}
	
	public boolean isSentenceSafe(String sentence) {
		String[] words = sentence.split(" ");
		
		for (String word : words) {
			String current = word + "$";
			if(tst.exists(current)) {
				return false;
			}
		}
		
		return true;
	}
	
	private void load(String filename) {
		try {
			String text = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
			String[] strings = text.split(",");
			
			for(String s : strings) {
				String current = s;
				current = current.replace("\n", "").replace("\r", "");
				current += existenceTrie.TST.END;
				tst.insert(current);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
