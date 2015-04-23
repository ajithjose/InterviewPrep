package pack020;


// Algorithm:
// 1) Reverse the individual words, we get the below string.
//     "i ekil siht margorp yrev hcum"
// 2) Reverse the whole string from start to end and you get the desired output.
//     "much very program this like i"


class Question009 { 

String reverseWords(String sentence){
	char[] sentenceChars = sentence.toCharArray();
	int j=0;
	for(int i=0;i<sentenceChars.length;i++){
		if(sentenceChars[i] == ' '){
			reverse(sentenceChars, j, i-1);
			j=i+1;
		}else if(i==sentenceChars.length-1){
			reverse(sentenceChars, j, i);
		}
	}
	
	reverse(sentenceChars, 0, sentenceChars.length-1);
	
	return new String(sentenceChars);
}

void reverse(char[] sentenceChars, int start, int end){
	while(start<end){
		char temp = sentenceChars[start];
		sentenceChars[start] = sentenceChars[end];
		sentenceChars[end] = temp;
		start++;
		end--;
	}
}

public static void main(String[] args){
    Question009 q = new Question009();
    System.out.println(q.reverseWords("hello how are you"));
}

}

// Time complexity - O(n)