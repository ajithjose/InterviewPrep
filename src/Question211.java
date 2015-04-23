import java.util.Scanner;

/*
 * 
Expecto Palindronum (Bloomberg Codecon)
--------------------

A palindrome is a word that reads the same backward and forward. 
Given a string S, you are allowed to convert it to a palindrome by adding 0 or more characters in front of it. 
Find the length of the shortest palindrome that you can create from S by applying the above transformation. 

Input Specifications

Your program will take
A string S ( 1 <= Length(S) <=n  100) where each character of S will be
a lowercase alphabet (Between 'a' to 'z')

Output Specifications

For each input, print out an integer L denoting the length of the shortest palindrome you can 
generate from S.

Sample Input/Output

INPUT
baaa 

OUTPUT
7

EXPLANATION
The shortest palindrome you can construct from 'baaa' is 'aaabaaa'.

 */
public class Question211 {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);		
		String input = stdin.nextLine();
		System.out.println(""+findShortestPalindrome(input));
		stdin.close();
	}

	private static int findShortestPalindrome(String input) {
		
		String newString = input;
		int i = newString.length()-1;
		char[] lastChars = null;
		while(!isPalindrome(newString)){
			newString = input;
			lastChars = input.substring(i).toCharArray();
			for(int j=0; j<lastChars.length; j++){
				newString = lastChars[j]+newString;
			} 
			i--;
		}
		
		return newString.length();
	}

	private static boolean isPalindrome(String input) {
		char[] inputChars = input.toCharArray();
		int i=0, j=inputChars.length-1;
		
		while(i<j){
			if(inputChars[i] != inputChars[j]){
				return false;
			}
			i++;j--;
		}
		return true;
	}

}
