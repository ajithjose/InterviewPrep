package pack020;


import java.util.HashMap;

class Question012 { 
	
public int lengthOfLongestUniqueSubstring(String input){
	char[] inputChars = input.toCharArray();
	int currentIndex = 0;
	int maxIndex = 0;
	int currentLength = 1;
	int maxLength = 1;
	
	Character currentCharacter = inputChars[0];
	HashMap<Character,Integer> longestSubstringMap = new HashMap<Character,Integer>();
	longestSubstringMap.put(currentCharacter,currentIndex);
	
	for(int i=1;i<inputChars.length;i++){
		currentCharacter = inputChars[i];
		if(longestSubstringMap.get(currentCharacter) == null || longestSubstringMap.get(currentCharacter) < (i-currentLength)){
			currentLength++;
		}else{
			if(maxLength<currentLength){
				maxLength = currentLength;
				maxIndex = i-currentLength;
			}
			currentLength = i-longestSubstringMap.get(currentCharacter);
		}
		
		longestSubstringMap.put(currentCharacter,i);
	}
	if(maxLength<currentLength){
				maxLength = currentLength;
				maxIndex  = inputChars.length-currentLength;
	}
	
	String outputString = "";
	for(int j=maxIndex;j<(maxIndex+maxLength);j++){
		outputString = outputString + inputChars[j];
	}
	System.out.println("First longest unique substring : "+outputString);
	
	return maxLength;
}

public static void main(String[] args){
    Question012 q = new Question012();
    System.out.println("Length : "+q.lengthOfLongestUniqueSubstring("geeksforgeeks"));
}

}

// Time complexity O(n)

// Output

// First longest unique substring : eksforg
// Length : 7