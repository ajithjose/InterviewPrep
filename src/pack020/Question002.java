package pack020;


import java.util.HashMap;

class Question002 { 

String removeDuplicates(String str){
	char[] strChars = str.toCharArray();
	String outputString = "";
	HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	for(char c: strChars){
		if(map.get(c) == null){
			map.put(c, 1);
			outputString = outputString + c;
		}
	}
	return outputString;
}

public static void main(String[] args){
    Question002 q = new Question002();
    System.out.println(""+q.removeDuplicates("geeksforgeeks"));
}

}