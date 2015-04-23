import java.util.Scanner;

/*
 * 
Summing the N-Series (HackerRank, Easy)
---------------------------------------

You are given a series T whose nth term is defined as
Tn = n^2 - (n-1)^2
 
You have to find the Sum of the series Sn = T1 + T2 + T3 + …. + Tn
 n
If Sn is very large, return it modulo 1,000,000,007 
 
Input Format
The first line contains an integer T that gives the number of test cases.
Each test case a single integer n.
 
Output Format
One integer modulo 1,000,000,007.
 
Constraints
1 <= T <= 10
1 <= n <= 1016
 
Sample Input
2
2
1

Sample Output
4
1

Explanation'
(1 - 0) + (4 - 1) = 4
(1 - 0) = 1
 */
public class Question206 {
	
	private static int[] A;

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		A =  new int[1016];
		int T = Integer.parseInt(stdin.nextLine());
		int[] sum = new int[T];
		
		for(int i=0;i<T;i++){
			sum[i] = findSumOfSeries(Integer.parseInt(stdin.nextLine()));
		}
		
		for(int s: sum){
			System.out.println(s);
		}
		stdin.close();
	}

	private static int findSumOfSeries(int n) {
		
		int sum = 0;
		for(int i=1;i<=n;i++){
			int t = (int) ((A[i] == 0) ? A[i] = (int)(Math.pow(i, 2) - Math.pow(i-1, 2)) : A[i]);
			sum+=t;
		}
		
		return sum;
		
	}

}
