package pack020;



class Question011 { 
	
void patternSearch(String inputString, String pattern){
	char[] inputStringChars = inputString.toCharArray();
	char[] patternChars = pattern.toCharArray();
	
	int i = 0;
	int N = inputStringChars.length;
	int M = patternChars.length;
	while(i<(N - M + 1)){
		int j;
		for(j=0;j<M;j++){
			if(inputStringChars[i+j]!=patternChars[j]){
				break;
			}
		}
		if(j==M){
			j--;
			System.out.println("Pattern found at "+i);
		}
		i+=(j+1);
	}
}

public static void main(String[] args){
    Question011 q = new Question011();
    q.patternSearch("ABCEABCDABCEABCD","ABCD");
}

}

// Time complexity O(n)