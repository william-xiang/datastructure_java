
public class Stack {
	private Node top;
	
	private class Node {
		private int value;
		private Node next;
		
		private Node(int value) {
			this.value = value;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return top.value;
	}
	
	public void push(int value) {
		Node node = new Node(value);
		node.next = top;
		top = node;
	}
	
	public int remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		int value = top.value;
		top = top.next;
		
		return value;
	}
}
