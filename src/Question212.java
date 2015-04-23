import java.util.HashMap;
import java.util.Scanner;

/*
 * 
A Compliance Problem (Bloomberg Codecon)
---------------------

As part of a team project to build an instant messaging program, you have to work around your teammate's buggy compliance filter.

The compliance filter works based on an algorithm which determines if certain messages can pass through the system and 
if they should be flagged. Usually the compliance filter system has a dictionary of black listed words which it filters out.

However, due to your teammate's programming error the compliance filter system appears to only allow words 
that are palindromes or anagrams of palindromes (i.e. can make a palindrome when re-arranged).

For example:

abba
aabb (this one is an anagram of abba or baab)
civic
deified
mom
mmo
radar
While a fix is being worked on, you are tasked with writing an add on that will determine if a word can pass through the this system.


Input Specifications

Your program will take
A string S denoting the word to be tested. All letters in the alphanumeric input will be lowercase (1 <= LENGTH(S) <= 500), 
and there may be numbers and symbols.

Output Specifications

Based on the input,
Print out yes if the input would pass through the system
Print out no if the input would fail the system

Sample Input/Output

INPUT
abba 
OUTPUT
yes
EXPLANATION
abba is already a palindrome.

INPUT
nnmm 
OUTPUT
yes
EXPLANATION
While nnmm isn't a palndirome, it can be re-arranged to make one; nmmn and mnnm are palindromes that can pass through the system.

INPUT
trail 
OUTPUT
no
EXPLANATION
trail isn't a palindrome, nor an anagram of a palindrome, and therefore will not pass through the system.

*/
public class Question212 {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		
		String str = stdin.nextLine();
		
		if(isCompliant(str)){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}

		stdin.close();
	}

	private static boolean isCompliant(String str) {
		
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0; i<str.length(); i++){
			if(charMap.get(str.charAt(i)) == null){
				charMap.put(str.charAt(i), 1);
			}else{
				charMap.put(str.charAt(i), charMap.get(str.charAt(i)) + 1);
			}
		}
		
		int minCount = 0;
		for(Character c : charMap.keySet()){
			int charCount = charMap.get(c);
			if(charCount%2 != 0){
				minCount++;
				if(minCount>1) return false;
			}
		}
		return true;
	}

}
