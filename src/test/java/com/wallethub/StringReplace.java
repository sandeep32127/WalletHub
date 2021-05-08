package com.wallethub;

public class StringReplace {
	
	static String replaceCharacter(String str,String replaceGet, String replace)
	{
		String replace2 = "";
		if(str.length() == 0) {
			return str;
		}
		if (str.contains(replaceGet)) {
			replace2 = str.replace(replaceGet, replace);
		}else return str;
		return replaceCharacter(replace2, replaceGet, replace);
		
	}


	public static void main(String[] args) {
		// Given string
		String str = "abbccd";
		String replaceGet = "ab";
		String replace = "bba";
		
		// Function call
		System.out.println(replaceCharacter(str,replaceGet,replace));

		String str2 = "a";
		System.out.println(str2.substring(1));

	}

}
