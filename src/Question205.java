import java.util.Arrays;
import java.util.Scanner;

/*
 * 
Pairs (HackerRank, Easy)
------------------------

Given N integers, count the total pairs of integers that have a difference of K.
 
Input Format
The 1st line contains two integers N and K (separated by a space).
The 2nd line contains N integers that form the set. All the N numbers are distinct.
 
Output Format
An integer that gives the number of pairs of numbers that have a difference of K.
 
Constraints:
N <= 105
0 < K < 109
Each integer will be greater than 0 and at least K smaller than 231-1
 
Sample Input #1:
5 2  
1 5 3 4 2  
 
Sample Output #1:
3
 
Explanation #1:
The pairs which differ by 2 are (1,3), (2,4) and (3,5).
 
Sample Input #2:
10 1  
363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793 
 
Sample Output #2:
0
 * 
 */
public class Question205 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		
		String firstLine = stdin.nextLine();
		String[] firstLineStrs =  firstLine.split(" ");
		int n = Integer.parseInt(firstLineStrs[0]);
		int k = Integer.parseInt(firstLineStrs[1]);
		
		String secondLine = stdin.nextLine();
		String[] secondLineStrs =  secondLine.split(" ");
		int[] A = new int[n];
		
		for(int i=0;i<n;i++){
			A[i] = Integer.parseInt(secondLineStrs[i]);
		}
		
		int pairs = getNumberOfPairs(A, k);
		
		System.out.println(pairs);
		
		stdin.close();
	}

	private static int getNumberOfPairs(int[] a,int k) {
	      Arrays.sort(a);
	      int size = a.length;
	      int count =0;
	      for(int i=0;i<size-1; i++){
	        int j=i+1;
	        while(a[j]<=a[i]+k){
	            if(a[i]+k  == a[j]){
	                count++;
	            }
	            j++;
	            if(j==size)
	                break;
	        }
	      }
	        return count;
	    }

}
