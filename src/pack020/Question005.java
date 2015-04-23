package pack020;


class Question005 { 

void permutation(char[] inputString, int i, int n){
	if(i==n){
		System.out.println(inputString);
	}
	else{
		for(int j=i;j<n;j++){
			swap(inputString, i, j);
			permutation(inputString, i+1, n);
			swap(inputString, i, j); //backtrack
		}
	}
}

void swap(char[] inputString, int i, int j){
	char temp = inputString[i];
	inputString[i] = inputString[j];
	inputString[j] = temp;
}

public static void main(String[] args){
    Question005 q = new Question005();
    String input = "abc";
    q.permutation(input.toCharArray(), 0, input.length() );
}

}

// O(n) = O(n!*n)