package pack020;



class Question017 { 
	
void printInterleavings(String chars1, String chars2, char[] result, int m, int n, int i){
	
	if(m==0 && n==0){
		System.out.println(result);
	}
	
	if(m!=0){
		result[i] = chars1.charAt(0);
		String nextChars1 = chars1.substring(1);
		printInterleavings(nextChars1,chars2,result,m-1,n,i+1);
	}
	
	if(n!=0){
		result[i] = chars2.charAt(0);
		String nextChars2 = chars2.substring(1);
		printInterleavings(chars1,nextChars2,result,m,n-1,i+1);
	}
	
}

public static void main(String[] args){
    Question017 q = new Question017();
    String str1 = "AB";
    String str2 = "CD";
    char[] resultString = new char[str1.length()+str2.length()];
    q.printInterleavings(str1, str2, resultString, str1.length(), str2.length(), 0);
}

}

// Time Complexity - O(m+n)

// Output
// ------
//	ABCD
//	ACBD
//	ACDB
//	CABD
//	CADB
//	CDAB
