package filter;

import existenceTrie.TST;

public class Filter {
	
	private TST tst;
	
	public Filter() {
		this.tst = new TST();
		load();
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
	
	private void load() {
		String[] strings = BadWords.bad_words.split(",");
		
		for(String s : strings) {
			String current = s;
			current = current.replace("\n", "").replace("\r", "");
			current += existenceTrie.TST.END;
			tst.insert(current);
			
		}
	}
	
	

}
