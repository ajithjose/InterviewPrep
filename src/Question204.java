/*
 * 
 Encircular (Google Interview)
 -----------------------------
 
 You have created a computer simulation of a mobile robot. 
 The robot moves on an infinite plane, starting from position (0,0). 
 Its movements are described by command string of your choosing composed of three instructions you have provided:
 
G means go forward one step
L means turn left
R means turn right
 
The movements described in the input string are repeated for an infinite time. 
Your task to find if there exists a circle, whose radius is some positive real number R, 
such that the bot never leaves it. If such a circle exists then return "YES" otherwise "NO" (without quotes). 
 
You have to complete the function string doesCircleExist(string commands) which reads the input command as argument and returns the output.

Constraints
commands will consists of only 'G', 'L' and 'R'.
1 <= length (commands) <= 2500
 
Sample Input #1
commands: "L"
Returns: "YES"
Explanation: 
Bot never moves a step in his life. It just rotate by 90 degrees at each turn.

Sample Input #2
commands: "GRGL"
Returns: "NO"

Explanation: 
Define the original direction of the robot as north. 
It will repeatedly follow the steps: Go north one step, turn right, 
go one step to east, turn left, one step to north, and so on. 
It will make an endless zig-zag path towards north-east.

Solution
---------
http://stackoverflow.com/questions/28967020/check-if-there-exists-a-circle

 */

public class Question204 {
	
	private boolean doesCircleExist(String commands){
		
		Coordinate intialCoord = new Coordinate();
		intialCoord.x = 0;
		intialCoord.y = 0;
		intialCoord.direction = 'N';
		
		Coordinate nextCoord = null;
		Coordinate  coord = intialCoord;
		for(int i=0;i<4;i++){
			nextCoord = nextCoordinate(commands, coord);
			coord = nextCoord;
		}
		
		return intialCoord.equals(nextCoord);
	}
	
	private Coordinate nextCoordinate(String commands, Coordinate coordinate) {
		char[] commandChars = commands.toCharArray();
		Coordinate nextCoordinate = new Coordinate();
		
		for(int i=0;i<commandChars.length;i++){
			switch(coordinate.direction){
			case 'N':
				switch(commandChars[i]){
				case 'G' : nextCoordinate.x = coordinate.x; nextCoordinate.y = coordinate.y+1; nextCoordinate.direction = 'N'; break;
				case 'L' : nextCoordinate.x = coordinate.x-1; nextCoordinate.y = coordinate.y; nextCoordinate.direction = 'W'; break;			
				case 'R' : nextCoordinate.x = coordinate.x+1; nextCoordinate.y = coordinate.y; nextCoordinate.direction = 'E'; break;	
				}
				break;
			case 'E':
				switch(commandChars[i]){
				case 'G' : nextCoordinate.x = coordinate.x+1; nextCoordinate.y = coordinate.y; nextCoordinate.direction = 'E'; break;
				case 'L' : nextCoordinate.x = coordinate.x; nextCoordinate.y = coordinate.y+1; nextCoordinate.direction = 'N'; break;			
				case 'R' : nextCoordinate.x = coordinate.x; nextCoordinate.y = coordinate.y-1; nextCoordinate.direction = 'S'; break;	
				}
				break;
			case 'W':
				switch(commandChars[i]){
				case 'G' : nextCoordinate.x = coordinate.x-1; nextCoordinate.y = coordinate.y; nextCoordinate.direction = 'W'; break;
				case 'L' : nextCoordinate.x = coordinate.x; nextCoordinate.y = coordinate.y-1; nextCoordinate.direction = 'S'; break;			
				case 'R' : nextCoordinate.x = coordinate.x; nextCoordinate.y = coordinate.y+1; nextCoordinate.direction = 'N'; break;	
				}
				break;
			case 'S':
				switch(commandChars[i]){
				case 'G' : nextCoordinate.x = coordinate.x; nextCoordinate.y = coordinate.y-1; nextCoordinate.direction = 'S'; break;
				case 'L' : nextCoordinate.x = coordinate.x+1; nextCoordinate.y = coordinate.y; nextCoordinate.direction = 'E'; break;			
				case 'R' : nextCoordinate.x = coordinate.x-1; nextCoordinate.y = coordinate.y; nextCoordinate.direction = 'W'; break;	
				}
				break;
			}
			coordinate = nextCoordinate;
		}
		return nextCoordinate;
	}

	public static void main(String[] args) {
		Question204 q = new Question204();
		String command = "L";
		if(q.doesCircleExist(command)){
			System.out.println("Circle exists.");
		}else{
			System.out.println("Circle does not exist.");
		}
		
	}

}

class Coordinate{
	
	int x;
	int y;		
	char direction;
	
	public boolean equals(Coordinate obj) {		
		return this.x == obj.x && this.y == obj.y && this.direction == obj.direction;
	}
}

// Time complexity - O(n)
