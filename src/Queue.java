
public class Queue {
	private Node head;
	private Node tail;
	
	private class Node {
		private int value;
		private Node next;
		
		private Node(int value) {
			this.value = value;
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return head.value;
	}
	
	public void add(int value) {
		Node node = new Node(value);
		if (head == null && tail == null) {
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
	}
	
	public int remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		int value = head.value;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		
		return value;
	}
}
