package pack020;


// Given a string, eliminate all “b” and “ac” in the string, you have to replace them in-place, 
// and you are only allowed to iterate over the string once. 
// (Source Google Interview Question)
//
// Examples:
//
// acbac   ==>  ""
// aaac    ==>  aa
// ababac  ==>   aa
// bbbbd   ==>   d
// The two conditions are:
// 1. Filtering of all ‘b’ and ‘ac’ should be in single pass
// 2. No extra space allowed.

// The trick here is how to track ‘a’ before ‘c’. An interesting approach is to use a two state machine. 
// The state is maintained to TWO when previous character is ‘a’, otherwise state is ONE.
//  1) If state is ONE, then do NOT copy the current character to output if one of the following conditions is true
//  …a) Current character is ‘b’ (We need to remove ‘b’)
//  …b) Current character is ‘a’ (Next character may be ‘c’)
//  2) If state is TWO and current character is not ‘c’, we first need to make sure that we copy the previous character ‘a’. 
//  Then we check the current character, if current character is not ‘b’ and not ‘a’, then we copy it to output.

class Question016 { 
private String output;

String stringFilter(String input){
	char[] inputChars = input.toCharArray();	
	output = "";
	
	boolean secondState = false;
	for(int i=0;i<inputChars.length;i++){
		if(secondState){
			secondState = stateTwoOperation(inputChars[i]);
		}else{
			secondState = stateOneOperation(inputChars[i]);
		}
	}
	if(secondState){
		output = output + 'a';
	}
	
	return output;
}

boolean stateOneOperation(char character){
	if(character == 'a' ){
			return true;
	}
	
	if(character != 'b'){
		output = output + character;	
	}
	
	return false;
}

boolean stateTwoOperation(char character){
	if(character == 'a' ){
			output = output + 'a';
			return true;
	}
	
	if(character == 'b' ){
		output = output + 'a';	
	}else if(character != 'c' ){
		output = output + 'a' + character;	
	}
	
	return false;
}

public static void main(String[] args){
    Question016 q = new Question016();
    String[] inputStrings = {"ad","acbac","aaac","react","aa","ababaac"};
    for(String str : inputStrings)
    	System.out.println(q.stringFilter(str)); //"ad","","aa","ret","aa","aaa" 
}

}

// Time Complexity - O(n)

//	An extension of above problem where we don’t want “ac” in output at all:
//	The above code looks fine and seems to handle all cases, but what if input string is “aacacc”, 
//	the above code produces output as “ac” which looks correct as it removes consecutive occurrences of ‘a’ and ‘c’. 
//	What if the requirement is to not have an “ac” in output string at all. 
//	Can we modify the above program to produce output as empty string for input “aacacc” 
//	and produce output as “d” when input is “abcaaccd”? 