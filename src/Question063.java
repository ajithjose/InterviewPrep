
/*
 * Depth First Tree Traversals
 * ----------------------------
 * 
 * 1. Inorder 
 * 2. Preorder
 * 3. Postorder 
 * 
 */

class Node{
		Node left;
		Node right;
		int data;
		
		public Node(Node left, Node right, int data) {
			super();
			this.left = left;
			this.right = right;
			this.data = data;
		}
		
		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}	
		
}

public class Question063 {
	

	public void inorder(Node tree) {
		if(tree == null)
			return;
		
		inorder(tree.getLeft());
		System.out.print(tree.getData()+" ");
		inorder(tree.getRight());
		
	}

	public void postorder(Node tree) {
		if(tree == null)
			return;
		
		postorder(tree.getLeft());
		postorder(tree.getRight());
		System.out.print(tree.getData()+" ");
		
	}
	
	public void preorder(Node tree) {
		if(tree == null)
			return;

		System.out.print(tree.getData()+" ");
		preorder(tree.getLeft());
		preorder(tree.getRight());
		
	}

	public static void main(String[] args) {
		
		Question063 q = new Question063();
		
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n3 = new Node(3);
		Node n2 = new Node(n4, n5, 2);
		Node n1 = new Node(n2, n3, 1);
		
		q.inorder(n1);
		System.out.println();
		q.postorder(n1);
		System.out.println();
		q.preorder(n1);
	}

}

// Time Complexity - O(n)
// Space Complexity -  O(1) if we do not consider the recursive function call stack, otherwise O(n)