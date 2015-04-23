import java.util.HashMap;
import java.util.Scanner;

/*
 * 
 * 
Yet Another Compliance Problem (Bloomberg Codecon)
-------------------------------

Your teammate tried to fix the bug, but only managed to make it worse! Now the filter will only accept words that are already palindromes.

You are now tasked with writing another add-on that determines how many different words you can send through the system given a set of characters.

For example:

bbaa can be sent in two different ways: abba and baab
bbaacc can be sent in six different ways: baccab, abccba, acbbca, cabbac, bcaacb, and cbaabc.

Input Specifications

Your program will take
A string S denoting the set of characters to be tested. All letters in the alphanumeric input will be lowercase (1 <= LENGTH(S) <= 500)

Output Specifications

Based on the input, print out the total number of unique palindromes that can be created from the input.

Sample Input/Output

INPUT
bbaa 
OUTPUT
2
EXPLANATION
bbaa can be re-arranged to abba and baab, which are palindromes.
INPUT
abcdef 
OUTPUT
0
EXPLANATION
abcdef has no variations that are palindromes.
INPUT
bbaacc 
OUTPUT
6
EXPLANATION
bbaacc can make the following palindromes: baccab, bcaacb, cbaabc, cabbac, acbbca, abccba.

SOLUTION HINTS
http://stackoverflow.com/questions/17524341/find-number-of-palindromes-that-are-anagrams-in-c
http://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets

The answer to the problem is the multiset permutation of half the size of the string

 * 
 */
public class Question213 {

	private static int factorial(int n){

		if(n==0 || n==1)
			return 1;

		int fact = n; 
		for(int i=n-1;i>1;i--){
			fact = fact*i;
		}

		return fact;
	}

	private static HashMap<Character, Integer> charMap;
	private static int getUniquePalindromes(String str) {

		charMap = new HashMap<Character, Integer>();
		if(isCompliant(str)){
			int numerator = factorial(str.length()/2);
			int denominator = 1;
			for(Character c : charMap.keySet()){
				denominator = denominator * factorial(charMap.get(c)/2);
			}
			
			return numerator/denominator;
		}
		
		return 0;
	}

	private static boolean isCompliant(String str) {

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

	public static void main(String[] args) {

		Scanner stdin = new Scanner(System.in);

		String str = stdin.nextLine();

		int uniquePals = getUniquePalindromes(str);

		System.out.println(uniquePals);

		stdin.close();

	}

}
