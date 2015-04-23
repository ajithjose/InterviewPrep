/*
 * Convert a tree into its mirror tree
 * ------------------------------------
 * 
 * Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.
 * 
 */

public class Question067 {

	public void mirror(Node tree){
		
		if(tree == null){
			return;
		}
		
		mirror(tree.getLeft());
		mirror(tree.getRight());
		
		Node temp = tree.getLeft();
		tree.setLeft(tree.getRight());
		tree.setRight(temp);
	}
	
	public static void main(String[] args) {

		Question067 q67 = new Question067();
		Question063 q63 = new Question063();
		
		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n3 = new Node(3);
		Node n2 = new Node(n4, n5, 2);
		Node n1 = new Node(n2, n3, 1);
		
		System.out.println("Input Tree :: ");		
		q63.inorder(n1);
		
		System.out.println();
		
		q67.mirror(n1);
		
		System.out.println("Mirror Tree :: ");		
		q63.inorder(n1);
		
	}

}

// Time Complexity - O(n) // Similar to tree traversals