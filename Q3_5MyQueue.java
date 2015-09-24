package cc150;

public class Q3_5MyQueue {
	Stack stack1 = new Stack();
	Stack stack2 = new Stack();
	public void enqueue(Object obj) {
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(obj);
	}
	
	public Object dequeue() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public Object peek() {
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.peek();
	}
	public static void main(String[] args) {
		Q3_5MyQueue test = new Q3_5MyQueue();
		for (int i = 0; i < 5; i++) {
			test.enqueue(i);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(test.dequeue());
		}
		
	}
	
}
