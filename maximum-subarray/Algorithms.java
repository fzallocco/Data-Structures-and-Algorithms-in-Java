/*************************************************************************
*
*  Pace University
*  Spring 2023
*  Algorithms and Computing Theory
*  Date: May 6, 2023. This version includes the team's revised conclusion with comparison of algorithms' speeds by digits and answer to the extra credit question
*  Course: CS 608
*  Team members: Filippo Zallocco, Ananthula Saivyshnav, Lokeshwar Anchuri, Sakshi Singh
*  Other collaborators: Professor Chaudhari, Daulet Kapezov
*  References: Divide & Conquer Algorithm In 3 Minutes - YouTube
*  Maximum sum sub-array - YouTube
*  Maximum Subarray - Amazon Coding Interview Question - Leetcode 53 - Python - YouTube
*  https://www.youtube.com/watch?v=86CQq3pKSUw&t=300s , Kadane's Algorithm to Maximum Sum Subarray Problem
*  https://www.interviewbit.com/blog/maximum-subarray-sum/#:~:text=Kadane%27s%20Algorithm%20is%20an%20iterative,ending%20at%20the%20previous%20position.
*
*  Assignment No.: 1
*  Problem: Explain the problem asked in 1-2 lines
* The prompt asks the user to find the maximum contiguous subarray inside the integer data type Myarray with both brute force method and divide and conquer and measure the time difference.
*
*  Input:  1000, 10,000, 100,000, 1,000,000
*  Output: 2175, 22,373, 224,007, 2,248,905
*
*  Visible data fields: int array[]
*
*
* Problem 1.
* PROVIDE YOUR WRITTEN RESPONSE. IF THE QUESTION IS A CODING QUESTION JUST PROVIDE YOUR CODE AS ASKED BELOW.
*
* Problem 2. All times reported are in nanoseconds
*                     n = 10^3   n = 10^4     n = 10^5     n = 10^6
* Brute force   16691701, 82481995, 6512468801, 583704830400
* Divide and conquer  9019100, 152591071, 4343266500, 432605815301
*
*
*
*
*
* Problem 3.
* PROVIDE YOUR WRITTEN RESPONSE. IF THE QUESTION IS A CODING QUESTION *JUST PROVIDE YOUR CODE AS ASKED BELOW.
*The running times of the divide and conquer methods do not match with the running times of the brute force method.
*The time difference between the execution of brute force and divide and conquer are given below:
*
*************************************************************************************************
*Array Size: 1000, 10,000, 80,000, 100,000, 1,000,000, type of function
*Brute force:9156500,83424308,2240908273, 6512468801,583704830400 O(n^2) slowest
*Divide and Conquer:15543700,10484151, 2239965316, 4343266500,432605815301 O(NLog(N)) least slowest
*Kadane's Algorithm:472800,3056999,22514509,XXXXXXX, XXXXXXXX, O(n) fastest method - dynamic computing -
*T(BF)-T(DC):7672601,72940157,2169202301, XXXXXX, 151099015100
*************************************************************************************************
*This conclusion includes findings from running the extra-credit algorithm - Kadane's algorithm -
*
*In the above table, the time derived is in nanoseconds, and we found that the brute force method is the least-performing algorithm to solve the maximum subarray problem. Divide and conquer and Kadane's algorithms are notably more efficient than Brute Force.
*This difference becomes more evident when repeating the same test of all three methods on the same array, especially as the size of the array increases.
*For example, if we consider an array with size 1000, Bruteforce calculates the max subarray sum in 9156500 nanoseconds, Divide and Conquer solves the same problem in 15543700 nanoseconds, and Kadane outpaces the previous two algorithms performing the same operation in 472800 nanoseconds.
*This information shows that on small-scale arrays, Kadane's algorithm is the best-performing one, followed by Bruteforce and Divide and Conquer. Comparing the first with the subsequent algorithms' digits, we count five digits for Kadane's speed, seven digits for Bruteforce, and 8 digits for Divide and Conquer.
*Upon repeating the speed test on an array with size 10000, we learned that Kadane leads again in solving the max subarray problem with a speed of 3056999 nanoseconds (7 digits), followed by Divide and Conquer and Bruteforce with 10484151 nanoseconds (8 digits) and 83424308 nanoseconds (8 digits) respectively.
*Increasing the array size to 80000, we confirm that Kadane still outpaces all the other algorithms, solving the max subarray problem in 22514509 nanoseconds (8 digits), followed by Divide and Conquer with a speed of 2239965316 nanoseconds (10 digits) and Bruteforce with pace of 2240908273 nanoseconds (10 digits).
*The time complexity for finding the maximum subarray using the brute force method is O(N^2) whereas the time complexity of Divide and Conquer and Kadane's algorithms are O(NLog(N)) and O(n), respectively. Using Big-O notation, we hope to convey why Kadane outperforms all three methods.
*The reason why Bruteforce lags behind Divide and Conquer, and Kadane's algorithm is because it involves iterating through all possible subarrays of a given array and calculating their sums, additional steps that inevitably slow down the algorithm's execution.
*However, the same cannot be said about Divide and Conquer despite edging Bruteforce's number of digits in execution speed. This algorithm's approach recursively halves the array and finds the maximum subarray sums to ultimately combine them.
*Kadane's algorithm offers an optimized approach to solving the maximum subarray problem with a sequential one-time analysis of each index through the entire array. At each index, it compares its maximum sum variable with its current sum variable, updating the latter sequentially or updating the former whenever the current sum exceeds it.
*Because of Kadane's dynamic approach to the problem, we conclude that it is the best-performing algorithm out of the three, regardless of the array' size.
*************************************************************************/
import java.util.*;
import java.lang.Math;

public class Algorithms{

  //Bruteforce
  public int MaxSubArray(int[] nums) {
      if(nums == null || nums.length == 0)
          return 0;
      int maximum_Sum =Integer.MIN_VALUE;

      for(int i = 0; i < nums.length; i++)
      {
          int current_Sum = 0;

          for(int j = i; j < nums.length; j++)
          {
              current_Sum += nums[j];
              maximum_Sum = Math.max(maximum_Sum, current_Sum);
          }
      }

      return maximum_Sum;
  }//end of Bruteforce

  //DivideandConquer
  public int maxsubarray(int array[], int low, int high)  {
      if(high==low) {
        return array[low];
      }
      int mid = (int)Math.floor((low+high)/2);
      int leftsum = maxsubarray(array, low, mid);
      int rightsum = maxsubarray(array, mid+1, high);
      int crossum = maxcrossingsubarray(array, low, high, mid);
      return Math.max(Math.max(crossum, leftsum), rightsum);
    }

    public int maxcrossingsubarray(int array[], int low, int high, int mid) {
      int leftsum = Integer.MIN_VALUE;
      int sum = 0;
      for (int i = mid; i>=1; i--) {
        sum = sum + array[i];
        if (sum>leftsum)
          leftsum = sum;
      }//end of for loop
      int rightsum = Integer.MIN_VALUE;
      int rsum = 0;
      for (int i = mid; i<=high; i++) {
          rsum = rsum + array[i];
          if(rsum > rightsum)
            rightsum = rsum;
      }//end of for loop
      //return leftsum + rightsum;
      return Math.max(leftsum + rightsum - array[mid],
                        Math.max(leftsum, rightsum));
    }//end of maxcrossingsubarray
//end of DivideandConquer

public int Kadane(int[] arr){
//Kadane's algorithm solves the max subarray sum problem by assuming that both current and global Max are equal to a given array's value at index 0.
//Starting from index 1 onward, Kadane examines whether each values at any index is greater than the sum of the value at the index at hand plus the previous current Max.
  int Max_current = arr[0];

  int Max_global = arr[0];

  for(int x=1; x<arr.length-1; x++){

    Max_current = Math.max(arr[x], Max_current+arr[x]);
//Based on the outcome of the first operation, Kadane then tests whether the new current Max is greater than the previous global Max.
    if(Max_current > Max_global){
//If the tests turns out to be true, then global Max is re-initialized to the value of current Max
      Max_global = Max_current;

    }//end of if-statement


  }//end of for-loop
//Finally, Kadane returns the value held by gloabl Max whether it is from a previous or current test. Global Max represents the max subarray sum at a given array index.
  return Max_global;
//Kadane's algorithm's time complexity is O(n) for all cases.
}//end of method

public static void main(String[] args) {

  System.out.println("Enter size of the array as powers of ten: ");
  Scanner sc = new Scanner(System.in);
  int userSize = sc.nextInt();
  int Myarray[] = new int[userSize];

  Algorithms msa = new Algorithms();

  System.out.println(" ");
  Random myrandomInt = new Random();
  for(int x=0; x<Myarray.length; x++) {

    Myarray[x]= Math.abs(myrandomInt.nextInt()%10);

    if(myrandomInt.nextInt()%2 == 1) {
      Myarray[x]=Myarray[x] * (-1);
    }
    //System.out.print(Myarray[x]+" ");

  }//end of for loop
  System.out.println(" \n");
  long startTime1 = System.nanoTime();
  System.out.println("Runnning Bruteforce algorithm yields: " +msa.MaxSubArray(Myarray));
  System.out.println(" \n");
  System.out.println("time of Bruteforce algorithm's execution =	"+(System.nanoTime()	- startTime1)+"	nanosecs.\n");
  System.out.println(" \n");
  long startTime2 = System.nanoTime();
  System.out.println("Runnning DivideandConquer algorithm yields: " +msa.maxsubarray(Myarray,0,userSize-1));
  System.out.println(" \n");
  System.out.println("time of DivideandConquer's execution =	"+(System.nanoTime()	- startTime2)+"	nanosecs.");
  long startTime3 = System.nanoTime();
  int MaxSubarray = msa.Kadane(Myarray);
  System.out.println("MaxSubarray sum using Kadane's algorithm returns as sum: " + MaxSubarray);
  System.out.println(" \n");
  System.out.println("time of Kadane's algorithm's execution=	"+(System.nanoTime()	- startTime3)+"	nanosecs.");
}//end of main

}//end of class
