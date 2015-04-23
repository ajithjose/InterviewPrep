package pack020;


// Given two strings where first string may contain wild card characters and second string is a normal string. 
// Write a function that returns true if the two strings match. The following are allowed wild card characters in first string.
//
// * --> Matches with 0 or more instances of any character or set of characters.
// ? --> Matches with any one character.
// For example, “g*ks” matches with “geeks” match. 
// And string “ge?ks*” matches with “geeksforgeeks” (note ‘*’ at the end of first string). 
// But “g*k” doesn’t match with “gee” as character ‘k’ is not present in second string.

class Question015 { 
	
boolean match(char[] A, char[] B, int i, int j){
	// If we reach at the end of both strings, we are done
	if(i == A.length && j == B.length){
		return true;
	}
	// Make sure that the characters after '*' are present in second string.
    // This function assumes that the first string will not contain two
    // consecutive '*' 
	if(i<A.length && A[i]=='*' && (i+1) != A.length && j == B.length ){
		return false;
	}
	// If the first string contains '?', or current characters of both 
    // strings match
	if((i<A.length && A[i]=='?') || (i<A.length && j<B.length && A[i]==B[j])){
		return match(A,B,i+1,j+1);
	}
	// If there is *, then there are two possibilities
    // a) We consider current character of second string
    // b) We ignore current character of second string.
	if(i<A.length && A[i]=='*'){
		return match(A,B,i+1,j) || match(A,B,i,j+1);
	}
	return false;
}

void test(String A, String B){
	System.out.println(match(A.toCharArray(),B.toCharArray(),0,0) ? "Yes" : "No");
}

public static void main(String[] args){
    Question015 q = new Question015();
    q.test("g*ks", "geeks"); // Yes
    q.test("ge?ks*", "geeksforgeeks"); // Yes
    q.test("g*k", "gee");  // No because 'k' is not in second
    q.test("*pqrs", "pqrst"); // No because 't' is not in first
    q.test("abc*bcd", "abcdhghgbcd"); // Yes
    q.test("abc*c?d", "abcd"); // No because second must have 2 instances of 'c'
    q.test("*c*d", "abcd"); // Yes
    q.test("*?c*d", "abcd"); // Yes
}

}

//Time Complexity - O(n) where n is no. of characters in the second string (not sure)