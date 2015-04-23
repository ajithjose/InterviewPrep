/*
 * 
Spiral Level Order Traversal
-----------------------------


 */
public class Question072 {

	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(14);
		Node n3 = new Node(4);
		Node n4 = new Node(22);
		Node n5 = new Node(n1, n2, 12);
		Node n6 = new Node(n3, n5, 8);
		Node n7 = new Node(n6, n4, 20);
		
		spiralLevelOrderTraversal(n7);
	}

	private static void spiralLevelOrderTraversal(Node root) {
		int height = Question066.height(root);
		boolean flag = false;
		for(int i=1;i<=height;i++){
			printLevel(root, i, flag);
			flag = !flag;
		}
		
	}

	private static void printLevel(Node root, int h, boolean flag) {
		if(root == null) return;
		
		if(h==1){
			System.out.println(root.getData()+" ");
		}else{
			if(!flag){
				printLevel(root.getLeft(), h-1, flag);
				printLevel(root.getRight(), h-1, flag);
			}else{
				printLevel(root.getRight(), h-1, flag);
				printLevel(root.getLeft(), h-1, flag);
			}
			
		}
		
	}

}
