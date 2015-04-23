import java.util.Scanner;

/*
 * 
Matching Datasets (Bloomberg Codecon, Easy)
------------------

You've worked on a report for weeks and its all ready to submit, when all of a sudden your data is gone! 
Fortunately, you still have a hard copy of your charts, and you're able to 
estimate the approximate value of each datapoint.

When you regenerate your data, you know that the exact values of the data points will be close to 
what you eyeballed, but you don't know what order they'll be in. By finding the closest data elements, 
you'll be able to be confident in your report and the data as well.


Input Specifications

Your program will take
The number of elements K that are in each dataset.(0 <= K <= 100)
This will be followed by K lines representing the original dataset 
(which is comprised of points from the chart). Each line will be a comma separated list of values.
The final K lines after that will be the new dataset. 
Each line will be a comma separated list of values here as well.

Output Specifications

Based on the input, print out K lines where each line consists of two values where
The first value denotes the element (0,1,2...K-1) in the original dataset.
The second value, comma separated, will be the index of the closest point in the new dataset.
Note that the output should be sorted in ascending order of element indices in the original dataset.

Sample Input/Output

INPUT
3
2,1,3,5 
1,2,3,4 
3,1,2,3 
1,2,3,4 
3,1,2,3 
2,1,3,5 

OUTPUT
0,2
1,0
2,1

EXPLANATION
0,2 (row 0 in original dataset (2,1,3,5) matches row 2 in new dataset(2,1,3,5) exactly
1,0 (row 1 in original dataset (1,2,3,4) matches row 0 in new dataset(1,2,3,4) exactly
2,1 (row 2 in original dataset (3,1,2,3) matches row 1 in new dataset(3,1,2,3) exactly

INPUT
5
288.70,7.62,22,19 
770.15,78.71,20,89 
977.11,10.75,19,22 
900.54,89.79,28,19 
256.83,14.76,44,82 
256.83,14.66,44,82 
900.54,89.77,28,19 
770.15,78.71,20,88 
288.71,7.62,22,19 
977.10,10.74,19,22 

OUTPUT
0,3
1,2
2,4
3,1
4,0

EXPLANATION
0,3 (288.70,7.62,22,19 and 288.71,7.62,22,19)
1,2 (770.15,78.71,20,89 and 770.15,78.71,20,88)
2,4 (977.11,10.75,19,22 and 977.10,10.74,19,22)
3,1 (900.54,89.79,28,19 and 900.54,89.77,28,19)
4,0 (256.83,14.76,44,82 and 256.83,14.66,44,82)

 */
public class Question210 {

	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		Integer k = Integer.parseInt(stdin.nextLine());
		
		double[][] originalDataset = createNextDataset(stdin, k);
		double[][] newDataset = createNextDataset(stdin, k);		
		
		generateMatchingOutput(k, originalDataset, newDataset);

	}

	private static void generateMatchingOutput(int k, double[][] originalDataset, double[][] newDataset) {
		
		for(int i=0;i<k;i++){
			double minDistance = Double.MAX_VALUE;
			int minj = -1;
			for(int j=0;j<k;j++){
				double distance = distance(originalDataset[i], newDataset[j]);
				if(distance<minDistance){
					minDistance = distance;
					minj = j;
				}				
			}
			System.out.println(i+","+minj);
		}
		
	}

	private static double distance(double[] ds1, double[] ds2) {
		double distance = 0;
		for(int i=0;i<ds1.length;i++){
			distance += Math.abs(ds1[i]-ds2[i]);
		}
		return distance;
	}

	private static double[][] createNextDataset(Scanner stdin, Integer k) {
		double[][] dataset = null;
		for(int i=0; i<k;i++){
			String line = stdin.nextLine();
			String[] valueStrs = line.split(",");
			if(i==0){
				dataset = new double[k][valueStrs.length]; 
			}
			
			double[] values = new double[valueStrs.length];
			for(int j=0;j<valueStrs.length;j++){
				values[j] = Double.parseDouble(valueStrs[j]);
			}
			dataset[i] = values; 
		}
		return dataset;
	}

}
