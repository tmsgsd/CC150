package cc150;

public class Q1_4ReplaceSpace {
	private int lastAlphabet = 0, size = 0;
	
	public String replace(String s) {
		StringBuffer sb = new StringBuffer();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] != ' ') lastAlphabet = i;
		}
		size = lastAlphabet + 1;
		for (int i = 0; i <= lastAlphabet; i++) {
			if (c[i] == ' ') {
				size--;
				if (i > 0 && c[i - 1] != ' ') {
					sb.append("%20");
					size++;
				}
			}
			else sb.append(c[i]);
		}
		return sb.toString();
	}
	
	public int realSize() {
		return size;
	}
	
	public static void main(String[] args) {
		Q1_4ReplaceSpace test = new Q1_4ReplaceSpace();
		System.out.println (test.replace(" Mr  John  Smith      ") + ", " + test.realSize());
	}
}
