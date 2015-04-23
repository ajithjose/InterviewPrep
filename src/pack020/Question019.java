package pack020;



class Question019 { 

boolean isInterleaved(String AString, String BString, String CString){
	
	char[] A = AString.toCharArray();
	char[] B = BString.toCharArray();
	char[] C = CString.toCharArray();
	
	if(C.length != (A.length + B.length)){
		return false;
	}
	
	boolean[][] iTable = new boolean[A.length][B.length];
	
	for(int i=0; i<A.length; i++){
		for(int j=0; j<B.length;j++){
			iTable[i][j] = false;
		}
	}
	
	for(int i=0; i<A.length; i++){
		for(int j=0; j<B.length;j++){
			
			// Both A & B have zero characters and C with zero characters is an
			// interleaving
			if(i==0 && j==0){
				iTable[i][j] = true;
			}
			// A has zero characters
			else if(i==0 && j>0 && B[j-1] == C[j-1]){
				iTable[i][j] = iTable[i][j-1];
			}
			// B has zero characters
			else if(j==0 && i>0 && A[i-1] == C[i-1]){
				iTable[i][j] = iTable[i-1][j];
			}
			// the first character of C is same as first character of A but not
			// same as first character of B
			else if(i>0 && A[i-1] == C[i+j-1] && B[j-1] != C[i+j-1] ){
				iTable[i][j] = iTable[i-1][j];
			}
			// the first character of C is same as first character of B but not
			// same as first character of A
			else if(i>0 && j>0 && A[i-1] != C[i+j-1] && B[j-1] == C[i+j-1] ){
				iTable[i][j] = iTable[i][j-1];
			}
			// the first character of C is same as first character of A 
			// as well as B
			else if(i>0 && j>0 && A[i-1] == C[i+j-1] && B[j-1] == C[i+j-1] ){
				iTable[i][j] = (iTable[i-1][j] || iTable[i][j-1]);
			}
			
		}
	}
	
	return iTable[A.length-1][B.length-1];
	
}

public static void main(String[] args){
    Question019 q = new Question019();
    System.out.println(q.isInterleaved("XXY", "XXZ", "XXZXXXY"));
    System.out.println(q.isInterleaved("XY" ,"WZ" ,"WZXY"));
    System.out.println(q.isInterleaved("XY", "X", "XXY"));
    System.out.println(q.isInterleaved("YX", "X", "XXY"));
    System.out.println(q.isInterleaved("XXY", "XXZ", "XXXXZY"));
}

}
//	
//	Time Complexity: O(mn)
//	Auxiliary Space: O(mn)
