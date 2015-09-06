package cc150;

import java.util.Arrays;

public class Q1_3Anagram {
	public boolean isPermutation (String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(c1.length != c2.length) return false;
		else for (int i = 0; i< c1.length; i++) {
			if (c1[i] != c2[i]) return false;
		}
		return true;
	}
	
	public static void main(String [] args) {
		Q1_3Anagram test = new Q1_3Anagram();
		System.out.println(test.isPermutation("abcd", "acbd"));
		System.out.println(test.isPermutation("abcd", "acbbd"));
	}
}
