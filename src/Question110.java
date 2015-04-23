import java.util.Stack;

/*
 * Check for balanced parentheses in an expression
 * ------------------------------------------------
 * 
 
Given an expression string exp, write a program to examine whether the pairs and 
the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. 
For example, the program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”

Algorithm:
1) Declare a character stack S.
2) Now traverse the expression string exp.
    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and 
       if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”

 * 
 */

public class Question110 {
	
	boolean isBalanced(String str){
		char[] strChars = str.toCharArray();
		Stack<Character> strStack = new Stack<Character>();
		
		for(int i=0; i<strChars.length;i++){
			char currentChar = strChars[i];
			if(currentChar == '{' || currentChar == '[' || currentChar == '('){
				strStack.push(currentChar);
			}
			
			if(currentChar == '}' || currentChar == ']' || currentChar == ')'){
				
				if(strStack.isEmpty()){
					return false;
				}
				
				char poppedChar = strStack.pop();
				if(!isMatchingPair(poppedChar, currentChar)){
					return false;
				}
			}
		}
		
		if(strStack.isEmpty())
			return true;
		return false;
	}

	private boolean isMatchingPair(char stackChar, char currentChar) {
		
		if(   (stackChar == '{' && currentChar == '}')
		   || (stackChar == '[' && currentChar == ']')
		   || (stackChar == '(' && currentChar == ')')){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Question110 q = new Question110();
		String testString ="{}()[]";
		if(q.isBalanced(testString)){
			System.out.println("Balanced parentheses");
		}else{
			System.out.println("Unbalanced parentheses");
		}

	}

}

// Time complexity - O(n)
// Space complexity - O(n) for stack and character array
