import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 Uneaten Leaves
 ---------------
 
 K caterpillars are eating their way through N leaves. 
 Each caterpillar falls from leaf to leaf in a unique sequence. 
 All caterpillars start at a twig in position 0 and fall onto the leaves at positions between 1 and N.  
 Each caterpillar i has an associated 'jump-number' Ai. 
 A caterpillar with jump number j eats leaves at positions that are multiples of j. 
 It will proceed in the order  j, 2j, 3j, ... till it reaches the end of the leaves, then it stops and builds it cocoon.
 
Given a set A of K elements, K <= 15,  N <= 109, we need to determine the number of uneaten leaves.
 
Input Format:
N = number of leaves
K = number of caterpillars
A = Array of integer jump numbers (one per line).
 
Output Format:
An integer denoting the number of uneaten leaves.  
 
Sample Input:
10
3
2
4
5
 
Sample Output:c
 
4
Explanation
[2,4,5] is the 3-member set of jump numbers. All leaves which are multiples of 2, 4, and 5 are eaten. 
Leaves 1,3,7,9 are left, and they number 4.
 */
public class Question208 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);

		int N = Integer.parseInt(stdin.nextLine());
		int K = Integer.parseInt(stdin.nextLine());
		
		int[] A = new int[K];
		for(int i=0;i<K;i++){
			A[i] = Integer.parseInt(stdin.nextLine());
		}
		
		System.out.println(uneatenLeaves(N, K, A));
		
		stdin.close();
	}

	private static int uneatenLeaves(int N, int K, int[] A) {
		
		ArrayList<Integer> leaves = new ArrayList<Integer>();
		for(int i=1;i<=N;i++){
			leaves.add(i);
		}
		Arrays.sort(A);
		
		ArrayList<Integer> remLeaves;		
		for(int a : A){
			remLeaves = new ArrayList<Integer>();		
			for(int l : leaves){
				if(l%a == 0){
					remLeaves.add(l);
				}
			}
			leaves.removeAll(remLeaves);
		}
		
		return leaves.size();
	}

}
