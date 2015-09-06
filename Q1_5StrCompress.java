package cc150;


public class Q1_5StrCompress {
	public String compress(String s) {
		if (s == null) throw new NullPointerException();
		char [] c = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		int n = 0;						//number of the same alphabet
		for (int i = 0; i < c.length; i++) {
			if (i == 0) {
				sb.append(c[i]);
				n++;
			} else {
				if (c[i] == c[i-1]) {
					n++;
				} else {
					sb.append(n);
					sb.append(c[i]);
					n = 1;
				}
			}
		}
		sb.append(n);
		
		
		
		String x = sb.toString();
		if (x.length() < s.length()) return x;
		else return s;
	}
	
	public static void main(String[] args) {
		Q1_5StrCompress test = new Q1_5StrCompress();
		System.out.println(test.compress("aabcccccaaa"));
	}
	
	
}
