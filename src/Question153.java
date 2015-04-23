/*
 * 
Priority Queue Implementation Using Binary Heap
-------------------------------------------------
 */
public class Question153 {

	public static void main(String[] args) {
		PriorityQueue<Integer> pQueue =  new PriorityQueue<Integer>(10);
		pQueue.insert(100);
		pQueue.insert(50);
		pQueue.insert(70);
		System.out.println(pQueue.max());
		pQueue.deleteMax();
		System.out.println(pQueue.max());
		pQueue.insert(20);
		pQueue.insert(50);
		pQueue.insert(80);
		pQueue.insert(30);
		System.out.println(pQueue.max());
		pQueue.deleteMax();
		System.out.println(pQueue.max());
	}

}

class PriorityQueue<T extends Comparable<T>> {
	
	T[] pq;
	int N;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue(int capacity){ // initial capacity for simplicity; we can have a resizing array if we need to be dynamic
		pq = (T[]) new Comparable[capacity+1];			
	}
	
	public void insert(T x){
		pq[++N] = x;
		swim(N);
	}
	
	private void swim(int n) {
		while(n>1 && less(n/2, n)){
			swap(n/2, n);
			n/=2; 
		}			
	}

	private void swap(int i, int j) {
		T temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		
	}

	private boolean less(int i, int j) {
		if(pq[i].compareTo(pq[j]) < 0) return true;
		return false;
	}

	public void deleteMax(){
		if(!isEmpty()) {
			swap(1, N--);
			sink(1);
		}			
	}
	
	private void sink(int n) {
		while(n*2<=N){
			int m = n*2;
			if(m<N && less(m, m+1)) m++;
			if(less(m,n)) break;
			swap(m,n);
			n=m;
		}
	}

	private boolean isEmpty() {
		return N == 0;
	}

	public T max(){
		return pq[1];
	}
	
}
