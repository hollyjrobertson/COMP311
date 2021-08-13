### [HW3](https://github.com/hollyjrobertson/COMP311/tree/master/hw3 "HW3")
  #### Problem 1:
  Write a O(n) method printLevelOrder() that prints the nodes of a binary tree in level-order. That is, the method should print the root, then   
  the nodes at depth 1, followed by the nodes at depth 2, and so on.  Your algorithm should begin by putting the tree root on an initially   
  empty queue. Then dequeue a node, print its value, and enqueue its left and right children (if they exist). Repeat until the queue is empty.
  ```java
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
				//Same for right node
				else if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}
	}
```
