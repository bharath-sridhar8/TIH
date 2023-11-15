package medium;

import java.util.LinkedList;

public class MinStack {

	LinkedList<Integer> stack;
	LinkedList<Integer> minStack;

	public MinStack() {
		stack = new LinkedList<>();
		minStack = new LinkedList<>();
	}

	public void push(int val) {
		stack.addLast(val);
		if (minStack.isEmpty() || minStack.peekLast() >= val) {
			minStack.addLast(val);
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;
		int last = stack.removeLast();
		if (minStack.peekLast() != null && minStack.peekLast() == last) {
			minStack.removeLast();
		}
	}

	public int top() {
		return stack.peekLast() != null ? stack.peekLast() : -1;
	}

	public int getMin() {
		return minStack.peekLast() != null ? minStack.peekLast() : -1;
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
	
}
