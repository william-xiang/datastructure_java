
public class LinkedList {
	private Node head;
	
	/**
	 * Linked list node
	 * @author william
	 *
	 */
	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	
	/**
	 * add one element to the end of the linked list
	 * time complexity is O(n)
	 * @param value
	 */
	public void append(int value) {
		// if the linked list is empty, add this as the head of the linked list
		if (head == null) {
			head = new Node(value);
			return;
		}
		
		// to get the last element
		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		
		// add the new node to the end of the list
		current.next = new Node(value);
	}
	
	/**
	 * prepend a new element to the list
	 * time complexity is O(1)
	 * @param value
	 */
	public void prepend(int value) {
		Node newHead = new Node(value);
		newHead.next = head;
		head = newHead;
	}
	
	/**
	 * delete the first element with the same value
	 * @param value
	 */
	public void deleteWithValue(int value) {
		if (head == null) {
			return;
		}
		if (head.value == value) {
			head = head.next;
		}
		
		Node current = head;
		while (current.next != null) {
			if (current.next.value == value) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
}
