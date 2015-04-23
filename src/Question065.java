
/*
 * Determine if two trees are Identical
 * -------------------------------------
 * 
 * Two trees are identical when they have same data and arrangement of data is also same.
 * To identify if two trees are identical, we need to traverse both trees simultaneously, 
 * and while traversing we need to compare data and children of the trees.
 * 
 */
public class Question065 {


	private boolean isIdentical(Node tree1, Node tree2) {
		if(tree1 == null && tree2 == null){
			return true;
		}
		
		if(tree1 != null && tree2 != null){
			return (tree1.getData() == tree2.getData() 
					 && isIdentical(tree1.getLeft(), tree2.getLeft())
					 && isIdentical(tree1.getRight(), tree2.getRight()));
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		
		Node root1 = new Node(1);
		root1.setLeft(new Node(2));
		root1.setRight(new Node(3));
		root1.getLeft().setLeft(new Node(4));
		root1.getLeft().setRight(new Node(5));
		
		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n3 = new Node(3);
		Node n2 = new Node(n4, n5, 2);
		Node root2 = new Node(n2, n3, 1);
		
		Question065 q = new Question065();
		if(q.isIdentical(root1, root2)){
			System.out.println("The two trees are identical.");
		}else{
			System.out.println("The two trees are not identical.");
		}
	}


}

// Time complexity of two trees of size m and n - O(m) where m<n
