/*************************************************************************
*  Pace University
*  Spring 2023
*  Algorithms and Computing Theory
*
*  5/6/2023 This version includes our team's revised conclusion and answer to the extra credit question
*  Course: CS 608
*  Team members: Filippo Zallocco, Ananthula Saivyshnav, Lokeshwar Anchuri, Sakshi Singh
*  Other collaborators: none
*
*  References:
*   https://www.geeksforgeeks.org/java-program-for-quicksort/
*   https://en.wikipedia.org/wiki/Library_sort
*   https://www.youtube.com/watch?v=3OSeSd2EYkw
*
*  Visible data fields:
*
* Question 3:
*
*n=1,000,000
Version | Increasing order                   | Decreasing order                       | Random order
1         4,281,500 nano seconds(7 digits)   877,808,867,500 nano seconds(12 digits)  144,155,998,500 nano seconds(12 digits)
2a
2b
*
n= 20,000
*
Version | Increasing order              | Decreasing order                   | Random order
1       506,000 nano seconds(6 digits)  144,698,800 nano seconds(9 digits)   64,811,200 nano seconds(8 digits)
2a
2b
*
n=60,000
*
Version | Increasing order                      | Decreasing order                      | Random order
1       22,190,667 nano seconds(8 digits)         2,700,744,727 nano seconds(10 digits)      542,932,635 nano seconds(9 digits)
2a      824,429,543 nano seconds(9 digits)        619,872,709 nano seconds (9 digits)        11,801,580 nano seconds(8 digits)
2b      65,687,905 nano seconds(8 digits)         1,037,300 nano seconds (7 digits)          2,426,923 nano seconds(7 digits)
*
* Question 4.
*
Version | Increasing order     |  Decreasing order         |  Random order
1         O(n)                    O(n^2)                      O(n^2)
2a        O(n^2)                  O(n^2)                      O(n*log(n))
2b        O(n*log(n))             O(n*log(n))                 O(n*log(n))
*
* Question 5.
*After generating an array with an input size of one million, we found that Insertion sort algorithm compared every element to the next in the increasing array in as little as 4.3x10^-3 seconds. We chose to report this speed using O(n) in big O notation.
*When it carried out the same instructions on arrays of the same input size but with different orders, such as decreasing and random, we noted that the execution time for the reversed and random order arrays was 14.63 minutes and 2.4 minutes, respectively.
*Since Insertion sort’s run time on the reversed order array rose by a factor of 3,400 from .0043 seconds recorded for the sorted array, we assumed that the algorithm uses significantly more time to evaluate and reposition the integers because it conducts two operations at once, thus employing the same amount of time twice.
*Whilst it re-arranges the array from lowest to highest, it also compares each element with the previous element, and if the previous element is smaller than the current one, those elements are swapped. For the reasons discussed above, we use O(n^2), in big O notation, to express the duration of the algorithm’s execution when the array is in decreasing order.
*Similarly, we inferred that Insertion sort took notably more time to compare every element to the previous or the next in the randomly generated array than it did while iterating on the sorted array, as in the random case, the algorithm performed the same evaluation twice per element inside the array.
*Hence, we concluded that its speed O(n^2), in big O notation, approaches that of the algorithm iterating through the decreasing order array. We speculate that the 12-minute difference between the reversed and random arrays is partly due to the fact that a large section of the random array was already sorted from low to high.
*Therefore, this unlikely advantage may have cut the usual time the algorithm might have required had the section of the random algorithm at hand been shorter.
*Subsequently, we conducted more tests using input sizes between 15,000 and 60,000 to find out the performance difference between insertion sort and quick sort among the three types of algorithms in order to draw conclusions that can help explain similar results when analyzing an input size of one million. With an input size of 60,000, we find that the Quicksort algorithm outperforms the Insertion sort with varying speeds from O(n^2) to O(n*log(n)).
*Notably, Quicksort is more consistent with its speed in sorting through increasing, decreasing, and random arrays when it is instructed to make the median of three randomly chosen integers the pivot than when it considers the arrays’ first element as their pivots. In fact, we find that Quicksort’s speed for the sorted, reversed, and random arrays with their median values as their pivots is O(n*log(n)), whereas the algorithm’s rate on arrays with the first element as pivot changes from O(n^2) *for the sorted and decreasing order arrays to O(n*log(n)) for the random array. It took Quicksort .8244 seconds, .6198 seconds, and .0118 seconds to re-arrange the sorted, reversed, and random arrays, respectively, with pivot as the first element.
*To execute the same instructions, Quicksort required .0657 seconds, .0010 seconds, and .0024 seconds to re-balance the sorted, reversed, and random arrays, respectively, with pivot as their median. Noticing how closely related the speeds of the median-based arrays are to the first-as-pivot random array mentioned earlier, we deduced that these speeds have logarithmic functions as opposed to the speeds recorded for the first two first-as-pivot arrays, which are closer to quadratic functions.
*
*In addition, Insertion sort is much slower than Quicksort, especially for larger arrays. Quicksort with the median as the pivot is faster than Quicksort with the first element as the pivot on reverse arrays but slower on sorted and random arrays.
*For very large arrays (e.g., length 60000), quicksort is much faster than insertion sort, even on sorted arrays. Quicksort with the median as the pivot appears to be the better sorting algorithm for a wide range of input arrays, whereas insertion sort performs well only on sorted arrays or small arrays.
*The order of the sorting algorithms from fastest to slowest based on the time taken by each algorithm is as follows:
*
*Small Array(N=15,000)                      |         Large Array(N=60,000)
*Quick Sort with Median Pivot (Reverse Array)|         Quick Sort with Median Pivot (Reverse Array)
*Quick Sort with Median Pivot (Random Array) |         Quick Sort with Median Pivot (Random Array)
*Quick Sort with First Element Pivot (Random)|         Quick Sort with First Element Pivot (Random)
*Insertion Sort (Sorted Array)               |         Insertion Sort (Sorted Array)
*Insertion Sort (Random Array)               |         Quick Sort with Median Pivot (Sorted Array)
*Quick Sort with Median Pivot (Sorted Array) |         Insertion Sort (Random Array)
*Quick Sort with First Element Pivot (Reverse)|        Quick Sort with First Element Pivot (Reverse)
*Insertion Sort (Reverse Array)               |        Quick Sort with First Element Pivot (Sorted)
*Quick Sort with First Element Pivot (Sorted) |        Insertion Sort (Reverse Array)
*
*Quick sort with median pivot is more efficient than quick sort with first element pivot, as it reduces the likelihood of selecting a bad pivot element and improves the worst-case time complexity of the algorithm.
*However, the median pivot algorithm requires additional time to compute the median element, which can increase the overhead of the algorithm.
*In conclusion, Insertion sort is a simpler algorithm that is useful for smaller arrays, whereas quick sort with the first element as the pivot is a less efficient variation of quick sort, but it is still a viable option for certain types of arrays.
*
* Extra Credit-(Library Sort):
* Library sort, also known as gapped insertion sort or block sort, is a variation of the classic insertion sort algorithm. It is a sorting algorithm that works by dividing an input array into smaller, partially sorted sub-arrays, which are then merged to obtain the final sorted array.
* The algorithm works by first dividing the input array into blocks of a fixed size. Each block is then sorted using an insertion sort algorithm. After sorting each block, the algorithm identifies the "gaps" between the sorted blocks, and then performs a final insertion sort on the entire array, filling in the gaps between the blocks.
* The gap between the blocks is the key to the efficiency of the Library sort. By choosing a gap that is larger than the size of the blocks, the algorithm avoids the high overhead of merging the blocks in the final stage of the sort. Instead, it uses the gaps to quickly fill in the remaining elements of the array.
*
* For the input array of size n= 55000, results are:
* Version                               | Increasing order                      | Decreasing order                      | Random order
InsertionSort                           14,069,728 nano seconds(8 digits)         2,224,700,941 nano seconds(10 digits)      467,279,490 nano seconds(9 digits)
QuickSort(Pivot as first Position)      713,704,385 nano seconds(9 digits)        541,386,058 nano seconds (9 digits)        11,452,600 nano seconds(8 digits)
QuickSort(Pivot at median)              66,278,723 nano seconds(8 digits)         852,314 nano seconds (6 digits)            1,829,789 nano seconds(7 digits)
LibrarySort                             26,356,860 nano seconds(8 digits)         22,081,440 nano seconds(8 digits)          4,756,682 nano seconds(7 digits)
*
For the input array of size n= 45000, results are:
* Version                               | Increasing order                      | Decreasing order                      | Random order
InsertionSort                           8,625,419 nano seconds(7 digits)          1,419,755,443 nano seconds(10 digits)      327,150,536 nano seconds(9 digits)
QuickSort(Pivot as first Position)      421,648,087 nano seconds(9 digits)        409,145,347 nano seconds (9 digits)        409,145,347 nano seconds(9 digits)
QuickSort(Pivot at median)              41,527,854 nano seconds(8 digits)         913,589 nano seconds (6 digits)            913,589 nano seconds(6 digits)
LibrarySort                             15,351,450 nano seconds(8 digits)         88,033,820 nano seconds(8 digits)          4.638,029 nano seconds(7 digits)
*
* Library sort has a worst-case time complexity of O(n^2) when the size of the blocks is equal to the size of the input array. However, for a fixed block size, the time complexity is O(n log n) in the average case
* Library sort typically performs well in cases where the input array is partially sorted or contains many repeated elements. This is because the algorithm divides the input array into smaller, partially sorted sub-arrays, which are easier to sort using the insertion sort algorithm. Additionally, the gaps between the sorted blocks in Library sort allow for faster merging of the sub-arrays in the final stage of the sort.
* In comparison to insertion sort, Library sort can be faster for larger input sizes or when the input array contains many repeated elements. Insertion sort has a worst-case time complexity of O(n^2), which makes it less efficient than Library sort when sorting large or unsorted arrays.
*However, in comparison to quick sort, Library sort may be less efficient for most input sizes. Quick sort has an average-case time complexity of O(n log n), which is faster than the average-case time complexity of Library sort. Additionally, quick sort can be implemented to work in-place, which can save memory overhead compared to Library sort's block-based approach.
*************************************************************************/
import java.util.Random;
import java.util.Arrays;

public class Sorting{

    //Insertion sort
    void Insertionsort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    //Quick sort program pivot as first element
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int st = low;
        int end= high;
        while(st < end && end >= 0){
            while(arr[st] <= pivot && st < end){
                st++;
            }
            while(arr[end] > pivot){
                end--;
            }
            if (st < end){
                swap(arr,st,end);
            }
        }
        swap(arr,low,end);
        return end;

    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void quickSort(int arr[], int low, int high)
    {
        if (low < high) {
            int idx = partition(arr, low, high);
            quickSort(arr, low, idx - 1);
            quickSort(arr, idx + 1, high);
        }
    }

    // Quick sort as pivot median
    public static void quickSortMedian(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = median(arr[left], arr[(left + right) / 2], arr[right]);
        int i = left;
        int j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        quickSortMedian(arr, left, j);
        quickSortMedian(arr, i, right);
    }

    public static int median(int a, int b, int c) {
        if (a < b) {
            if (b < c) {
                return b;
            } else if (a < c) {
                return c;
            } else {
                return a;
            }
        } else {
            if (a < c) {
                return a;
            } else if (b < c) {
                return c;
            } else {
                return b;
            }
        }
    }

    //Printing array
    void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


// librarySort method that takes an integer array arr as input
// and sorts it in ascending order using Library Sort.
    public static void librarySort(int[] arr) {
        int n = arr.length;
        int[] gaps = getGaps(n); // get the gap sequence

        for (int k = gaps.length - 1; k >= 0; k--) {
            int g = gaps[k];
            for (int i = g; i < n; i++) {
                int temp = arr[i];
                int j = i - g;
                while (j >= 0 && temp < arr[j]) {
                    arr[j + g] = arr[j];
                    j -= g;
                }
                arr[j + g] = temp;
            }
        }
    }
// getGaps method, which returns an integer array containing the gaps in descending order.
    private static int[] getGaps(int n) {
        int[] gaps = new int[1];
        int count = 0;
        int h = 1;
        while (h < n) {
            if (count >= gaps.length) {
                gaps = Arrays.copyOf(gaps, gaps.length * 2);
            }
            gaps[count++] = h;
            h = 3 * h + 1;
        }
        gaps = Arrays.copyOf(gaps, count);
        return gaps;
    }

    public static void main(String args[]) {
    //Generating Array for Sorting
    int n = 1000;
    int[] arrSorted = new int[n];
    int[] arrReverse = new int[n];

    for (int i = 0; i < n; i++) {
        arrSorted[i] = i;               //Sorted Array
        arrReverse[i] = n - i - 1;      //Reverse Array
    }

    int[] arrRandom = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
            arrRandom[i] = random.nextInt(101); // generates a random integer between 0 and 100
        }
    Sorting is = new Sorting();

    //Insertion Sort For Sorted array
    long startTimeSortedIS = System.nanoTime();
    is.Insertionsort(arrSorted);
    long endTimeSortedIS = System.nanoTime();
    long elapsedTimeSortedIS = endTimeSortedIS - startTimeSortedIS;
    System.out.println("Time taken by the Sorted array using InsertionSort " + elapsedTimeSortedIS);

    //Insertion Sort For Reverse array
    long startTimeReverseIS = System.nanoTime();
    is.Insertionsort(arrReverse);
    long endTimeReverseIS = System.nanoTime();
    long elapsedTimeReverseIS = endTimeReverseIS - startTimeReverseIS;
    System.out.println("Time taken by the Reverse array using InsertionSort " + elapsedTimeReverseIS);

    //Insertion Sort For Random array
    long startTimeRandomIS = System.nanoTime();
    is.Insertionsort(arrRandom);
    long endTimeRandomIS = System.nanoTime();
    long elapsedTimeRandomIS = endTimeRandomIS - startTimeRandomIS;
    System.out.println("Time taken by the Random array using InsertionSort " + elapsedTimeRandomIS);


    //For Quick sort program pivot as first element
    int[] arrSortedQS = new int[n];
    int[] arrReverseQS = new int[n];

    for (int i = 0; i < n; i++) {
        arrSortedQS[i] = i;                 //Sorted Array
        arrReverseQS[i] = n - i - 1;        //Reverse Array
    }

    int[] arrRandomQS = new int[n];
    Random randomQS = new Random();
    for (int i = 0; i < n; i++) {
        arrRandomQS[i] = randomQS.nextInt(101); // generates a random integer between 0 and 100
    }

    Sorting qs = new Sorting();
    // For Sorted array
    long startTimeSorted = System.nanoTime();
    qs.quickSort(arrSortedQS, 0, n - 1);
    long endTimeSorted = System.nanoTime();
    long elapsedTimeSorted = endTimeSorted - startTimeSorted;
    System.out.println("Time taken by the Sorted array using quickSort and pivot is first element " + elapsedTimeSorted);

    //For Reverse array
    long startTimeReverse = System.nanoTime();
    qs.quickSort(arrReverseQS, 0, n - 1);
    long endTimeReverse = System.nanoTime();
    long elapsedTimeReverse = endTimeReverse - startTimeReverse;
    System.out.println("Time taken by the Reverse array using quickSort and pivot is first element " + elapsedTimeReverse);

    //For Random array
    long startTimeRandom = System.nanoTime();
    qs.quickSort(arrRandomQS, 0, n - 1);
    long endTimeRandom = System.nanoTime();
    long elapsedTimeRandom = endTimeRandom - startTimeRandom;
    System.out.println("Time taken by the Random array using quickSort and pivot is first element " + elapsedTimeRandom);

    //For Quick sort program pivot as median
    int[] arrSortedQSM = new int[n];
    int[] arrReverseQSM = new int[n];

    for (int i = 0; i < n; i++) {
        arrSortedQSM[i] = i;            //Sorted Array
        arrReverseQSM[i] = n - i - 1;   //Reverse Array
    }

    int[] arrRandomQSM = new int[n];
    Random randomQSM = new Random();
    for (int i = 0; i < n; i++) {
        arrRandomQS[i] = randomQSM.nextInt(101); // generates a random integer between 0 and 100
    }

    Sorting qsm = new Sorting();
    // For S0rted array
    long startTimeSortedM = System.nanoTime();
    qsm.quickSortMedian(arrSortedQSM, 0, n - 1);
    long endTimeSortedM = System.nanoTime();
    long elapsedTimeSortedM = endTimeSortedM - startTimeSortedM;
    System.out.println("Time taken by the Sorted array using quickSort and pivot as median " + elapsedTimeSortedM);

    //For Reverse array
    long startTimeReverseM = System.nanoTime();
    qsm.quickSortMedian(arrReverseQSM, 0, n - 1);
    long endTimeReverseM = System.nanoTime();
    long elapsedTimeReverseM = endTimeReverseM - startTimeReverseM;
    System.out.println("Time taken by the Reverse array using quickSort and pivot as median " + elapsedTimeReverseM);

    //For Random array
    long startTimeRandomM = System.nanoTime();
    qs.quickSortMedian(arrRandomQSM, 0, n - 1);
    long endTimeRandomM = System.nanoTime();
    long elapsedTimeRandomM = endTimeRandomM - startTimeRandomM;
    System.out.println("Time taken by the Random array using quickSort and pivot as median " + elapsedTimeRandomM);

    //For Library sort program
    int[] arrSortedLS = new int[n];
    int[] arrReverseLS = new int[n];

    for (int i = 0; i < n; i++) {
        arrSortedLS[i] = i;            //Sorted Array
        arrReverseLS[i] = n - i - 1;   //Reverse Array
    }

    int[] arrRandomLS = new int[n];
    Random randomLS = new Random();
    for (int i = 0; i < n; i++) {
        arrRandomLS[i] = randomLS.nextInt(101); // generates a random integer between 0 and 100
    }

    Sorting ls = new Sorting();
    // For S0rted array
    long startTimeSortedLS = System.nanoTime();
    ls.librarySort(arrSortedLS);
    long endTimeSortedLS = System.nanoTime();
    long elapsedTimeSortedLS = endTimeSortedLS - startTimeSortedLS;
    System.out.println("Time taken by the Sorted array using Library Sort " + elapsedTimeSortedLS);

    //For Reverse array
    long startTimeReverseLS = System.nanoTime();
     ls.librarySort(arrReverseLS);
    long endTimeReverseLS = System.nanoTime();
    long elapsedTimeReverseLS = endTimeReverseLS - startTimeReverseLS;
    System.out.println("Time taken by the Reverse array using Library Sort " + elapsedTimeReverseLS);

    //For Random array
    long startTimeRandomLS = System.nanoTime();
      ls.librarySort(arrRandomLS);
    long endTimeRandomLS = System.nanoTime();
    long elapsedTimeRandomLS = endTimeRandomLS - startTimeRandomLS;
    System.out.println("Time taken by the Random array using Library Sort " + elapsedTimeRandomLS);
}
}
