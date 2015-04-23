/*
 * 
Find the node with minimum value in a Binary Search Tree
---------------------------------------------------------

 */
public class Question070 {

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(14);
		Node n3 = new Node(4);
		Node n4 = new Node(22);
		Node n5 = new Node(n1, n2, 12);
		Node n6 = new Node(n3, n5, 8);
		Node n7 = new Node(n6, n4, 20);
		
		minValue(n7);

	}

	private static int minValue(Node node) {
		while(node.getLeft()!=null){
			node = node.getLeft();
		}
		return node.getData();		
	}

}

// Time Complexity - O(n) worst case happens for skewed trees
