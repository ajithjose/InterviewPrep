/*
 * 
 * Stock Buy Sell to Maximize Profit
 * ----------------------------------
 * 
	 The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days. 
	 For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, 
	 selling on day 3. Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, 
	 then profit cannot be earned at all.
	
	If we are allowed to buy and sell only once, then we can use maximum difference between two elements. 
	Here we are allowed to buy and sell multiple times. Following is an algorithm for this problem.
	
	1. Find the local minima and store it as starting index. If not exists, return.
	2. Find the local maxima. and store it as ending index. If we reach the end, set the end as ending index.
	3. Update the solution (Increment count of buy sell pairs)
	4. Repeat the above steps if end is not reached.
 
 * 
 */
public class Question107 {
	
	class Stock{
		int buy;
		int sell;
	}
	
	private void stockBuySell(int[] price) {
		
		int n = price.length;
		
		int i=0;
		
		Stock[] stocks = new Stock[(n/2)+1];
		
		int count = 0;
		
		while(i<n-1){
			
			while(i<(n-1) && price[i] >= price[i+1]){
				i++;
			}
			
			if(i==(n-1)){
				break;
			}
			
			stocks[count] = new Stock();
			stocks[count].buy = i++;
			
			while(i<n && price[i-1] <= price[i]){
				i++;
			}
			
			stocks[count].sell = i-1;
			count++;
			
		}
		
		if(count ==0){
			System.out.println("No stocks to buy.");
		}else{
			for(int j=0;j<count;j++){
				System.out.println("Buy :: "+price[stocks[j].buy]+" | "+"Sell :: "+price[stocks[j].sell]);
			}
		}
		
	}

	public static void main(String[] args) {
		Question107 q = new Question107();
		
		int price[] = {100, 180, 260, 310, 40, 535, 695}; 
		
		q.stockBuySell(price);

	}

	
}

// Time complexity - O(n)
