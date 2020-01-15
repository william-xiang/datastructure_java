import java.util.Deque;

public class BinaryTree {
	private class Node {
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
		
		public boolean isLeaf() {
			return left == null && right == null;
		}
	}
	
	// root of the tree
	private Node root;
	
	// add a new node to the tree
	private Node addRecursive(Node current, int value) {
		// base case: when current is null
		if (current == null) {
			return new Node(value);
		}
		if (value <= current.value) {
			current.left = addRecursive(current, value);
		} else {
			current.right = addRecursive(current, value);
		}
		
		return current;
	}
	
	public void add(int value) {
		root = addRecursive(root, value);
	}
	
	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (current.value == value) {
			return true;
		}
		if (current.value < value) {
			return containsNodeRecursive(current.left, value);
		} else {
			return containsNodeRecursive(current.right, value);
		}
	}
	
	public boolean contains(int value) {
		return containsNodeRecursive(root, value);
	}
	
	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			return null;
		}
		if (current.value == value) {
			// when the current is a leaf node
			if (current.isLeaf()) {
				return null;
			}
			// when the current has exactly one node
			if (current.left == null) {
				return current.right;
			}
			if (current.right == null) {
				return current.left;
			}
			// when the current has two nodes, have to rearrange the tree
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
		}
		if (current.value < value) {
			current.left = deleteRecursive(current.left, value);
		} else {
			current.right = deleteRecursive(current.right, value);
		}
		
		return current;
	}
	
	private int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}
	
	public void delete(int value) {
		root = deleteRecursive(root, value);
	}
	
	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}
	
	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value);
		}
	}
	
	public void breadthFirstOrder() {
		if (root == null) {
			return;
		}
		
		java.util.Queue<Node> nodes = new java.util.LinkedList<>();
		nodes.add(root);
		
		while (!nodes.isEmpty()) {
			Node node = nodes.remove();
			
			System.out.print(" " + node.value);
			
			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
	}
}
