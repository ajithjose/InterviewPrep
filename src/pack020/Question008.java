package pack020;


import java.util.HashMap;

class Question008 { 

void listArticlesContainingNote(String[] articles, String note){
	char[] noteChars = note.toCharArray();
	HashMap<Character, Integer> noteMap = new HashMap<Character, Integer>();
	for(char c : noteChars){
		if(noteMap.get(c) == null){
			noteMap.put(c, 1);
		}else{
			noteMap.put(c, noteMap.get(c)+1);
		}
	}
	for(String article : articles){
		Boolean containsNote = true;
		HashMap<Character, Integer> aMap = new HashMap<Character, Integer>();
		aMap.putAll(noteMap);
		char[] articleChars = article.toCharArray();
		for(char c : articleChars){
			if(aMap.get(c) != null && aMap.get(c) != 0){
				aMap.put(c, aMap.get(c)-1);
			}
		}
		for(Character c : aMap.keySet()){
			if(aMap.get(c)!=0){
				containsNote = false;
				break;
			}
		}
		if(containsNote)
			System.out.println(article);
	}
}

public static void main(String[] args){
    Question008 q = new Question008();
    String[] articles = {"hello world","sunday","utensils","just","sss"};
    q.listArticlesContainingNote(articles, "sun");
}

}

// Time complexity - O(m x n)
// m - no. of articles
// n - maximum no. of characters in an article