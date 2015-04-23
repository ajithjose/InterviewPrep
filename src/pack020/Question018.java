package pack020;



class Question018 { 

boolean isInterleaved(String A, String B, String C){
	
	char[] achars = A.toCharArray();
	char[] bchars = B.toCharArray();
	char[] cchars = C.toCharArray();
	
	int aIterator=0,bIterator=0;
	for(int i=0; i<cchars.length; i++){
		if(aIterator < achars.length && achars[aIterator] == cchars[i]){
			aIterator++;
		}
		else if(bIterator < bchars.length && bchars[bIterator] == cchars[i]){
			bIterator++;
		}
		else{
			return false;
		}
	}
	if(aIterator!=achars.length || bIterator!=bchars.length){
		return false;
	}
	return true;
}

public static void main(String[] args){
    Question018 q = new Question018();
    if(q.isInterleaved("AB","CD","ACBG")){
    	System.out.println("Yes, interleaving");
    }else{
    	System.out.println("No interleaving");
    }
}

}

// Time complexity - O(m+n)