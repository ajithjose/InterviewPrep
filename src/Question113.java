/*
 * Detect and remove loop / cycle in a linked list
 * ------------------------------------------------
 * 

Use Hashing:
Traverse the list one by one and keep putting the node addresses in a Hash Table. At any point, 
if NULL is reached then return false and if next of current node points to any of the previously stored nodes in Hash then return true.

Mark Visited Nodes:
This solution requires modifications to basic linked list data structure.  
Have a visited flag with each node.  Traverse the linked list and keep marking visited nodes.  
If you see a visited node again then there is a loop. This solution works in O(n) but requires additional information with each node.
A variation of this solution that doesn’t require modification to basic data structure can be implemented using hash.  
Just store the addresses of visited nodes in a hash and if you see an address that already exists in hash then there is a loop.

Floyd’s Cycle-Finding Algorithm:
This is the fastest method. Traverse linked list using two pointers.  
Move one pointer by one and other pointer by two.  If these pointers meet at some node then there is a loop.  
If pointers do not meet then linked list doesn’t have loop.

Removing Loop:
We start from the head of the Linked List and check for nodes one by one if they are reachable from ptr2. 
When we find a node that is reachable, we know that this node is the starting node of the loop in Linked List 
and we can get pointer to the previous of this node.

 * 
 * 
 */
public class Question113 {

	public static void main(String[] args) {
		
		LLNode<Integer> node1 = new LLNode<Integer>(1);
		LLNode<Integer> node2 = new LLNode<Integer>(2);
		LLNode<Integer> node3 = new LLNode<Integer>(3);
		LLNode<Integer> node4 = new LLNode<Integer>(4);
		LLNode<Integer> node5 = new LLNode<Integer>(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node2;
		
		Question113 q = new Question113();
		q.detectAndRemoveCycles(node1);
		
		printLinkedList(node1);
		
	}

	private static void printLinkedList(LLNode<Integer> node1) {
		LLNode<Integer> iterNode = node1; 
		while(iterNode.next != null){
			System.out.print(iterNode.data);
			iterNode = iterNode.next;
			if(iterNode.next != null){
				System.out.print(" -> ");
			}
		}
	}

	private void detectAndRemoveCycles(LLNode<Integer> headNode) {
		
		LLNode<Integer> slowPointer = headNode;
		LLNode<Integer> fastPointer = headNode;
		
		boolean cycleFound = false;
		int loopCount = 1;
		
		while(slowPointer != null && fastPointer != null && fastPointer.next != null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			
			if(slowPointer == fastPointer){
				cycleFound = true;
				slowPointer = slowPointer.next;
				while(slowPointer != fastPointer){
					slowPointer = slowPointer.next;
					loopCount++;
				}
				break;
			}
		}
		
		if(cycleFound){
			System.out.println("Cycle found !");
			LLNode<Integer> rPointer1 = headNode;
			LLNode<Integer> rPointer2 = headNode;
			LLNode<Integer> pointerBeforeLoopJoin = null;			
			
			while(loopCount>0){
				pointerBeforeLoopJoin = rPointer1;
				rPointer1 = rPointer1.next;
				loopCount--;
			}
			
			while(rPointer1 != rPointer2){
				pointerBeforeLoopJoin = rPointer1;
				rPointer1 = rPointer1.next;
				rPointer2 = rPointer2.next;
			}
			
			pointerBeforeLoopJoin.next = null;
			
		}else{
			System.out.println("No cycles found !");
		}
		
	}
	
}

class LLNode<T>{
	T data;
	LLNode<T> next;
	
	public LLNode(T data) {
		super();
		this.data = data;
		this.next = null;
	}
	
}

// Time complexity - O(n) for finding the cycle