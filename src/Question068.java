
/*
 * Given a binary tree, print out all of its root-to-leaf paths one per line
 * --------------------------------------------------------------------------
 * 
 Algorithm:

initialize: pathlen = 0, path[1000] 

printPathsRecur(tree, path[], pathlen)
   1) If node is not NULL then 
         a) push data to path array: 
                path[pathlen] = node->data.
         b) increment pathlen 
                pathlen++
   2) If node is a leaf node then print the path array.
   3) Else
        a) Call printPathsRecur for left subtree
                 printPathsRecur(node->left, path, pathLen)
        b) Call printPathsRecur for right subtree.
                printPathsRecur(node->right, path, pathLen)
 */
public class Question068 {

	void printRootToLeafPaths(Node tree){
		int[] path = new int[100];
		
		rootToLeafPaths(tree, path, 0);
	}
	
	void rootToLeafPaths(Node tree, int[] path, int pathLen) {
		if(tree == null){
			return;
		}
		
		path[pathLen] = tree.getData();
		pathLen++;
		
		if(tree.getLeft() == null && tree.getRight() == null){
			printPath(path, pathLen);
		}else{
			rootToLeafPaths(tree.getLeft(), path, pathLen);
			rootToLeafPaths(tree.getRight(), path, pathLen);
		}		
		
	}

	void printPath(int[] path, int pathLen) {
		for(int p = 0; p<pathLen;p++){
			System.out.print(" "+path[p]);
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		Question068 q = new Question068();
		
		Node n5 = new Node(5);
		Node n4 = new Node(4);
		Node n3 = new Node(3);
		Node n2 = new Node(n4, n5, 2);
		Node n1 = new Node(n2, n3, 1);
		
		System.out.println("Root to Leaf Paths are :: ");
		q.printRootToLeafPaths(n1);

	}

}


// Time complexity - O(n) - [guess]
