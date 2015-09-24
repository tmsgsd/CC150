package cc150;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class Q2_6CircularList {
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
	
	public Node FindHeadNodeOfLoop(Node l) {
		if (l == null) throw new NoSuchElementException();
		HashSet<Node> nodeSet = new HashSet<Node>();
		while (l != null) {
			if (nodeSet.contains(l)) return l;
			else {
				nodeSet.add(l);
				l = l.next;
			}
		}
		System.out.println("There is no loop in this list");
		return null;
	}
	
	public static void main(String[] args) {
		Q2_6CircularList test = new Q2_6CircularList();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n1;
		System.out.println(test.FindHeadNodeOfLoop(n1).data);
		
	}
}
