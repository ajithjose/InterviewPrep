package pack020;


import java.util.HashMap;

class Question004 { 

String subtractStrings(String firstString, String secondString){
	char[] firstStringChars = firstString.toCharArray();
	char[] secondStringChars = secondString.toCharArray();
	String result = "";
	
	HashMap<Character, Integer> secondStringMap = new HashMap<Character, Integer>();
	for(Character c : secondStringChars){
		if(secondStringMap.get(c) == null){
			secondStringMap.put(c,1);
		}
	}
	for(Character c : firstStringChars){
		if(secondStringMap.get(c) == null){
			result = result + c;
		}
	}
	return result;
}

public static void main(String[] args){
    Question004 q = new Question004();
    System.out.println(q.subtractStrings("test string", "test"));
}

}

//Time Complexity - O(n)