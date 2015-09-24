package cc150;

public class Q2_2KthToLast {
	static class Node {
		public Node next;
		public int data;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public void addLast(int d) {
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		public String toString() {
			Node n = this;
			String str = "";
			while (n.next != null) {
				str += String.valueOf(n.data) + "->";
				n = n.next;
			}
			// The last node
			str += String.valueOf(n.data);
			return str;
		}
	}
	
	public Node FindKthToLast(Node n, int k) {
		if (k <= 0) throw new NullPointerException("k should be larger than 0");
		for (int i = 1; i < k; i++) {
			n = n.next;
			if (n == null) throw new NullPointerException("total number of the elements in the list is less than k");
		}
		return n;
	}
	
	public static void main(String[] args) {
		Q2_2KthToLast test = new Q2_2KthToLast();
		Node n = new Node(1);
		for (int i = 0; i < 5; i++) {
			n.addLast(i+2);
		}
		
		n = test.FindKthToLast(n, 3);
		System.out.println(n.toString());
		
	}
}
