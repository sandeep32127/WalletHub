package com.wallethub;

public class StringRecursuin {

	 static String replaceCharacter(String str,
			char c1, char c2)
	{
		// Base Case 
		// If the string is empty 
		if (str.length() == 0)
		{ 
			return str; 
		} 
		char x=str.charAt(0);
		// If the character at starting 
		// of the given string is equal 
		// to c1, replace it with c2 
		if (str.charAt(0) == c1) 
		{ 
			x=c2;
			str = c2+str.substring(1); 
		} 

		// Getting the answer from recursion 
		// for the smaller problem 
		return x+replaceCharacter(str.substring(1), 
				c1, c2); 
	}

	//Driver Code
	public static void main(String[] args)
	{

		// Given string
		String str = "abaca";
		char c1 = 'a';
		char c2 = 'x';

		// Function call
		System.out.println(replaceCharacter(str, c1, c2));
		
		String str2 = "a";
		System.out.println(str2.substring(1));
	}
}


