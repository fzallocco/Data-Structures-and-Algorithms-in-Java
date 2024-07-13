/*************************************************************************
*  Pace University
*  Spring 2023
*  Algorithms and Computing Theory
*
*  4/16/2023
*  Course: CS 608
*  Team members: Filippo Zallocco, Ananthula Saivyshnav, Lokeshwar Anchuri, Sakshi Singh
*  Other collaborators: none
*
*  References:
*
*  Visible data fields: double data type
*
* Question 3:
*
*n =1,000
Time = 563,300 nano seconds
*
n = 10,000
Time = 3,088,100 nano seconds
*
n = 100,000
Time = 46,265,300 nano seconds
*
n = 1,000,000
Time = 204,219,400 nano seconds
*
n = 10,000,000
Time = 1,722,942,800
*
n = 100,000,000
Time = 15,037,076,900
*
* Question 5.
*We generated an array of distance of points in a unit circle through a given algorithm. All the points generated in the array are from
*(0,1] of double data type to get the highest precision possible. Then, we applied quick sort with the median as the pivot as it offers a
*better complexity than the first element as the pivot which is Θ(N Log N) from best to worst case scenario. We set the array size between
*1,000 to 100,000,000, and we observed that the time taken by the algorithm to sort the array grows as the function of NLog(N) for sorting
*the double values .

*Sorting uniformly distributed points on a unit circle can have various benefits, such as aiding in computer graphics, image processing,
*and signal processing. Sorting assists in establishing the sequence of points on the circle, which can be crucial in numerous algorithms
*that require the points to be arranged in a specific order. For instance, sorting uniformly distributed points on a unit circle can be
*helpful in drawing curves and other shapes in computer graphics. By connecting the sorted points, we can draw arcs, circles, or other
*geometric shapes with smooth edges.
*************************************************************************/
import java.lang.Math;
import java.util.*;
class Circle{

  public static double pointDistance(){

    //Math.random() generates all the numbers between 0(included) and 1 (excluded)

    double t = 2*Math.PI*Math.random(); //Radiant value generated with Random number and Pi from Math class
    double u = Math.random() + Math.random(); //Sum of two random numbers
    double r;

    //This if-else block will generate the value of radius which is less than or equal to 1
    if (u>1) { //If value u(radius) is greater than 1 then substract that value from 2 which will give the final radius value lesser than 1.
      r=2-u;
    } else {
      r = u;  //pass u's value into r
    }

    double pointX = r*Math.cos(t);  //X coordinate generated from radius times the cosine of t
    double pointY = r*Math.sin(t);  //Y coordinate created from radius times the cosine of t
    double distance = Math.sqrt(Math.pow(pointX, 2)+Math.pow(pointY, 2)); //Distance calculated from the square root of the sum of square x and square y
    return distance;  //This method will generate a double data type element called distance
  }

  // Quick sort as pivot median
  public static void quickSortMedian(double[] arr, int left, int right) { //Quicksort method takes as parameters double data type array, and indeces left and right
      if (left >= right) {  //if left is greater or equal to right, quicksort will exit the method
          return;
      }
      double pivot = median(arr[left], arr[(left + right) / 2], arr[right]); //Alternatively, Quicksort computes the pivot using the median method
      int i = left;
      int j = right;
      while (i <= j) {  //As long as i, or left value, is less than or equal to j, or right value, the following instructions will be executed
          while (arr[i] < pivot) {  //Whithin the first loop, as long as pivot is greater than the left value,
              i++;  //the left element moves on to the next element rightward
          }
          while (arr[j] > pivot) {  //At the same time, as long as the right value is greater than pivot,
              j--;  //the right element moves on to the next element leftward
          }
          if (i <= j) { //However, if the right index is greater than or equal to left index, the following code will run:
              double temp = arr[i]; //Swap i and j values
              arr[i] = arr[j];
              arr[j] = temp;
              i++;  //i moves rightward
              j--;  //j moves leftward
          }
      }
      quickSortMedian(arr, left, j); //Calling the method quicksort on array to compare left (parameter) value with j's final value. Recursively, it will repeat the first test.
      quickSortMedian(arr, i, right); //Calling the method quicksort on array to compare right (parameter) value with i's final value. Recursively, it will repeat the initial test
      //That is evaluating whether left is greater than or equal to right.
  }
  public static double median(double a, double b, double c) { //Median takes three double parameters
    //In the if-else block we are calculating the median value in a, b and c
      if (a < b) {  //if a variable is less than b
          if (b < c) {
              return b; //if a less than b then compare b to c, if b is less than c then b is the central value and the function return b
          } else if (a < c) {
              return c; //Provided in the previous condition since c is greater than b, if a is less than c then it will return c
          } else {
              return a; //If the block passes all the previous conditions, it means that a is less than b but greater than c; hence, a is the central value
          }
      } else {
          if (a < c) {
              return a; // If the first condition is not met, it means a is greater than b but is less than c; therefore, a is the median
          } else if (b < c) {
              return c;// Alternatively, the code returns c as the meadian because we learn from the previous conditions that c is less than a yet greater than b
          } else {
              return b;//If the previous test fails, it means b is less than a but b is greater than c
          }
      }
  }

  public static void main(String[] args){

    System.out.print("Size of the Array: ");
    Scanner scan = new Scanner(System.in);
    int Size = scan.nextInt();

    double[] arr = new double[Size];  //Declaring new array, arr, and initializing its size to user input
    Circle crl = new Circle();  //Creating a crl object based on Circle class' default constructor

    for(int x=0; x<Size; x++){  //Throughout the length of the array,
      arr[x] = crl.pointDistance(); //the method pointDistance is adding each sum of the square root to the array arr
    }//end of loop

    long Quicksort_start = System.nanoTime(); //Start time of Quicksort on distance array

    crl.quickSortMedian(arr, 0, Size - 1);

    long Quicksort_stop = System.nanoTime();  //End time of Quicksort on distance array

    long Quicksort_difference = Quicksort_stop - Quicksort_start; //Difference of time recorded on Quicksort method

    System.out.println("Total time taken for Quicksort to sort array: "+Quicksort_difference+" nano seconds");
  }//end of main
}//end of class
