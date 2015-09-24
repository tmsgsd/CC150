package cc150;

public class Q2_4PatitionLinkedList {
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
	
	public Node Patition(Node n, int x) {
		Node left = null;
		Node right = null;
		Node lefthead = null;
		Node righthead = null;
		while (n != null) {
			if (n.data < x) {			//put nodes smaller than x into the new linked list left
				if (left == null) {
					left = new Node(n.data);
					lefthead = left;
					//System.out.println(lefthead.toString());
				}
				else {
					left.next = new Node(n.data);
					left = left.next; 
				}
			}
			if (n.data >= x) {			//put nodes larger than x into the new linked list right
				if (right == null) {
					right = new Node(n.data);
					righthead = right;
					//System.out.println(righthead.toString());
				}
				else {
					right.next = new Node(n.data);
					right = right.next;
				}
			}
			n = n.next;
		}
		
		if (left != null) {				//connect the tail of the left list with the head of right list
			left.next = righthead;
			return lefthead;
		} else {
			return righthead;
		}
	}
	
	public static void main(String[] args) {
		Q2_4PatitionLinkedList test = new Q2_4PatitionLinkedList();
		Node n = new Node(1);
		for (int i = 5; i > 0; i--) {
			n.addLast(i+2);
		}
		
		n = test.Patition(n, 5);
		System.out.println(n.toString());
	}
}
