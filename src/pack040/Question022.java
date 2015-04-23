package pack040;
// Return median of two sorted arrays

//	Question: There are 2 sorted arrays A and B of size n each. 
//	Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). 
//	The complexity should be O(log(n))
//	
//	Median: In probability theory and statistics, a median is described as the number separating the higher half of a sample, 
//	a population, or a probability distribution, from the lower half. The median of a finite list of numbers can be found 
//	by arranging all the numbers from lowest value to highest value and picking the middle one.
//	
//	For getting the median of input array { 12, 11, 15, 10, 20 }, first sort the array. 
//	We get { 10, 11, 12, 15, 20 } after sorting. Median is the middle element of the sorted array which is 12.
//	
//	There are different conventions to take median of an array with even number of elements, 
//	one can take the mean of the two middle values, or first middle value, or second middle value.
//	
//	Let us see different methods to get the median of two sorted arrays of size n each. 
//	Since size of the set for which we are looking for median is even (2n), we are taking average of middle two numbers in all below solutions.
//	
//	Method 1 (Simply count while Merging)
//	Use merge procedure of merge sort. Keep track of count while comparing elements of two arrays. 
//	If count becomes n(For 2n elements), we have reached the median. 
//	Take the average of the elements at indexes n-1 and n in the merged array.
//	Time complexity of this method is O(n)
//	
//	Method 2 (By comparing the medians of two arrays)
//	This method works by first getting medians of the two sorted arrays and then comparing them.
//	
//	Let ar1 and ar2 be the input arrays.
//	
//	Algorithm:
//	
//	1) Calculate the medians m1 and m2 of the input arrays ar1[] 
//	   and ar2[] respectively.
//	2) If m1 and m2 both are equal then we are done.
//	     return m1 (or m2)
//	3) If m1 is greater than m2, then median is present in one 
//	   of the below two subarrays.
//	    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
//	    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
//	4) If m2 is greater than m1, then median is present in one    
//	   of the below two subarrays.
//	   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
//	   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
//	5) Repeat the above process until size of both the subarrays 
//	   becomes 2.
//	6) If size of the two arrays is 2 then use below formula to get 
//	  the median.
//	    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
//	Example:
//	
//	   ar1[] = {1, 12, 15, 26, 38}
//	   ar2[] = {2, 13, 17, 30, 45}
//	For above two arrays m1 = 15 and m2 = 17
//	
//	For the above ar1[] and ar2[], m1 is smaller than m2. So median is present in one of the following two subarrays.
//	
//	   [15, 26, 38] and [2, 13, 17]
//	Let us repeat the process for above two subarrays:
//	
//	    m1 = 26 m2 = 13.
//	m1 is greater than m2. So the subarrays become
//	
//	  [15, 26] and [13, 17]
//	Now size is 2, so median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
//	                       = (max(15, 13) + min(26, 17))/2 
//	                       = (15 + 17)/2
//	                       = 16

import java.util.Arrays;

class Question022 { 

int findMedian(int[] a1, int[] a2){
	
	int n = a1.length;
	int m1, m2, i;
	
	if (n <= 0)
        return -1;
 
    if (n == 1)
        return (a1[0] + a2[0])/2;
        
	if(n == 2){
		return ((max(a1[0],a2[0])+min(a1[1],a2[1]))/2);
	}
	
	if(n%2 == 0){
		i = (n/2)-1;
	}else{
		i = n/2;
	}
	
	m1 = a1[i];
	m2 = a2[i];
	
	if(m1 == m2){
		return m1;
	}
	else if(m1<m2){
		int[] a1Next = Arrays.copyOfRange(a1,i,n);
		int[] a2Next = Arrays.copyOfRange(a2,0,i+1);
		return findMedian(a1Next,a2Next);	
	}
	else {
		int[] a1Next = Arrays.copyOfRange(a1,0,i+1);
		int[] a2Next = Arrays.copyOfRange(a2,i,n);
		return findMedian(a1Next,a2Next);	
	}
}

int min(int a, int b){
	return (a<b ? a : b);
}

int max(int a, int b){
	return (a>b ? a : b);
}
public static void main(String[] args){
	int ar1[] = {1, 12, 15, 26, 38};
    int ar2[] = {2, 13, 17, 30, 45};
    Question022 q = new Question022();
    System.out.println("Median: "+q.findMedian(ar1,ar2));
}

}

// Time complexity - O(logn)