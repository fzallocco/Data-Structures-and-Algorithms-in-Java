import java.util.*;

class RankSort{

	public void rankAlgorithmBruteForce(int[] inputArray, int[] rankArray, int[] outputArray){ /*Brute Force approach*/
		int nSize = inputArray.length; /*save length of original array*/

			for(int i = 0; i < nSize; i++){//iterate over unsorted list

			int lowestMin = inputArray[i]; //assume first has lowest rank
			int currentSum = 0; //initialize new current sum 
			for(int j = 0; j < nSize; j++){

				if(i != j){ //check if indices are different

					int currentMin = inputArray[j]; //get current minimum
					
					if(lowestMin > currentMin){ //if lowest minimum exceeds current minimum
					
						/*System.out.println("Yes, "+lowestMin+" is greater than "+currentMin);*/
						currentSum += 1; //increment current sum
					}/*else{ //use this to troubleshoot code and understand algorithm
						System.out.println("No, "+lowestMin+" is not greater than "+currentMin);
						continue;
					}*/
					rankArray[i] = currentSum; //assign current sum to rankList
				}				
			}
			//use rankList's elements as indices of sortedList and copy
			for(int m = 0; m < nSize; m++){

				outputArray[rankArray[m]] = inputArray[m]; 
			/*the value of rankList at index m becomes the index of the sortedList and sortedList's value is passed by unsortedList's m index. 
			RankList's value at index 0 is 3, and we initialize the sorted list's value at index 3 to the orginal list's value at index 0. 
			Thus, the new array's value at index 3 is 13. When m is 1, rankList's value is 1, and we assign the original list's value at index 1 to the sorted list at position 1, which is 9.*/

			}
		}

		
	}
	public static void main(String[] args){

		int[] unsortedList = {13, 9, 23, 10, 1}; //random integer list

		int[] rankList = new int[unsortedList.length]; //rank list has the same length as the random list*/
		
		int[] sortedList = new int[unsortedList.length]; //sortedList has the same length as the random list

		//compare each element of the unsorted list with the lowest rank

		RankSort newSort = new RankSort();
		newSort.rankAlgorithmBruteForce(unsortedList, rankList, sortedList);

		System.out.println("\n");
		System.out.println("this is the unsorted array: \n");
		for(int x = 0; x < unsortedList.length; x++) System.out.print(unsortedList[x]+" ");
		System.out.println("\n");
		System.out.println("this is the list of ranks of each element inside the unsorted array: \n");
		for(int z = 0; z < rankList.length; z++) System.out.print(rankList[z]+" ");
		System.out.println("\n");
		System.out.println("this is the original list sorted according to each element's rank: \n");
		for(int y = 0; y < sortedList.length; y++) System.out.print(sortedList[y]+" ");
				
	}
}