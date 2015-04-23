
/*
 * Find Height of a Tree
 * ----------------------
 * 
 * Algorithm
 * ---------
 * 
 * Recursively calculate height of left and right subtrees of a node and assign height 
 * to the node as max of the heights of two children plus 1. 
 * 
 */

public class Question066 {

	public static int height(Node tree){
		if(tree == null){
			return 0;
		}
		
		int leftHeight = height(tree.getLeft());
		int rightHeight = height(tree.getRight());
		
		if(leftHeight>rightHeight){
			return leftHeight+1;
		}else{
			return rightHeight+1;
		}
	}
	
	public static void main(String[] args) {

		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n3 = new Node(3);
		Node n2 = new Node(n4, n5, 2);
		Node n1 = new Node(n2, n3, 1);
		
		System.out.println("Height of tree :: "+height(n1));
	}

}

// Time Complexity - O(n)