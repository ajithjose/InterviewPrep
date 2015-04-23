import java.util.Scanner;

/*
 * 
 * 
LIST MAX (HackerRank, Easy)
----------------------------

PROBLEM STATEMENT 
You are given a list of size N, initialized with zeroes. 
You have to perform M operations on the list and output the maximum of final values of all the N elements in the list. 
For every operation, you are given three integers a, b and k. The value k needs to be added to all the elements ranging from index a through b (both inclusive).

Input Format
The first line will contain two integers N and M separated by a single space.
The next M lines will each contain three integers a, b and k separated spaces.
The numbers in the list are numbered from 1 to N.

Output Format
A single integer on a separate line line containing the maximum value in the list after all the operations re completed. 

Constraints
3 <= N <= 10,000,000
1 <= M <= 200,000
1 <= a <= b <= N
0 <= k <= 109

Sample Input #1:
5 3
1 2 100
2 5 100
3 4 100

Sample Output #1:
200

Explanation
After first update list will be 100 100 0 0 0.
After second update list will be 100 200 100 100 100.
After third update list will be 100 200 200 200 100.
So the required answer will be 200.

 */
public class Question201 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String firstLine = stdin.nextLine();
		String[] firstLineNos = firstLine.split(" ");
		int n = Integer.parseInt(firstLineNos[0]);
		int m = Integer.parseInt(firstLineNos[1]);
		
		int[][] input = new int[m][3];
		for(int i=0;i<m;i++){
			String nextLine = stdin.nextLine();
			String[] nextLineStrs = nextLine.split(" ");
			int[] nextLIneInts = new int[3];
			for(int j=0;j<3;j++){
				nextLIneInts[j] = Integer.parseInt(nextLineStrs[j]);
			}
			input[i] = nextLIneInts;
		}
		
		int max = getMaxAfterOperations(n, m, input);
		
		System.out.println(max);
		
		stdin.close();

	}

	private static int getMaxAfterOperations(int n, int m, int[][] input) {
		
		int[] A =  new int[n];		
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<m;i++){
			for(int j=input[i][0]; j<input[i][1]; j++){
				A[j-1] += input[i][2];
				if(A[j-1] > max){
					max=A[j-1];
				}
			}
		}
		
		return max;
	}

}
