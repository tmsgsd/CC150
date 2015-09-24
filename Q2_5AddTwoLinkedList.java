package cc150;

public class Q2_5AddTwoLinkedList {
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
	
	//private Node sum = null;
	//private int carry = 0;
	public Node AddReverse(Node l1, Node l2, int c) {
		if (l1 == null && l2 == null && c == 0) return null;
		int data = (l1 == null ? 0 : l1.data) + (l2 == null ? 0 : l2.data) + c;
		Node sum = new Node(data % 10);
		if (l1 != null || l2 != null || data >= 10) {
			Node n = AddReverse(l1 == null ? null : l1.next, l2 == null ? null : l2.next, data / 10);
			sum.next = n;
		}
		
		return sum;
	}
	//A simple way to solve follow up question is reversing the forwarding order than using the AddReversive method.
	
	//Another way is getting the lengths of both list and add them node by node to get a new list. 
	//And use an array to keep track of the carryOn number then add them to each node of the new list.
	
	public static void main(String[] args) {
		Q2_5AddTwoLinkedList test = new Q2_5AddTwoLinkedList();
		Node l1 = new Node(7);
		l1.addLast(1);
		l1.addLast(7);
		l1.addLast(1);
		Node l2 = new Node(5);
		l2.addLast(9);
		l2.addLast(2);
		//test.AddReverse(l1, l2, 0);
		System.out.println(test.AddReverse(l1, l2, 0).toString());
	}
}
