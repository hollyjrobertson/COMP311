package hw3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Node<T extends Comparable<T>> {

	public T data;
	public Node<T> left;
	public Node<T> right;
	
	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public String toString() {
		return data.toString();
	}
}
class BinaryTree <T extends Comparable<T>> {
	Node<T> root;
	
	public void insert(T node) {
		Node<T> current = new Node<T>(node);
		
		//Only need to compare once
		//If equal = 0
		//If less than < 0
		//If greater than > 0
		int result = node.compareTo(root.data);
		
		//If root == null than current becomes root
		if (root == null) {
			root = current;
		} else {

			//If node and root are equal, return 
			//Can’t duplicate in a binary tree
			if (result == 0) {
				return;
				
			//If node is less than root, add to left subtree
			} else if (result < 0) {
				
				//Set the value of root to the value in //node
				//Then root becomes the left node of root
				root.data = node;
				root = root.left;
			
				//If root is null than the root.left //becomes the current
				if (root == null) {
					root.left = current;
					return;
				}
			//Node is greater than root
			//Same method for right subtree as it was for //left subtree
			} else {
				root.data = node;
				root = root.right;
			
				if (root == null) {
					root.right = current;
					return;
				}
			}
		}
	}
	
	public void printLevelOrder(Node<T> root) {
		Queue<Node<T>> queue = new LinkedList<Node<T>>();
		
		if (root == null) {
			System.out.println("Tree is empty");
		}
		
		//initialize the height and set first value
		queue.add(root);
		
		//Breaks at base case when count(level of tree) is 0
		while(true) {
			//Sets count equal to the height
			int count = queue.size();
			
			//Base case
			if (count == 0) {
				break;
			}
			
			//While count is > 0 a new instance of Node is set
			//to the value of the first element in queue
			//Printed then removed
			while (count > 0) {
				Node<T> node = queue.peek();
				System.out.println(node.data + " | ");
				queue.remove();
				
				//Test to see if left of the node is null
				//If false, adds the left to the queue
				if (node.left != null) {
					queue.add(node.left);
				}
				else if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}
	}
	
	public int sum(Node<T> root) {
		ArrayList<Integer> array = new ArrayList<>();
		int result = 0; 
		boolean value = true;
		
		if (root == null || ((int) root.data == 0)) {
			return 0;
		}
		
		while (value) {
			if (root == null) {
				value = false;
			} else if (root.left != null) {
				array.add((int) root.left.data);
			} else {
				array.add((int)root.right.data);
			}
		}
		
		for (int i : array) {
			result = result + i;
		}
		
		
		return result;
	}
}
