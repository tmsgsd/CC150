package cc150;

import java.util.HashMap;

public class Q1_1UniqueChar {
	public boolean isAllUnique (String s) {
    	HashMap<Character, Integer> smap = new HashMap<Character, Integer>();
    	for (Character c : s.toCharArray()) {
    		if (smap.containsKey(c)) return false;
    		else smap.put(c, 1);
    	}
    	return true;
    }
    
    public static void main(String [] args) {
    	Question1_1 test = new Question1_1();
    	String s1 = "abcd";
    	String s2 = "aabcd";
    	System.out.println(test.isAllUnique(s1));
    	System.out.println(test.isAllUnique(s2));
    	
    }
}
