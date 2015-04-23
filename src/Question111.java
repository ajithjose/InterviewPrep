import java.util.Iterator;
import java.util.NoSuchElementException;


/*
 * Stack Implementation using Arrays with Resizing
 * ------------------------------------------------
 * 

 How to shrink array?
-push(): double size of array s[] when array is full.
-pop(): halve size of array s[] when array is one-quarter full. 
If we had used the approach of halving the array when it is one-half full, the push-pop-push-pop-… sequence 
when array is full would take time proportional to N for each push/pop operation.

 * 
 */

public class Question111 {

	public static void main(String[] args) {
		
		Stack<Integer> stk = new Stack<Integer>();
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.pop();
		stk.push(5);
		
		for(Integer i : stk){
			System.out.println(i);
		}
		

	}

}

@SuppressWarnings("unchecked")
class Stack<T> implements Iterable<T>{
	
	T[] S;
	int N;
	
	Stack(){
		this.N = 0;
		this.S = (T[]) new Object[2];
	}

	public void push(T item) {
		
		if(N == S.length){
			resizeArray(S.length*2);
		}
		
		S[N++] = item;
		
	}
	
	public void pop(){
		S[--N] = null;
		
		if(N == S.length/4){
			resizeArray(S.length/4);
		}
	}

	private void resizeArray(int newSize) {
		
		T[] temp = (T[]) new Object[newSize];
		
		for(int i=0;i<this.N;i++){
			temp[i] = S[i];
		}
		
		this.S = temp;
		temp = null;
	}

	@Override
	public Iterator<T> iterator() {		
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<T> {
        private int i;

        public ReverseArrayIterator() {
            i = N-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return S[i--];
        }
    }
	
}

// Average running time for push / pop = O(1)
// Worst case size requirement O(1)
/*
 * 
Stack Implementations : Resizing Array Vs LinkedList
------------------------------------------------------

Tradeoffs: Can implement a stack with either resizing array or linked list;
client can use interchangeably. Which one is better?

Linked-list implementation
-Every operation takes constant time in the worst case.
-Uses extra time and space to deal with the links.

Resizing-array implementation
-Every operation takes constant amortized time.
-Less wasted space.

 * 
 */
