/*
 * 
3-way Quick Sort Algorithm
----------------------------

Version of quick-sort sorting algorithm when there are a lot of duplicates

 */
public class Question152 {
	
	private static void threeWayQuickSort(Comparable<Integer>[] A, int lo, int hi){
		if(hi<=lo) return;
		int lt=lo, gt=hi, i=lo;
		Comparable<Integer> v = A[lo];
		while(i<=gt){
			int cmp = A[i].compareTo((Integer) v);
			if(cmp<0) swap(A, i++, lt++);
			else if (cmp>0) swap(A, i, gt--);
			else i++;
		}
		
		threeWayQuickSort(A, lo, lt-1);
		threeWayQuickSort(A, gt+1, hi);
	}

	private static void swap(Comparable<Integer>[] A, int i, int j) {		
		Comparable<Integer> temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}	
	
	public static void main(String[] args) {
		Integer A[] = {22, 33, 21, 43, 43, 43, 22, 44, 55, 34, 22};
		threeWayQuickSort(A, 0, A.length-1);
		System.out.println("Sorted elements are ");
		for(Integer a : A)
			System.out.print(a+" ");
	}

}

// Time complexity - same as quick sort
// Average case - O(nlogn)
// Worst case - O(n^2)