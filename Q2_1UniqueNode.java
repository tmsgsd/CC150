package cc150;

import java.util.HashSet;
import java.util.Set;

public class Q2_1UniqueNode {
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
	
	public void RmvDuplicatesWithSet(Node n) {
		if (n == null || n.next == null) throw new NullPointerException();
		Set<Integer> uniqueSet = new HashSet<Integer>();
		Node prev = n;
		while (n != null) {
			if (uniqueSet.contains(n.data)) {
				prev.next = n.next;
			} else {
				uniqueSet.add(n.data);
				prev = n;
			}
			n = n.next;
		}
	}
	
	public void RmvDuplicatesWithPointer(Node n) {
		if (n == null || n.next == null) throw new NullPointerException();
		Node curr = n;
		while (curr != null) {
			Node prev = curr;
			Node runner = curr.next;
			while (runner != null) {
				if (curr.data == runner.data) {
					prev.next = runner.next;
				} else {
					prev = runner;
				}
				runner = runner.next;
			}
			curr = curr.next;
		}
		
	}
	
	
	public static void main(String args[]) {
		Q2_1UniqueNode test = new Q2_1UniqueNode();
		Node n = new Node(1);
		// n.addLast(2);
		n.addLast(2);
		n.addLast(1);
		n.addLast(2);

		System.out.println("Original                 : " + n.toString());
		test.RmvDuplicatesWithPointer(n);
		System.out.println("After deleting duplicates: " + n.toString());
	}
	
	
}
