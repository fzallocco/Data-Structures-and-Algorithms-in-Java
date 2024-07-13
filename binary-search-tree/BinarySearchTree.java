/*************************************************************************
*  Pace University
*  Spring 2023
*  Algorithms and Computing Theory
*
*  5/6/2023 This version includes our team's revised conclusion and answer to the extra credit question
*  Course: CS 608
*  Team members: Filippo Zallocco, Ananthula Saivyshnav, Lokeshwar Anchuri, Sakshi Singh
*  Other collaborators:
*
*  References: Software Testing Help. https://www.softwaretestinghelp.com/binary-search-tree-in-java/, 2/09/2023
*  Natraj, Lalitha. https://youtu.be/ovWqEgYYAEQ, 4/02/2019
*
*  Visible data fields: int Key, Node Left, Node Right
*
* Problem 1.
*The asymptotic running time to search for a random integer in skewed and balanced binary search trees can differ significantly.
*In a balanced BST, the tree's height is typically expressed as a logarithmic function based on the number of nodes that make up the tree, or O(log n), where n is the number of nodes in the tree. This function simplifies the algorithm's time complexity by eliminating half of the remaining nodes in each step of the search.
*In a skewed BST, the tree's height can reach a large number, often defined as n - 1, where n is the number of nodes in the tree. In a worst-case scenario, we may have to traverse the entire path from the root to the leaf node that contains the search key, resulting in a time complexity of O(n). To see why this is the case, we consider a BST where every node has only one child, and the children are inserted on the right side of the tree. Such a tree would thus be right-skewed. If we want to *search for a key greater than the root, we must traverse the entire tree, a process that can be time-consuming.
*In the binary search tree class, the operations used to search a random integer are findMin and findMax. Both operations are implemented in a while loop traversing the tree from its root to the leaf node containing the minimum or maximum key. The time complexity of each of these operations is O(h), where h is the tree's height. Therefore, the overall running time of searching in a skewed tree is proportional to the size of the tree. In a balanced tree, on the other hand, the height is given by *the exponent of the power of two. Since no x exponent makes two negative, the time complexity is a relatively smaller number than the height of a skewed tree.
*
* Problem 2.
*Case-1: n=10(10^1)
*Time taken by skewed binary tree: 3307(4 Digits) nanoseconds
*Time taken by Balanced binary tree: 2101(4 Digits) nanoseconds
*Time to search in java Treemap for Value: 20212(5 Digits) nanoseconds
*Time to search in java Treemap for Key: 16300(5 Digits) nanoseconds

*Case-2: n=100(10^2)
*Time taken by skewed binary tree: 28633(5 Digits) nanoseconds
*Time taken by Balanced binary tree: 2378(4 Digits) nanoseconds
*Time to search in java Treemap for Value: 96181(5 Digits) nanoseconds
*Time to search in java Treemap for Key: 15692(5 Digits) nanoseconds

*Case-3: n=1000(10^3)
*Time taken by skewed binary tree: 466799(6 Digits) nanoseconds
*Time taken by Balanced binary tree: 13249(5 Digits) nanoseconds
*Time to search in java Treemap for Value: 1155954(7 Digits) nanoseconds
*Time to search in java Treemap for Key: 17918(5 Digits) nanoseconds

*Case-4: n=10000(10^4)
*Time taken by skewed binary tree: 1949180(7 Digits) nanoseconds
*Time taken by Balanced binary tree: 5476(4 Digits) nanoseconds
*Time to search in java Treemap for Value: 4193022(7 Digits) nanoseconds
*Time to search in java Treemap for Key: 17245(5 Digits) nanoseconds

*Case-5: n=30000(3*10^4)
*Time taken by skewed binary tree: 2589888(7 Digits) nanoseconds
*Time taken by Balanced binary tree: 5842(4 Digits) nanoseconds
*Time to search in java Treemap for Value: 7491314(7 Digits) nanoseconds
*Time to search in java Treemap for Key: 35935(5 Digits) nanoseconds

* Problem 3.
*From the output, we observe that there is a noticeable difference in search speed between the skewed tree and the balanced tree.
*Upon entering ten as input, we learn that the search algorithm takes five times as long in the skewed tree to find a random integer as it does in the balanced tree.
*Increasing the input size to 100, we appreciate that the speed gap between the two trees goes up by a factor of ten.
*Similarly, when we try 1000 as the input size, we understand that the search time variation between the skewed and balanced trees approaches a factor of 400,000,
*or an increment close to 80 times that of the first speed difference recorded.
*This trend continues as we use larger input sizes, such as 10,000 or 30,000.
*In fact, the terminal returns a search time difference of 2.5M nanoseconds and 3.01M nanoseconds, respectively,
*or 500 and 600 time fold increments from the first time variance recorded.

*Problem 4(Extra Credit)
*Java TreeMap and binary tree are both data structures used to store and organize data in a hierarchical manner, but they differ in their implementation and functionality.
*A binary tree is a data structure consisting of nodes, where each node has at most two children, a left child and a right child. The binary tree can be used to represent data
*in a sorted manner, where the left child is always less than the parent node, and the right child is always greater than the parent node.
*On the other hand, Java TreeMap is a class in the Java Collections Framework that implements the Map interface, which stores key-value pairs in a sorted order based on the keys.
*Java TreeMap is an implementation of a Red-Black Tree, which is a self-balancing binary search tree. It allows quick retrieval of data based on the keys and provides methods for adding,
*removing and searching for elements in the tree. It has a time complexity of O(log n) for operations such as insertion, deletion, and searching. Here n is the key(or value or key-value) count.
*From the retrieved results(Below mentioned all the time values are in nanoseconds),

*The search function was evaluated on arrays of different sizes. For an array size of 10^1, the built-in search function for TreeMap took 2*10^4ns for both value and key searches.
*In comparison, skewed and balanced search trees took significantly less time, with 3*10^3ns and 2*10^3ns, respectively. As the array size increased to 10^2 and 10^3, the search time for
*skewed binary trees and TreeMap functions for value search increased considerably, while the search time for balanced binary trees and TreeMap functions for key search remained relatively consistent.
*For an array size of 10^4 and 3*10^4, the search time for balanced binary trees and TreeMap functions for key search remained almost the same, while the search time for skewed binary trees and TreeMap functions
*for value search increased drastically.

*The time complexity for binary search tree depends on the height of the tree. If the tree is balanced, the tree would have the minimum height and hence it will take less time whereas skewed tree has the worst case scenario
*as it has the maximum height a tree can posses and hence it takes more time as compared to others.
*When you search for a key in a TreeMap, it uses a binary search algorithm to locate the position of the key in the tree. This algorithm takes advantage of the fact that the keys
*in the TreeMap are stored in a sorted order, so it can eliminate half of the remaining search space with each comparison. As a result, searching for a key takes O(log n) time,
*where n is the number of elements in the TreeMap.
*On the other hand, searching for a value requires iterating over all the values in the TreeMap and comparing each value to the target value until a match is found. This takes O(n) time,
*where n is the number of elements in the TreeMap. Even if the values in the TreeMap are stored in a sorted order, the TreeMap does not provide a direct way to search for a value by its position in the tree.

*************************************************************************/

import java.util.*; //We import the class util from the Java environment.
import java.math.*;	//We import the class math from the Java environment.

class BinarySearchTree {
  class Node{

    int Key;  //data types for the base Node.
    Node Left, Right;

    public Node() {}; //Default constructor.
    public Node(int Num){ //user-defined constructor containing an int-based parameter.
      Key=Num;
      Left=null;
      Right=null; //left and right children are non existent until created.
    }
  }

  Node Root; //this the base root of the tree created following the blue print of the class Node.

  BinarySearchTree(){Root=null;} //The algorithm's constructor assumes root is null and the tree is empty.

  public void add(int Key) { //This method pass an int data type into Root with the second method inset.
    Root = insert(Root, Key);
  }
  Node insert(Node Root, int Key){
       if(Root==null){  //If Root has no value, then Java re-initializes Root with Node's constructor using a new integer.
         Root=new Node(Key);
         return Root; //We then return Root's integer data type.
       }
       if(Key<Root.Key)
         Root.Left=insert(Root.Left, Key);  //Here we test whether the key we intend to append is smaller than the one currently used by node.
       else                                 //If it is smaller then the program appends that integer to the node's left child. Otherwise,
         Root.Right=insert(Root.Right, Key);//it will append the integer data type to the node's right child.
       return Root;// Finally, return the integer data type.
  }

  boolean Search(int Key) { //This search method examines whether an integer data type key exists in the tree.
    Root=Search_Recursive(Root, Key);
    if (Root!=null)//Provided that Root is not null and that the tree is not empty, Java will perform the following instructions:
      return true;  //if the key exists, return true.
    else
      return false; //Otherwise, it will return false.
  }

  Node Search_Recursive(Node node, int Key){  //We pass the key and node inputs from the parameters into the conditions below
    if(node==null || node.Key==Key)   //if the node is empty or the key examined is inside an existing node, then
      return node;                    //the algorithm returns the node at hand
    if (node.Key>Key)                 //if the key at hand is smaller than another node's key,
      return Search_Recursive(node.Left, Key);//we instruct Java to search the left side of the tree
    return Search_Recursive(node.Right, Key);//By default Java will search the keys inside the right side of the tree
  }

  public static void main(String[] args) {

    BinarySearchTree BalancedTree = new BinarySearchTree(); //we create a balanced tree using the constructor BinarySearchTree from the BinarySearchTree class.
    BinarySearchTree SkewedTree = new BinarySearchTree();	//We do the same for the skewed tree.
    TreeMap<Integer, String> JavaTreeMap = new TreeMap<>(); //Creating a tree using treemap inbuild Java API

    System.out.println("Enter tree size as powers of 10: \n");	//We prompt the user to enter an array size based on powers of 10.
    Scanner sc = new Scanner(System.in);	//We use the scanner object to fetch the user input and pass it into an integer data type variable that will define the array size.
    int TreeSize = sc.nextInt();

    //For every element of the array, create a new integer times infinity and embed it inside balanced tree.
    for(int x=0; x<TreeSize; x++){
      int value=(int) (Math.random()*Integer.MAX_VALUE);
      BalancedTree.add(value);
      JavaTreeMap.put(x, Integer.toString(value));//Adding the values in Java treemap using an inbuild function put
    }

    //For every element of the array, create a skewed array that goes from index 0 till the end of the array.
    for(int i=0; i<TreeSize; i++){
      SkewedTree.add(i);	//this structure defines the skewed tree.
    }

    int searchedValue = (int) ( Math.random()* Integer.MAX_VALUE );	//we generate a random integer-based number that we use for testing later in the program.

    long startS = System.nanoTime();	//We start record the time lapse to find out which tree structure offers the quickest search time for an existing integer/key.
    boolean foundS = SkewedTree.Search(searchedValue);	//we call the Search method on the skewed tree first to find whether a random integer exists in the tree.
    long endS = System.nanoTime();	//we then record the time it tookto perform the above instruction.
    long searchTimeS = endS - startS; //we calculate the time lapse fro start to end and display it below to the user.
    System.out.println("Time to search in SkewedTree: " + searchTimeS + " nanoseconds ");

    long startB = System.nanoTime();	//we start recording again for the time it takes for the algorithm to find a random integer in the balanced tree.
    boolean foundB = BalancedTree.Search(searchedValue);
    long endB = System.nanoTime();
    long searchTimeB = endB - startB;	//After caclutating the time lapse we display it to the user below.
    System.out.println("Time to search in BalancedTree: " + searchTimeB + " nanoseconds ");

    long startJ = System.nanoTime();	//we start recording again for the time it takes for the algorithm to find a random integer in the javaTreemap tree.
    boolean foundJ = JavaTreeMap.containsValue(searchedValue); //Search Value in treemap
    long endJ = System.nanoTime();
    long searchTimeJ = endJ - startJ;	//After caclutating the time lapse we display it to the user below.
    System.out.println("Time to search in java Treemap for Value: " + searchTimeJ + " nanoseconds ");


    long startKeyJ = System.nanoTime();	//we start recording again for the time it takes for the algorithm to find a random integer in the javaTreemap tree.
    boolean foundKeyJ = JavaTreeMap.containsKey(searchedValue); //Search Key in Java Treemap
    long endKeyJ = System.nanoTime();
    long searchTimeKeyJ = endKeyJ - startKeyJ;	//After caclutating the time lapse we display it to the user below.
    System.out.println("Time to search in java Treemap for Key: " + searchTimeKeyJ + " nanoseconds ");
  }//end of main
}//end of class
