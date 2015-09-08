package cc150;

public class Q1_8IsRotation {
	public boolean isRotation(String str, String target) {
		if (str == null || target == null) return false;
		if (str.length() != target.length()) return false;
		return isSubstring (str, target + target);
	}
	
	private boolean isSubstring(String str, String target) {
        if (str.equals(target))
            return true;
        else if (str.length() > target.length())
            return false;
        else
            return (isSubstring(str, target.substring(1, target.length())))
                    || (isSubstring(str,
                            target.substring(0, target.length() - 1)));
    }
	
	public static void main(String[] args) {
		Q1_8IsRotation test = new Q1_8IsRotation();
		System.out.println(test.isRotation("waterbottle", "erbottlewat"));
	}
}
