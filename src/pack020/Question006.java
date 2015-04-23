package pack020;


import java.util.HashMap;

class Question006 { 

void printFirstNonRepeatingCharacter(String input){
	char[] inputChars = input.toCharArray();
	HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
	for(char c : inputChars){
		if(countMap.get(c) == null){
			countMap.put(c,1);
		}
		else{
			countMap.put(c,countMap.get(c)+1);
		}
	}
	for(char c : inputChars){
		if(countMap.get(c) == 1){
			System.out.println("The first non-repeating character is : "+c);
			break;
		}
	}
}

public static void main(String[] args){
    Question006 q = new Question006();
    q.printFirstNonRepeatingCharacter("starting troubles");
}

}

// Time complexity - O(n)