import java.util.Scanner;

public class ReverseStringIterative {

	
	void stringReverse() 
	{ 
		String str = "geeksforgeeks"; 
		int length = str.length(); 
		StringBuffer revString = new StringBuffer(); 
		for (int i = length - 1; 
				i >= 0; i--) 
		{ 
			revString.append(str.charAt(i)); 
		} 
		System.out.println(revString); 
	} 
	
	public static void main(String[] args) {
		ReverseStringIterative s= new ReverseStringIterative(); 
		s.stringReverse();

	}

}

