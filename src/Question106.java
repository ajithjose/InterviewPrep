import java.util.Arrays;
import java.util.Comparator;

/*
 * Find four elements that sum to a given value
 * ---------------------------------------------
 * 
 Let the input array be A[].

1) Create an auxiliary array aux[] and store sum of all possible pairs in aux[]. The size of aux[] will be n*(n-1)/2 where n is the size of A[].

2) Sort the auxiliary array aux[].

3) Now the problem reduces to find two elements in aux[] with sum equal to X. 

There is following important point to note though. An element of aux[] represents a pair from A[]. 
While picking two elements from aux[], we must check whether the two elements have an element of A[] in common. 
For example, if first element sum of A[1] and A[2], and second element is sum of A[2] and A[4], 
then these two elements of aux[] don’t represent four distinct elements of input array A[]. 
 * 
 */
public class Question106 {
	
	class PairSum{
		int first;
		int second;
		int sum;
	}
	
	boolean noCommonElements(PairSum A, PairSum B){
		if(A.first == B.first || A.first == B.second || A.first == A.second || B.first == B.second){
			return false;
		}
		return true;
	}

	private boolean findFourNumbersWithSum(int[] A, int sum) {
		
		int N = A.length;
		int size = (N*(N-1))/2;
		
		PairSum[] pairs = new PairSum[size];
		
		int k=0;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				pairs[k] = new PairSum();
				pairs[k].first = A[i];
				pairs[k].second = A[j];
				pairs[k].sum = A[i] + A[j];
				k++;
			}
		}
		
		Arrays.sort(pairs, new Comparator<PairSum>() {
			@Override
			public int compare(PairSum p1, PairSum p2) {				
				return p1.sum - p2.sum;
			}
		});
		
		int l = 0;
		int r = size-1;
		
		while(l<r){
			if((pairs[l].sum + pairs[r].sum == sum) && noCommonElements(pairs[l], pairs[r])){
				System.out.println("Elements :: "+pairs[l].first+" "+pairs[l].second+" "+pairs[r].first+" "+pairs[r].second);
				return true;
			}else if((pairs[l].sum + pairs[r].sum)<sum){
				l++;
			}else{
				r--;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Question106 q = new Question106();
	    int[] A = {34, 6, 33, 3, 55, 63, 43, 1, 44, 66, 38};
	    int sum = 50;
	    if(q.findFourNumbersWithSum(A, sum)){
	    	System.out.println("Aha, there is a sum");
	    }else{
	    	System.out.println("Nay.. no such triplet");
	    }

	}

}

// Time complexity - O(n^2logn)
// The step 1 takes O(n^2) time. The second step is sorting an array of size O(n^2). 
// Sorting can be done in O(n^2Logn) time using merge sort or heap sort or any other O(nLogn) algorithm. 
// The third step takes O(n^2) time. So overall complexity is O(n^2Logn).

// Check http://www.geeksforgeeks.org/find-four-numbers-with-sum-equal-to-given-sum/ for a O(n^3) solution.

// Space complexity - O(n^2) // Size of the auxillary array