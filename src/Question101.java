
/*
 * Program to check if a string is a palindrome or not
 * ----------------------------------------------------
 */
public class Question101 {
	
	boolean isPalindrome(String str){
		
		int len = str.length();
		for(int i=0;i<len/2;i++){
			if(str.charAt(i) != str.charAt(len-i-1)){
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		Question101  q = new Question101();
		System.out.println("MALAYALAM :: "+q.isPalindrome("MALAYALAM"));
		System.out.println("MONKEY :: "+q.isPalindrome("MONKEY"));
		System.out.println("MAAM :: "+q.isPalindrome("MAAM"));

	}

}
