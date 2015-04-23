package pack020;


import java.util.HashMap;

class Question003 { 

void printDuplicates(String str){
	char[] strChars = str.toCharArray();
	HashMap<Character, Integer> strMap = new HashMap<Character, Integer>();
	for(char c : strChars){
		if(strMap.get(c) == null){
			strMap.put(c, 1);
		}
		else{
			strMap.put(c, strMap.get(c)+1);
		}
	}
	for(char c : strMap.keySet()){
		if(strMap.get(c) > 1){
			System.out.println(c + ": " + strMap.get(c));
		}
	}
}

public static void main(String[] args){
    Question003 q = new Question003();
    q.printDuplicates("geeksforgeeks");
}

}

//Time Complexity - O(n)