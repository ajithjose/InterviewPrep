/*
 * 
Level Order Traversal 
----------------------

 */
public class Question071 {

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(14);
		Node n3 = new Node(4);
		Node n4 = new Node(22);
		Node n5 = new Node(n1, n2, 12);
		Node n6 = new Node(n3, n5, 8);
		Node n7 = new Node(n6, n4, 20);
		
		levelOrderTraversal(n7);
	}

	private static void levelOrderTraversal(Node root) {
		int height = Question066.height(root);
		for(int i=1;i<=height;i++){
			printLevel(root, i);
		}
		
	}

	private static void printLevel(Node root, int h) {
		if(root == null) return;
		
		if(h==1){
			System.out.println(root.getData()+" ");
		}else{
			printLevel(root.getLeft(), h-1);
			printLevel(root.getRight(), h-1);
		}
		
	}

}
