import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * 
 * Queue Implementation using Arrays with Resizing
 * ------------------------------------------------
 * 
 */
public class Question112 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();
		q.enqueue(5);
		
		for(Integer i : q){
			System.out.println(i);
		}

	}

}

@SuppressWarnings("unchecked")
class Queue<T> implements Iterable<T>{
	
	T[] Q;
	int N;
	int first;
	int last;
	
	Queue(){
		Q = (T[]) new Object[2];
		N = 0;
		first = 0;
		last = 0;
	}
	
	void enqueue(T item){
		if(N==Q.length) resizeArray(2*Q.length);
		
		Q[last++] = item;		
		
		if(last==Q.length){
			last = 0;
		}
		
		N++;
	}
	
	T dequeue(){
		
		if(isEmpty()) throw new UnsupportedOperationException();
		
		T firstItem = Q[first];
		Q[first++] = null;
		N--;
		if( N == Q.length/4) resizeArray(Q.length/2);
		
		return firstItem;
	}

	boolean isEmpty() {
		return N==0;
	}

	int size(){
		return N;
	}
	
	void resizeArray(int newLen) {
		
		T[] temp = (T[]) new Object[newLen];
		
		for(int i=0;i<N;i++){
			temp[i] = Q[(first+i)%Q.length];
		}
		
		Q = temp;
		first = 0;
		last = N;		
	}

	@Override
	public Iterator<T> iterator() {		
		return new QIterator();
	}
	
	class QIterator implements Iterator<T>{

		private int i = 0;
		
		@Override
		public boolean hasNext() {
			return i < N;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T item = Q[(i+first)%Q.length];
			i++;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
}