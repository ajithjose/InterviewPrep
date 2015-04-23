/*
 * 
Lowest Common Ancestor in a Binary Search Tree
-----------------------------------------------

Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants.

 */

public class Question069 {

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(14);
		Node n3 = new Node(4);
		Node n4 = new Node(22);
		Node n5 = new Node(n1, n2, 12);
		Node n6 = new Node(n3, n5, 8);
		Node n7 = new Node(n6, n4, 20);
		
		Node lcaNode = lca(n7, n1, n2);
		System.out.println("Least Common Ancestor of "+n1.getData()+" and "+n2.getData()+" is "+lcaNode.getData());
	}

	private static Node lca(Node root, Node n1, Node n2) {
		if(root == null) return null;
		
		if(root.getData() > n1.getData() && root.getData() > n2.getData()){
			return lca(root.getLeft(), n1, n2);
		}
		
		if(root.getData() < n1.getData() && root.getData() < n2.getData()){
			return lca(root.getRight(), n1, n2);
		}
		
		return root;
	}

}
