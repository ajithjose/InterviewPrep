
/*
 * Queue Implementation Using Linked Lists
 * ----------------------------------------
 * 
 */

public class Question104 {

	
	static class LLNode<T>{
		T item;
		LLNode<T> next;
	}
	
	static class Queue<T> {

		LLNode<T> first;
		LLNode<T> last;
		int size;
		
		void enqueue(T obj){
			LLNode<T> previousLast = last;
			last = new LLNode<>();
			last.item = obj;
			last.next = null;
			
			if(previousLast == null){
				first = last;
			}else{
				previousLast.next = last;
			}
		
			size++;
		}
		
		T dequeue(){
			T firstItem = null;
			if(first != null){
				firstItem = first.item;
				first = first.next;
			}
			
			size--;
			return firstItem;
		}
		
		boolean isEmpty(){
			return (first == null) ;
		}
	}
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Question104.Queue<>();

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
		System.out.println("The queue contents in FIFO order ::");
		while(!queue.isEmpty()){
			System.out.println(queue.dequeue());
		}
	}

}
