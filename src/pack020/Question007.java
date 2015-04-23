package pack020;


import java.util.HashMap;

class Question007 { 
	
boolean canWriteNote(String article, String note)
{
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    char[] articleChars = article.toCharArray();
    char[] noteChars = note.toCharArray();
    for(char c : articleChars)
    {
        if(map.get(c) == null)
             map.put(c, 1);
        else
             map.put(c,map.get(c)+1); 
    }
    for(char c : noteChars)
    {        
        if(map.get(c) == null || map.get(c) == 0)
            return false;
        else
            map.put(c,map.get(c)-1);
    }
    return true;
}
public static void main(String[] args){
    Question007 q = new Question007();
    System.out.println(q.canWriteNote("hello world","hello"));
}

}

// Time complexity - O(n)