import java.util.Stack;

/*
 * Arithmetic Expression Evaluation
 * ---------------------------------
 * 
 
Evaluate an expression represented by a String. Expression can contain parentheses, you can assume parentheses are well-matched. 
For simplicity, you can assume only binary operations allowed are +, -, *, and /. Arithmetic Expressions can be written in one of three forms:

Infix Notation: Operators are written between the operands they operate on, e.g. 3 + 4 .

Prefix Notation: Operators are written before the operands, e.g + 3 4

Postfix Notation: Operators are written after operands.

Infix Expressions are harder for Computers to evaluate because of the additional work needed to decide precedence. 
Infix notation is how expressions are written and recognized by humans and, generally, input to programs. 

Given that they are harder to evaluate, they are generally converted to one of the two remaining forms. 
A very well known algorithm for converting an infix notation to a postfix notation is Shunting Yard Algorithm by Edgar Dijkstra. 
This algorithm takes as input an Infix Expression and produces a queue that has this expression converted to a postfix notation. 
Same algorithm can be modified so that it outputs result of evaluation of expression instead of a queue. 
Trick is using two stacks instead of one, one for operands and one for operators.

 */

public class Question102 {

	int evaluate(String expression) {

		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		
		for(int i=0;i<tokens.length;i++){
			
			if(tokens[i] == ' '){
				continue;
			}
			
			else if(tokens[i] == '('){
				operators.push(tokens[i]);
			}
			
			else if(tokens[i] >= '0' && tokens[i] <= '9'){
				StringBuffer strBuffer = new StringBuffer();
				while(i<tokens.length && tokens[i] >= '0' && tokens[i] <= '9'){
					strBuffer.append(tokens[i]);
					i++;
				}
				i--;
				values.push(Integer.parseInt(strBuffer.toString()));
			}
			
			else if(tokens[i] == ')'){				
				while(operators.peek() != '('){
					values.push(applyMath(values.pop(), values.pop(), operators.pop()));
				}
				operators.pop();
			}
			
			else if( tokens[i] == '+' || tokens[i] == '-' ||
					 tokens[i] == '*' || tokens[i] == '/' ){
				if(!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())){
					values.push(applyMath(values.pop(), values.pop(), operators.pop()));
				}
				operators.push(tokens[i]);
			}
		}
		
		while(!operators.isEmpty()){
			values.push(applyMath(values.pop(), values.pop(), operators.pop()));
		}
		
		return values.pop();
	}
	
	boolean hasPrecedence(char op1, Character op2) {
		if(op2 == '(' || op2 == ')'){
			return false;
		}
		else if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		return true;
	}

	Integer applyMath(Integer b, Integer a, Character operator) {
		switch(operator){
			case '+' : return a + b;
			case '-' : return a - b;
			case '*' : return a * b;
			case '/' : return a / b;
		}
		return 0;
	}

	public static void main(String[] args) {
		
		Question102 q = new Question102();
		System.out.println(q.evaluate("10+2*6"));
		System.out.println(q.evaluate("100 * 2 + 12"));
        System.out.println(q.evaluate("100*(2+12)"));
        System.out.println(q.evaluate("100 * ( 2 + 12 ) / 14"));
        
	}

}
