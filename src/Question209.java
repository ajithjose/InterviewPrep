import java.util.Scanner;

/*
 * 

Messed Up Rugby (Bloomberg Codecon)
----------------

A team of developers from New York visits London and decides to try their hands at Rugby. 
None of them quite remember the exact rules so they just use the rules of American Football 
where you can score 2, 3 or 7 points at a time.

When they talk to you afterwards, they tell you that the final score of the game was 38 - 0. 
After facepalming, you are curious to find all possible ways to score 38 points.

Write a program that, given a score X, prints all possible combinations of the messed up 
conversions (7 points), tries (3 points), and kicks (2 points) that would make up this score.


Input Specifications

Your program will take a target score between 0 and 222.

Output Specifications

Based on the input, print out one row for each combination of messed up conversions, 
tries, and kicks that would get to that score, each column delimited by a space. 
The output should be in ascending order of touchdowns, field goals, and then safeties. 
If the score is not achievable, just output 0 0 0

Sample Input/Output

INPUT
10
OUTPUT
0 0 5
0 2 2
1 1 0
EXPLANATION
There are three possible ways to reach a score of 10 given the rules above.

INPUT
17
OUTPUT
0 1 7
0 3 4
0 5 1
1 0 5
1 2 2
2 1 0
EXPLANATION
There are six possible ways to reach a score of 10 given the rules above.

 */
public class Question209 {
	
	private static void findScoringCombinations(int n) {
		
		int maxConversions = n/7;
		int maxTries = n/3;
		int maxKicks = n/2;
		
		int conv=0, trie=0, kick=0;
		int i=0, j=0, k=0;
		for(i=0;i<=maxConversions;i++){
			conv = 7*i;
			if(conv == n){
				System.out.println(i + " " + j + " " + k);
				break;
			}
			for(j=0;j<=maxTries;j++){
				trie = 3*j;
				if(conv+trie == n){
					System.out.println(i + " " + j + " " + k);
					j = 0; k = 0;
					break;
				}
				if(conv+trie > n){
					j = 0; k = 0;
					break;
				}
				
				for(k=0;k<=maxKicks;k++){
					kick = 2*k;
					if(conv+trie+kick == n){
						System.out.println(i + " " + j + " " + k);
						k = 0;
						break;
					}
					if(conv+trie+kick > n){
						k = 0;
						break;
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		int n = Integer.parseInt(stdin.nextLine());
		findScoringCombinations(n);
		stdin.close();
	}


}
