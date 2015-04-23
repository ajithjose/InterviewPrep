import java.util.HashMap;

/*
 * 
Sparse Matrix Vector Multiplication
-------------------------------------

Multiply a sparse matrix (matrix with most values as zeroes) with a vector.

Solution
---------
Use a hashmap to represent each row of the matrix. The hashmap keys would be the non-zero column indices and the values would be the non-zero values.

 * 
 */
public class Question154 {

	public static void main(String[] args) {
		double[][] matrix = {{		0,	  0.90, 	 	0,	 	   0,	 	   0},
						     {		0,  	 0,  	 0.36, 		0.36, 		0.18},
						     {		0,		 0, 	    0, 		0.90, 		   0},
						     {	 0.90,		 0, 		0, 		   0,		   0},
						     {	 0.47,		 0, 	 0.47, 		   0,		   0}};
		double[] vector =    {	 0.05, 	  0.04,      0.36,      0.37,       0.19}; 
		
		SparseVector[] sparseVector = new SparseVector[matrix.length];
		for(int i=0;i<matrix.length;i++){
			sparseVector[i] = new SparseVector(matrix[i]);
		}
		
		double[] result = new double[vector.length];
		
		for(int i=0;i<result.length;i++){
			result[i] = sparseVector[i].dotProduct(vector);
		}
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}

	}

}

class SparseVector{
	
	HashMap<Integer, Double> hm;
	
	public SparseVector(){
		hm = new HashMap<Integer, Double>();
	}
	
	public SparseVector(double[] row){
		hm = new HashMap<Integer, Double>();
		for(int i=0;i<row.length;i++){
			if(row[i] != 0) hm.put(i, row[i]);
		}
	}
	
	public Double dotProduct(double[] vector){
		Double sum = 0d;
		for(int i : hm.keySet()){
			sum += hm.get(i)*vector[i];
		}
		return sum;
	}
	
}