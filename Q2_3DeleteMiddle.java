package cc150;

public class Q2_3DeleteMiddle {
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
	
	public void DeleteMiddle(Node n) {
		if(n == null || n.next == null) throw new NullPointerException();
		n.data = n.next.data;
		n.next = n.next.next;
	}
	
	public static void main(String[] args) {
		
	}
}
