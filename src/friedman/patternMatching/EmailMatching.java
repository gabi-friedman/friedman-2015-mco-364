package friedman.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatching {
	
	public static void main(String[] args){
		
		
		Pattern email = Pattern.compile("\\S+?@\\S+?\\.\\S+");
		Matcher match = email.matcher("3@glmm");
		boolean x = match.matches();
		System.out.println("matches email: "+x);
		
	}

}
