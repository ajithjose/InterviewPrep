package pack060;
//  Program to find nth fibonacci number

//	nth fibonacci number is represented by f(n) = f(n-1) + f(n-2) 
//  f(0) = 0, f(1) = 1 

class Question047 {
	
	int fib1(int n){
		if(n<=1) return n;
		return fib1(n-1) + fib1(n-2);
	}

	int[] memo;
	
	void initialize1(int n){
		memo = new int[n];
		for(int i=0;i<memo.length;i++){
			memo[i]=-1;
		}
	}
	
	int fib2(int n){
		if(memo[n] == -1){
			if(n<=1){
				memo[n] = n;
			}else{
				memo[n] = fib2(n-1) + fib2(n-2);
			}
		}
		return memo[n];
	}
	
	public void test1(){
		initialize1(25);
		System.out.println("20th fibonacci no. is : "+fib2(20));
	}
	
	int fib3(int n){
		int[] table = new int[n+1];
		table[0] = 0; table[1] = 1;
		for(int i=2; i<=n; i++){
			table[i] = table[i-1] + table[i-2];
		}
		return table[n];
	}
	
	public void test2(){
		System.out.println("20th fibonacci no. is : "+fib(20));
	}
	
	int fib(int n){
		int a = 0, b= 1, c;
		for(int i=2; i<=n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
	
	public static void main (String[] args) 
    {
		Question047 q = new Question047();
		q.test1();
		q.test2();
    }
}

// Time complexity - O(n)
// Space complexity - O(1)
