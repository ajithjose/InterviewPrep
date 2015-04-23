package pack040;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


//	Suppose you are an engineer on the Amazon Media team. Your team needs to launch a new recommendation feature called “Stuff Your Friends are Buying”.  
//	The recommendation logic is based on the following rules:
//	•	A customer should only be recommended product that their friends bought but they haven’t bought.
//	•	The recommendations priority is driven by how many friends have purchased the same item – if multiple friends purchased the same item, 
//	it should be higher in the recommendations than a product that only one friend owns.
//	
//	You are provided two library functions to help you
//	•	getFriendsListForUser – returns a list of customer IDs (strings that uniquely identify an Amazon user) representing the friends of an Amazon user
//	•	getPurchasesForUser – returns a list of product IDs (strings that uniquely identify an item in the Amazon catalog) 
//	for an Amazon user ordered by purchase time with newest purchase first in list and oldest purchase last in list
//	 
//	For this evaluation, please:
//	1)	Write a function that provides a ranked (high to low) list of recommendations (product IDs) for a provided user. 
//	You may use any IDE and framework that you are comfortable with.
//	2)	Write code for a few key unit tests for your code.
//	3)	Enumerate other unit test scenarios (code not required).
//	4)	Provide the space and time complexity of your solution.

public class Question037 {
	
	List<String> getRecommendations(String custId ){
		List<String> friends = getFriendsListForUser(custId);
		List<String> myPurchases = getPurchasesForUser(custId);
		Collections.sort(myPurchases); // mlogm
		HashMap<String, Integer> purchaseMap = new HashMap<String, Integer>();
		for(String f : friends){ // O(n)
			List<String> friendPurchases = getPurchasesForUser(f);
			List<String> friendPurchasesWithoutMyPurchases = removeMyPurchases(friendPurchases, myPurchases);// nlogm
			for(String fp : friendPurchasesWithoutMyPurchases){
				Integer prodCount = purchaseMap.get(fp);
				if(prodCount==null){
					purchaseMap.put(fp, 1);
				}else{
					purchaseMap.put(fp, prodCount+1);
				}
			}
		}
		
		return sortPurchaseMap(purchaseMap);
	}

	// Modified version of counting sort algorithm - O(m)
	private List<String> sortPurchaseMap(HashMap<String, Integer> purchaseMap) {
		
		int mapSize = purchaseMap.size();
		Product[] products = new Product[mapSize];
		
		int i=0;
		for(Entry<String,Integer> entry : purchaseMap.entrySet()){
			products[i++] = new Product(entry.getKey(), entry.getValue());
		}
		
		int[] C = new int[mapSize];
		String[] output = new String[mapSize];
		
		for(int j=0;j<mapSize;j++){
			C[products[j].getCount()-1]++;
		}
		
		for(int k=1;k<mapSize;k++){
			C[k] += C[k-1];
		}
		
		for(int k=0;k<mapSize;k++){
			output[mapSize-1-(C[products[k].getCount()-1]-1)] = products[k].getName();
			C[products[k].getCount()-1]--;
		}
		
		return Arrays.asList(output);
	}
	
	class Product{
		private String name;
		private int count;
		
		public Product(String name, int count) {
			super();
			this.name = name;
			this.count = count;
		}
		public String getName() {
			return name;
		}
		public void setName(String product) {
			this.name = product;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	}

	private List<String> removeMyPurchases(List<String> friendPurchases,
			List<String> sortedPurchases) {
		List<String> result = new ArrayList<String>(friendPurchases.size());
		for(String fp : friendPurchases){
			if(Collections.binarySearch(sortedPurchases, fp) < 0){
				result.add(fp);
			}
		}
		return result;
	}

	private List<String> getPurchasesForUser(String custId) {
		ArrayList<String> purchases = new ArrayList<String>();
		switch(custId){
		case "1":
			purchases.add("Kindle");
			purchases.add("Ipad");
			purchases.add("Wine");
			break;
		case "2": 
			purchases.add("Kindle");
			purchases.add("Ipad");
			purchases.add("Chromecast");
			break;
		case "3": 
			purchases.add("Kindle");
			purchases.add("Wine");
			purchases.add("Chromecast");
			purchases.add("Iphone");
			break;
		case "4": 
			purchases.add("Kindle");
			purchases.add("Beer");
			purchases.add("Chromecast");
			purchases.add("Iphone");
			break;
		}
		return purchases;
	}

	private List<String> getFriendsListForUser(String custId) {
		ArrayList<String> friends = new ArrayList<String>();
		switch(custId){
		case "1":
			friends.add("2");
			friends.add("3");
			friends.add("4");
			break;
		case "2": 
			friends.add("1");
			friends.add("3");
			break;
		case "3": 
			friends.add("1");
			friends.add("2");
			break;
		case "4": 
			friends.add("1");
			break;
		}
		return friends;
	}
	
	public static void main(String[] args){
		Question037 q = new Question037();
		q.test();
		/*List<String> rec = q.getRecommendations("2");
		for(int i=0;i<rec.size();i++){
			System.out.println((i+1) + " : "+rec.get(i) );
		}*/
	}

	private void test() {
		List<String> test1Result = new ArrayList<String>();
		test1Result.add("Chromecast");
		test1Result.add("Iphone");
		test1Result.add("Beer");
		assert test1Result.equals(getRecommendations("1")) : "Test 1 Failed";
		
		List<String> test2Result = new ArrayList<String>();
		test2Result.add("Wine");
		test2Result.add("Iphone");
		assert test2Result.equals(getRecommendations("2")) : "Test 2 Failed";
		
		// Other test scenarios
		// 1. Case when there are no recommendations (there are not any products which his friends have but not him)
		// 2. Case when all friends products are provided as recommendations (no common products)
		// 3. When products are synonymous (cannot be tested by the current version) like Iphone version 4 and 5
		
	}

}

// Time complexity
// n x mlogp
// n - no. of friends
// m - max no. of friend products
// p - no. of user products

// Effective time complexity from O(plogp), O(n*mlogp) and O(m)
