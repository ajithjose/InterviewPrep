import java.util.Random;

/**
 * Shuffling Algorithm
 * -------------------
 */
public class Question115 {

	private static void shuffle(int[] A) {
		
		Random rand = new Random();
		int j, temp;
		for(int i=1;i<A.length;i++){
			j = rand.nextInt(i);
			temp = A[i];
			A[i] = A[j];
			A[j] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 6, 10, 15, 22, 40, 60};
		
		shuffle(A);
		
		System.out.println("Shuffled Numbers: ");
		for(int a : A){
			System.out.print(" "+a);
		}

		System.out.println();

	}

}

// Time complexity - O(n)
// Space complexity - O(1)