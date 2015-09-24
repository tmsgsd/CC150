package cc150;

import java.util.ArrayList;

public class Q3_3SetOfStacks {
	private class Stack {
		Node top;
		int N = 0;
		private Object stackpop() {
			if (top == null) return null;
			Object tmp = top.data;
			top = top.next;
			N--;
			return tmp;
		}
		
		private void stackpush(Object obj) {
			Node t = new Node(obj);
			t.next = top;
			top = t;
			N++;
		}
		
		private int stacksize() {
			return N;
		}
		
		private Object stackpeek() {
			return top.data;
		}
		
		private boolean isFull() {
			return N >= threshold;
		}
	}
	private int threshold = 5;			//capacity of each stack. if needed, this var can be public and user can decide its value
	private ArrayList<Stack> stacks = new ArrayList<Stack>();
	private int lastStackIndex = - 1;
	
	public Object pop() {										//if popAt() makes the last stack empty, remove it from set  
		while (stacks.get(lastStackIndex).stacksize() == 0) {	//then pop() should work on the last stack which is not empty
			stacks.remove(lastStackIndex);
			lastStackIndex--;
		}
		Object tmp = stacks.get(lastStackIndex).stackpop();
		if (stacks.get(lastStackIndex).stacksize() == 0) {
			stacks.remove(lastStackIndex);
			lastStackIndex--;
		}
		return tmp;
	}
	
	public Object popAt(int n) {
		if (stacks.get(n).stacksize() == 0) return null;
		else return stacks.get(n).stackpop();
	}
	public void push(Object obj) {
		if (stacks.isEmpty() || stacks.get(lastStackIndex).isFull()) {
			stacks.add(new Stack());
			lastStackIndex++;
		}
		stacks.get(lastStackIndex).stackpush(obj);
	}
	
	public static void main(String[] args) {
		Q3_3SetOfStacks test = new Q3_3SetOfStacks();
		for (int i = 0; i < 12; i++) {
			test.push(i);
		}
		System.out.println(test.pop());
		System.out.println(test.popAt(0));
		System.out.println(test.popAt(1));
		System.out.println(test.popAt(2));
		System.out.println(test.pop());
	}
	
}
