package cc150;

public class Q3_6SortedStack {
	static class Node {
		public Node next;
		public Integer data;
		public Node(Integer data) {
			this.data = data;
			this.next = null;
		}
		
		public void addLast(Integer d) {
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
	static class Stack {
		Node top;
		int N = 0;
		public Integer pop() {
			if (top == null) return null;
			Integer tmp = top.data;
			top = top.next;
			N--;
			return tmp;
		}
		
		public void push(Integer obj) {
			Node t = new Node(obj);
			t.next = top;
			top = t;
			N++;
		}
		public boolean isEmpty() {
			return N == 0;
		}
		
		public Integer peek() {
			return top.data;
		}
	}
	public Stack sort(Stack s) {
		Stack buffer = new Stack();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!buffer.isEmpty() && tmp < buffer.peek()) {
				s.push(buffer.pop());
			}
			buffer.push(tmp);
		}
		return buffer;
	}
	
	public static void main(String[] args) {
		Q3_6SortedStack test = new Q3_6SortedStack();
		Stack s = new Stack();
		s.push(3);
		s.push(7);
		s.push(9);
		s.push(5);
		s.push(2);
		s.push(1);
		
		Stack r = test.sort(s);
		while (!r.isEmpty()) {
			System.out.println(r.pop());
		}
	}
}
