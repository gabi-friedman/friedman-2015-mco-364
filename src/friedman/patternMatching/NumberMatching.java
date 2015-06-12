package friedman.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberMatching {
	
	public static void main(String[] args){
		
		//simple example from JavaDocs
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaaab");
		boolean b = m.matches();
		
		System.out.println(b);
		
		//Pattern p1 = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");
		Pattern p2 = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}");
		String text = "hello how r u, 1-123-456-7890. thats great"+"Otherwise 1 718 222 2222";
		Matcher m1 = p2.matcher(text);
		boolean b1 = m1.matches();
		
		System.out.println(b1);
		
		while (m1.find()){
			String number = text.substring(m1.start(), m1.end());
			String formatted = number.replaceAll("(\\s)", "-");
			System.out.println(number);
		}
		
		
	}

}
