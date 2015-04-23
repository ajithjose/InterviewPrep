import java.util.Scanner;

/*
 * 
Mug Color Problem
------------------

Jay S. has got himself in trouble! He had borrowed a friend's coffee mug and somehow lost it. 
As his friend will be extremely angry when he finds out about it, 
Jay has decided to buy his friend a replacement mug to try to control the damage. 
Unfortunately, Jay does not remember the color of the mug he had borrowed. 
He only knows that the color was one of White, Black, Blue, Red or Yellow. 
Jay goes around his office asking his colleagues if they are able to recall the color 
but his friends don't seem to remember the color of the mug either. 
What they do know is what color the mug definitely was not.
Based on this information, help Jay figure out what the color of the mug was.

Input Specifications

Your program will take
An input N (1 <= N <= 1,000,000) which denotes the number of people Jay questions regarding the mug.
This will be followed by N strings S[1],S[2]...S[N] where S[I] denotes the response of person I to Jay's question 
which is what color the mug definitely was not. S[I] will also be only one of the 5 colors 
namely White, Black, Blue, Red or Yellow.

Output Specifications

Based on the input, print out the color of the mug. 
The color of the mug can only be one of the 5 colors namely White, Black, Blue, Red or Yellow. 
You can safely assume that there always exists only one unique color that the mug can have.

Sample Input/Output

INPUT
4 
White 
Yellow 
Blue 
Black 

OUTPUT
Red

EXPLANATION
Jay's colleagues have mentioned every color except Red so the mug is Red in color

INPUT
9
White
Yellow
Blue
Black
Black
White
Yellow
Blue
Black

OUTPUT
Red

EXPLANATION
Similar to the above case, the only color not mentioned is Red

 */
public class Question202 {

	private static String findMugColor(int n, String[] colors) {
		
		String[] colorArr = createMugColorMap();
		int[] colorCountArr = new int[5];
		
		for(String col : colors){
			switch(col){
				case "White" :  colorCountArr[0]++; break;
				case "Black" :  colorCountArr[1]++; break;
				case "Blue" :  colorCountArr[2]++; break;
				case "Red" :  colorCountArr[3]++; break;
				case "Yellow" :  colorCountArr[4]++; break;
				default : throw new RuntimeException("Unknown color");
			}
		}
		
		int minIndex = 0;
		for(int i=1; i<colorCountArr.length;i++){
			if(colorCountArr[i]<colorCountArr[minIndex]){
				minIndex = i;
			}
		}
		
		return colorArr[minIndex];
	}

	private static String[] createMugColorMap() {
		String[] colorArr = new String[5];
		colorArr[0] = "White";
		colorArr[1] = "Black";
		colorArr[2] = "Blue";
		colorArr[3] = "Red";
		colorArr[4] = "Yellow";
		return colorArr;
	}

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = Integer.parseInt(stdin.nextLine());
		String[] colors = new String[n];
		
		for(int i=0;i<n;i++){
			colors[i] = stdin.nextLine();
		}
		
		String mugColor = findMugColor(n, colors);
		
		System.out.println("The mug color is "+mugColor);
		stdin.close();
	}

}
