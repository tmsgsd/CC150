package cc150;

public class Q3_2StackWithMinFunction {
	static class Node {
		public Node next;
		public Integer nodeMin;
		public Integer data;
		public Node(Integer data) {
			this.data = data;
			this.next = null;
			this.nodeMin = Integer.MAX_VALUE;
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
	

	private Node top;
	
	public void push(Integer obj) {
		if (top == null) {
			top = new Node(obj);
			top.nodeMin = obj;
		} else {
			Node t = new Node(obj);
			t.nodeMin = Math.min(top.nodeMin, obj);	//top node's minimum is the minimum of last top node's minimum and obj
			t.next = top;
			top = t;
		}
	}
	
	public Integer pop() {
		if (top == null) return null;
		Integer tmp = top.data;
		top = top.next;
		return tmp;
	}
		
	public Integer peek() {
		return top.data;
	}
		
	public Integer min() {
		if (top == null) return Integer.MAX_VALUE;
		return top.nodeMin;
	}

	
	public static void main(String[] args) {
		Q3_2StackWithMinFunction test = new Q3_2StackWithMinFunction();
		test.push(5);
		System.out.println(test.min());
		test.push(6);
		System.out.println(test.min());
		test.push(3);
		System.out.println(test.min());
		test.push(7);
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
		test.pop();
		System.out.println(test.min());
	}
	
}
