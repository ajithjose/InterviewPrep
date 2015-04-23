package pack020;


// For Example:
// Input string1: “this is a test string”
// Input string2: “tist”
// Output string: “t stri”

/*
1) Build a count array count[] for string 2. The count array stores counts of characters.
count['i'] = 1
count['t'] = 2
count['s'] = 1

2) Scan the string1 from left to right until we find all the characters of string2. To check if all the characters are there, use count[] built in step 1. So we have substring “this is a t” containing all characters of string2. Note that the first and last characters of the substring must be present in string2. Store the length of this substring as min_len.

3) Now move forward in string1 and keep adding characters to the substring “this is a t”. Whenever a character is added, check if the added character matches the left most character of substring. If matches, then add the new character to the right side of substring and remove the leftmost character and all other extra characters after left most character. After removing the extra characters, get the length of this substring and compare with min_len and update min_len accordingly.

Basically we add ‘e’ to the substring “this is a t”, then add ‘s’ and then’t’. ‘t’ matches the left most character, so remove ‘t’ and ‘h’ from the left side of the substring. So our current substring becomes “is a test”. Compare length of it with min_len and update min_len.
Again add characters to current substring “is a test”. So our string becomes “is a test str”. When we add ‘i’, we remove leftmost extra characters, so current substring becomes “t stri”. Again, compare length of it with min_len and update min_len. Finally add ‘n’ and ‘g’. Adding these characters doesn’t decrease min_len, so the smallest window remains “t stri”.

4) Return min_len.
*/
import java.util.HashMap;

class Question010 { 
	
String findSmallestWindow(String string1, String string2){
	char[] string1Chars = string1.toCharArray();
	char[] string2Chars = string2.toCharArray();
	HashMap<Character,Integer> string2HashMap = new HashMap<Character,Integer>();
	
	for(char c : string2Chars){
		if(string2HashMap.get(c)==null){
			string2HashMap.put(c,1);
		}else{
			string2HashMap.put(c,string2HashMap.get(c)+1);
		}
	}
	
	int minLength = string1Chars.length;
	String minString = "";
	int startCounter = 0;
	HashMap<Character,Integer> iterationHashMap = new HashMap<Character,Integer>();
	iterationHashMap.putAll(string2HashMap);
	for(int i=0;i<string1Chars.length;i++){
		if(iterationHashMap.get(string1Chars[i]) != null && iterationHashMap.get(string1Chars[i]) != 0){
			iterationHashMap.put(string1Chars[i], iterationHashMap.get(string1Chars[i])-1);
		}
		boolean allCharsPresent = true;
		for(Character c : iterationHashMap.keySet()){
			if(iterationHashMap.get(c) != 0){
				allCharsPresent = false;
				break;
			}
		}
		
		if(allCharsPresent){
			while(i<(string1Chars.length-1) && startCounter<i){
					if(minLength>(i-startCounter)){
						minLength = (i-startCounter);
						minString = "";
						for(int j=startCounter;j<=i;j++){
							minString = minString + string1Chars[j];
						}
					}
					
					do{
						i++;
					}while(i<string1Chars.length && string1Chars[startCounter] != string1Chars[i]);
										
					startCounter++;
					HashMap<Character,Integer> interimHashMap = new HashMap<Character,Integer>();
					for(int l=startCounter;l<i;l++){
						if(interimHashMap.get(string1Chars[l])==null){
							interimHashMap.put(string1Chars[l],1);
						}else{
							interimHashMap.put(string1Chars[l],interimHashMap.get(string1Chars[l])+1);
						}
					}
					
					for(int k = startCounter; k<i; k++){
						if(string2HashMap.get(string1Chars[k]) == null)
							continue;
						else if(interimHashMap.get(string1Chars[k])>string2HashMap.get(string1Chars[k])){
							interimHashMap.put(string1Chars[k],interimHashMap.get(string1Chars[k])-1);
						}else{
							startCounter = k;
							break;
						}
					}
				}
		}
	}
	return minString;
}

public static void main(String[] args){
    Question010 q = new Question010();
    System.out.println(q.findSmallestWindow("this is a test string","tist"));
}

}