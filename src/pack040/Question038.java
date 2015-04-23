package pack040;
// Print the elements of an array in the decreasing frequency if 2 numbers have same frequency then print 
// the one which came 1st
// E.g. 2 5 2 8 5 6 8 8 output: 8 8 8 2 2 5 5 6.

import java.util.HashMap;

public class Question038 { 

void sortWrtFrequency(int[] A){

	HashMap<Integer, NumCount> countMap = new HashMap<Integer, NumCount>();
	NumCount[] numCountArray = new NumCount[A.length];
	int nci = 0;
	for(int i=0;i<A.length;i++){
		NumCount nc;
		if(countMap.get(A[i]) == null){
			nc = new NumCount(A[i], 1, i);					
			countMap.put(A[i], nc);
			numCountArray[nci++] = nc;
		}else{
			nc = countMap.get(A[i]);
			nc.setCount(nc.getCount()+1);
		}
	}

	int ncii=nci;
	for(int i=0; i<nci; i++){
		int ic = numCountArray[i].getCount();
		if(ic >1){
			while(ic>1){
				ic--;
				numCountArray[ncii++] = numCountArray[i];
			}
		}
	}

	countingSort(numCountArray);

	A[0] = numCountArray[0].getNum();
	int prevNum = A[0] ;
	int prevCount = numCountArray[0].getCount();

	for(int i=1;i<numCountArray.length;i++){
		if(prevNum != numCountArray[i].getNum() && prevCount == numCountArray[i].getCount()){
			if(numCountArray[i].getIndex() < numCountArray[i-1].getIndex()){
				for(int j=1;j<=numCountArray[i].getCount();j++){
					A[i-j] = numCountArray[i].getNum();
					A[i+j-1] = numCountArray[i-1].getNum();
				}
				i+=numCountArray[i].getCount();
			}			
		}else{
			A[i] = numCountArray[i].getNum();
		}
		prevNum = numCountArray[i].getNum();
		prevCount = numCountArray[i].getCount();
	}
}

void countingSort(NumCount[] N){
	
	int[] C = new int[N.length];
	NumCount[] output = new NumCount[N.length];
	for(int i=0; i<N.length; i++){
		C[N[i].getCount()-1]++;
	}

	for(int i=1; i<N.length; i++){
		C[i] += C[i-1];
	}

	for(int i=0; i<N.length; i++){
		output[N.length-1-(C[N[i].getCount()-1]-1)] = N[i];
		C[N[i].getCount()-1]--;
	}

	for(int i=0; i<N.length; i++){
		N[i] = output[i];
	}	

}

class NumCount{
	private int num;
	private int count;
	private int index;

	public NumCount(int num, int count, int index){
		this.num = num;
		this.count = count;
		this.index = index;
	}

	public int getNum(){
		return this.num;
	}

	public int getCount(){
		return this.count;
	}

	public int getIndex(){
		return this.index;
	}

	public void setCount(int c){
		this.count = c;
	}
}

public static void main(String[] args){
    Question038 q = new Question038();
	int[] A = {2, 5, 2, 8, 5, 6, 8, 8};
	q.sortWrtFrequency(A);
	for(int a : A){
    	System.out.print(a+" ");
	}
}

}

//	Time Complexity - O(n)
//	Space Complexity - O(n)