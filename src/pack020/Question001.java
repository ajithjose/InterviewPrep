package pack020;


import java.util.HashMap;

class Question001 { 

	char findMaxOccuringChar(String input){
		char[] inputChars = input.toCharArray();
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(char c : inputChars){
			if(charMap.get(c) == null){
				charMap.put(c, 1);
			}else{
				charMap.put(c, charMap.get(c)+1);
			}
		}
		int max = 0;
		char maxChar = 'a';
		int numOfOccurence = 0;
		for( char key : charMap.keySet()){
			numOfOccurence = charMap.get(key);
			if(numOfOccurence>max){
				max = numOfOccurence;
				maxChar = key;
			}
		}
		return maxChar;
	}

	public static void main(String[] args){
		Question001 q = new Question001();
		System.out.println(""+q.findMaxOccuringChar("harahaha"));
	}

}

// Time Complexity - O(n)