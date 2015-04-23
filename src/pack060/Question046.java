package pack060;
//  Dutch National Flag Problem / Three way partitioning problem

//	Given a random input array of 1s, 2s and 3s, rearrange it so that all 1s come before 2s and all 2s come before 3s 

class Question046 {

	void rearrange(int[] A) {

		int i = 0, j = 0, k = A.length - 1;

		while (j < k) {
			switch (A[j]) {
			case 1:
				swap(A, i, j);
				i++;
				j++;
				break;
			case 2:
				j++;
				break;
			case 3:
				swap(A, j, k);
				k--;
				break;
			default:
				System.out.println("Erroneous value in input array");
			}
		}
	}

	void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		Question046 q = new Question046();
		int[] A = { 2, 1, 2, 1, 3, 1, 2, 3, 1, 3 };
		q.rearrange(A);
		System.out.println("After rearranging, the input array is: ");
		for (int a : A)
			System.out.print(a + " ");
	}

}

//	Time complexity - O(n)
//	Space complexity - O(1)