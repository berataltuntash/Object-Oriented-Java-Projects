package FileIO;

import java.util.ArrayList;
import java.util.StringTokenizer;

class EnhancedStringTokenizer extends StringTokenizer{
	ArrayList<String> a = new ArrayList<String>(); 
	public EnhancedStringTokenizer(String string, String delimiter) {
		super(string,delimiter);
	}

	public String[] getTokens() {
		while (hasMoreTokens()) {			
			a.add(nextToken());
			}
		return a.toArray(new String[a.size()]);
	}
	
}
