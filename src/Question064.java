/* 
 * Calculate Size of a Tree
 * -------------------------
 * 
 * Size of a tree is the number of elements present in the tree.
 * 
 * Size of a tree = Size of left subtree + 1 + Size of right subtree
 * 
 */


public class Question064 {

	int size(Node tree){
		
		if(tree == null){
			return 0;
		}
		
		return size(tree.getLeft()) + size(tree.getRight()) + 1;
	}
	
	public static void main(String[] args) {

		Question064 q = new Question064();
		
		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n3 = new Node(3);
		Node n2 = new Node(n4, n5, 2);
		Node n1 = new Node(n2, n3, 1);
		
		int size = q.size(n1);
		System.out.println("Size of tree :: "+size);
		
	}

}

// Time complexity - O(n) 
// Space complexity - O(1) 
// Similar to tree traversals