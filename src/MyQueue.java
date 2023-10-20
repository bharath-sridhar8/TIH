import java.util.LinkedList;

public class MyQueue {
	
	LinkedList<Integer> stack1;
	LinkedList<Integer> stack2;

	public MyQueue() {
		stack1 = new LinkedList<>();
		stack2 = new LinkedList<>();
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		 MyQueue obj = new MyQueue();
	  obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
		obj.push(4);
		obj.push(5);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
		obj.push(6);
	}

	public void push(int x) {
		if (stack1.isEmpty() && !stack2.isEmpty()) {
			while (!stack2.isEmpty())
				stack1.push(stack2.pop());
		}
		stack1.push(x);
	}

	public int pop() {
		populateStack2();
		if (!stack2.isEmpty())
			return stack2.pop();
		return -1;
	}

	public int peek() {
		populateStack2();
		if (!stack2.isEmpty()) 
			return stack2.peek();
		return -1;
	}

	private void populateStack2() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}

	public boolean empty() {
		return stack2.isEmpty() && stack1.isEmpty();
	}
}