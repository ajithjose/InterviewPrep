package pack060;
// Maximum size square sub-matrix with all 1s

//	Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
//	
//	For example, consider the below binary matrix.
//	
//	 
//	   0  1  1  0  1 
//	   1  1  0  1  0 
//	   0  1  1  1  0
//	   1  1  1  1  0
//	   1  1  1  1  1
//	   0  0  0  0  0

//	The maximum square sub-matrix with all set bits is
//	
//	    1  1  1
//	    1  1  1
//	    1  1  1
//	    
//	Algorithm:
//	Let the given binary matrix be M[R][C]. The idea of the algorithm is to construct an auxiliary size matrix S[][] 
//	in which each entry S[i][j] represents size of the square sub-matrix with all 1s including M[i][j] 
//	where M[i][j] is the rightmost and bottommost entry in sub-matrix.
//	
//	1) Construct a sum matrix S[R][C] for the given M[R][C].
//	     a)	Copy first row and first columns as it is from M[][] to S[][]
//	     b)	For other entries, use following expressions to construct S[][]
//	         If M[i][j] is 1 then
//	            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
//	         Else /*If M[i][j] is 0*/
//	            S[i][j] = 0
//	2) Find the maximum entry in S[R][C]
//	3) Using the value and coordinates of maximum entry in S[i], print 
//	   sub-matrix of M[][]
//	For the given M[R][C] in above example, constructed S[R][C] would be:
//	
//	   0  1  1  0  1
//	   1  1  0  1  0
//	   0  1  1  1  0
//	   1  1  2  2  0
//	   1  2  2  3  1
//	   0  0  0  0  0
//	   
//	The value of maximum entry in above matrix is 3 and coordinates of the entry are (4, 3). 
//	Using the maximum value and its coordinates, we can find out the required sub-matrix.

class Question042 { 

int[][] findMaxSubMatrixWithAllOnes(int[][] M){

	int[][] P = new int[M.length][M.length];
	
	for(int i=0; i<M.length; i++){
		P[0][i] = M[0][i];
		if(i>0)
			P[i][0] = M[i][0];
	}
	
	for(int i=1; i<P.length; i++){
		for(int j=1; j<P.length; j++){
			if(M[i][j] == 1){
				P[i][j] = minimum(P[i][j-1], P[i-1][j], P[i-1][j-1]) + 1;
			}
			else{
				P[i][j] = 0;
			}
		}		
	}

	int maxIndex = 0;
	for(int i=0; i<P.length; i++){
		for(int j=0; j<P.length; j++){
			if(P[i][j]>maxIndex){
				maxIndex = P[i][j];
			}
		}
	}

	int[][] Q = new int[maxIndex][maxIndex];
	for(int i=0; i<maxIndex; i++){
		for(int j=0; j<maxIndex; j++){
			Q[i][j] = 1;
		}
	}

	return Q;
}

int minimum(int i, int j, int k){
	if(i<j && i<k){
		return i;
	} else if(j<k){
		return j;
	} else {
		return k;
	}
}

public static void main(String[] args){
    Question042 q = new Question042();

	int[][] A = {new int[]{1,0,0,1,1},
				 new int[]{0,1,1,1,0},
				 new int[]{1,1,1,1,1},
				 new int[]{0,0,1,1,1},
				 new int[]{1,0,1,1,1}};

	int[][] B = q.findMaxSubMatrixWithAllOnes(A);
	
	for(int i=0; i<B.length; i++){
		for(int j=0; j<B.length; j++){
			System.out.print(B[i][j]+" ");
		}
		System.out.println("");
	}    
}

}

//	Time complexity - O(n*n)
//	Space complexity - O(n*n)