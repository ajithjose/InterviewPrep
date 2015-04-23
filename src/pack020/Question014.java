package pack020;


// The idea is to maintain two states: IN and OUT. The state OUT indicates that a separator is seen. 
// State IN indicates that a word character is seen. 
// We increment word count when previous state is OUT and next character is a word character.

class Question014 { 

int findNoOfWords(String sentence){
	char[] sentenceChars = sentence.toCharArray();
	int wordCount = 0;
	boolean outState = true;
	
	for(int i=0;i<sentenceChars.length;i++){
		if(sentenceChars[i] == '\b' || sentenceChars[i] == '\n' || sentenceChars[i] == '\t' || sentenceChars[i] == ' '){
			outState = true;
		}else if(outState){
			wordCount++;
			outState = false;
		}
	}
	return wordCount;
}

public static void main(String[] args){
    Question014 q = new Question014();
	String sentence = " geeks are 	for geeks ";
    System.out.println("No. of words in sentence is: " + q.findNoOfWords(sentence));
}

}

//Time complexity O(n)