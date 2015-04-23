/*
 * Stack Implementation Using Linked Lists
 * ----------------------------------------
 * 
 */

public class Question103 {
	static class LLNode<T> {
		T item;
		LLNode<T> next;
	}
	
	static class Stack<T>{
		
		LLNode<T> top;
		int size;
		
		public void push(T obj){
			LLNode<T> previousTop = top;
			top = new Question103.LLNode<T>();
			top.item = obj;
			top.next = previousTop;
			size++;
		}
		
		public Object pop(){
			Object topObject = (Object) top.item;
			top = top.next;
			size--;
			return topObject;
		}
		
	}

	public static void main(String[] args) {
		
		Stack<Integer> stk = new Question103.Stack<Integer>();
		stk.push(10);
		stk.push(20);
		stk.push(30);
		stk.push(40);
		stk.push(50);
		
		System.out.println("Stack elements :: ");
		while(stk.size > 0){
			System.out.println(stk.pop().toString());
		}
	}

}

// Time Complexity
// --------------- 
// Push - O(1)
// Pop - O(1)