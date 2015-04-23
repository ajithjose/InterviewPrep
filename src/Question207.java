import java.util.Scanner;

/*
 * 
Valid BST
----------
 
A binary tree is a multi-node data structure where each node has at most two child nodes and one stored value. It may either be
An empty tree, where root = null, or
A non-null root node that contains a value and two sub-trees, left and right, which are also binary trees.

A binary tree is a binary search tree (BST) if all the non-null nodes follow two properties:
Each node’s left sub-tree contains only values lower than its own stored value, and
each node’s right sub-tree contains only values higher than its own stored value.

Pre-order traversal is a tree traversal method where the current node is visited first, 
then the left sub-tree and then the right sub-tree are pre-order traversed in that sequence. 
The following pseudo code parses a tree into a list using pre-order traversal :
If the root is null, output the null list.
For a non-null node,
make a list L by pre-porder traversing the left sub-tree, then
make a list R by pre-porder traversing the right sub-tree
output the stored value of the non-null node, append L to it, then append R to the result.
    1         2          3
     \       / \        / \
      3     1   3      2   5
     /                /   / \
    2                1   4   6
   (a)       (b)        (c)

For the three trees above \, the pre-order traversal list will be
(a) 1 3 2
(b) 2 1 3
(c) 3 2 1 5 4 6
Given a list of numbers, determine whether it can represent the pre-order traversal list of a binary search tree (BST).

Input
The first line contains the number of test cases, T. T lines follow, consisting of two lines each.
The first line of each test case contains the number of nodes in the tree, N. 
In next line there will a list of N unique numbers, where each number is from the range [1, N].

Output
For each test case, print the string “YES” if there exists a BST whose pre-order traversal is equal to the list, 
otherwise print the string “NO” (without quotes, preserving capitalization).

Constraints
1 <= T <= 10
1 <= N <= 100

Sample Input
5
3
1 2 3
3
2 1 3
6
3 2 1 5 4 6
4
1 3 4 2
5
3 4 5 1 2

Sample Output
YES
YES
YES
NO
NO

Explanation 
The first three cases are from the above examples.
In case 4, after encountering the 3, the 4 tells us we are on the right sub-tree, 
which means no values smaller than 3 are allowed any longer. So when we see the 2 we know the list is invalid.
Similarly, in case 5, after encountering the 3, the 4 and 5 tell us we are on the right sub-tree, 
so the subsequent encounter of values 2 and 1, which belong in the left sub-tree, 
tells us that the list is not valid as a pre-order traversal of a BST.

 */

public class Question207 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		int noOfTests = Integer.parseInt(stdin.nextLine());
		boolean[] validBST = new boolean[noOfTests];
		for(int i=0;i<noOfTests;i++){
			int noOfNodes = Integer.parseInt(stdin.nextLine());
			String nUniqueNos = stdin.nextLine();
			String[] nodesStr = nUniqueNos.split(" ");
			int[] nodes = new int[nodesStr.length];
			for(int j=0;j<noOfNodes;j++){
				nodes[j] = Integer.parseInt(nodesStr[j]);
			}
			validBST[i] = isValid(nodes, 0, noOfNodes-1);
		}
		
		for(boolean v : validBST){
			if(v)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		stdin.close();

	}

	private static boolean isValid(int[] nodes, int l, int r) {
		if(l>=r) return true;
		
		int firstRightChild = -1;
		for(int i=l+1;i<=r;i++){
			if(nodes[i]>nodes[l]){
				firstRightChild = i;
				break;
			}
		}
		
		if(firstRightChild != -1){
			for(int i=firstRightChild+1;i<=r;i++){
				if(nodes[i]<nodes[l]){
					return false;
				}
			}
			return isValid(nodes, l+1, firstRightChild-1) && isValid(nodes, firstRightChild, r);
		}
		
		return true;
	}

}
