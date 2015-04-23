import java.util.Arrays;

/*
 * Find a triplet that sum to a given value (3 Sum Problem)
 * ---------------------------------------------------------
 */

public class Question105 {

	boolean findTripletsWithSum(int[] A, int sum){
		
		Arrays.sort(A);
		
		for(int i=0;i<A.length-2;i++){
		
			int l = i+1;
			int r = A.length-1;
			
			while(l<r){
				if(A[i] + A[l] + A[r] > sum){
					r--;
				}else if(A[i] + A[l] + A[r] < sum){
					l++;
				}else{
					System.out.println(sum + " = "+A[i]+ " + "+A[l]+ " + "+A[r]);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Question105 q = new Question105();
	    int[] A = {34, 6, 33, 3, 55, 63, 43, 1, 44, 66, 38};
	    int sum = 50;
	    if(q.findTripletsWithSum(A, sum)){
	    	System.out.println("Aha, there is a sum");
	    }else{
	    	System.out.println("Nay.. no such triplet");
	    }

	}

}

// Time Complexity - O(n^2)
