/*************************************************************************
*  Pace University
*  Spring 2023
*  Algorithms and Computing Theory
*
*  5/7/2023 This version includes the team's answer to the extra-credit question
*  Course: CS 608
*  Team members: Filippo Zallocco, Ananthula Saivyshnav, Lokeshwar Anchuri, Sakshi Singh
*  Other collaborators: none
*
*  References: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/# , https://www.youtube.com/watch?v=PMMc4VsIacU ,
* https://brilliant.org/wiki/depth-first-search-dfs/#:~:text=Depth%2Dfirst%20search%20visits%20every,O(V%2BE). ,
* https://www.codecademy.com/article/tree-traversal
*
*  Visible data fields: Two Dimensional Array, Long , Boolean, HashMap, Set
*
* Problem 1.
*DFS stands for Depth-First Search, which is an algorithm used for traversing or searching through a graph or tree data structure.
*DFS starts at the root (or any arbitrary node) of a graph and explores as far as possible along each branch before backtracking. It visits
*each vertex exactly once, and checks if each vertex is visited or not. DFS works by using a stack data structure to keep track of the nodes to visit next.
*
* Problem 2.
*Case-1: |V|=10, |E|=9
*Running Time: 29300 Nanoseconds(5 Digits)

*Case-2: |V|=10, |E|=27
*Running Time: 35900 Nanoseconds(5 Digits)

*Case-3: |V|=10, |E|=81
*Running Time: 67400 Nanoseconds(5 Digits)

*Case-4: |V|=100, |E|=99
*Running Time: 83800 Nanoseconds(5 Digits)

*Case-5: |V|=100, |E|=985
*Running Time: 106800 Nanoseconds(6 Digits)

*Case-6: |V|=100, |E|=9801
*Running Time: 854500 Nanoseconds(6 Digits)

*Case-7: |V|=1000, |E|=999
*Running Time: 234100 Nanoseconds(6 Digits)

*Case-8: |V|=1000, |E|=31575
*Running Time: 2720200 Nanoseconds(7 Digits)

*Case-9: |V|=1000, |E|=998001
*Running Time: 36476400 Nanoseconds(8 Digits)

*Comparing Case 1 and 2 => Difference V = 0, E = 18, Running Time = 6600 (4 digits)
*Comparing Case 2 and 3 => Difference V = 0, E = 54, Running Time = 31500 (5 digits)
*Comparing Case 3 and 4 => Difference V = 90, E = 18 Running Time = 16400 (5 digits)
*Comparing Case 4 and 5 => Difference V = 0, E = 886 Running Time = 13000 (5 digits)
*Comparing Case 5 and 6 => Difference V = 0, E = 8816 Running Time = 747700 (6 digits)
*Comparing Case 6 and 7 => Difference V = 900, E = -8802 Running Time = -620400 (6 digits)
*Comparing Case 7 and 8 => Difference V = 0, E = 30576 Running Time = 2486100 (7 digits)
*Comparing Case 8 and 9 => Difference V = 0, E = 966426 Running Time = 33756200 (8 digits)

* Problem 3.
*From the above comparision for each case we can see the difference in running time with the increase in vertices and the edges.
*On comparing case 1, 2 and 3, the increased in execution time is proportional to the increase in number of edges.
*Now on comparing case 3 and 4, there is difference of only 18 edges but the number of vertices has been increase by 90. That's why the running
*time has increased from the previous(Case 3) by 16400 nano seconds.
*Comparision between 4,5 and 6 have same trend as the cases 1,2 and 3: With the increased number of edges, running time has also been increased
*Now comparing cases 6 and 7 we learn that the number of vertices has increased by 900 whereas the number of edges has been decreased by 8802, resulting in a significant difference in decreased running times.
*Following the same trend as cases 1, 2, and 3, cases 7, 8, and 9 are characterized by no change in the number of verticies, increased number of edges, and a consequential increase in running time.

*With an increase number of either edges or vertices, there follows an increase in execution time. Hence, Deepth-first search's running time is directly propotional to the sum of edges and vertices,
*which is O(V+E). This is because DFS visits each vertex exactly once and each edge is traversed at most twice (once for each endpoint), so the total number of operations
*performed by DFS is proportional to the sum of the number of vertices and edges in the graph.

*Directed Acyclic and Cyclic Graph algorithms are alterations of the DFS algorithm that report whether the algorithm has cycles. The DAG and DCG algorithms accomplish this
* Problem 4(Extra Credit)
*For this problem we have created to graphs, one with cycle and another without the cycle. Then we check whether the graph has a cycle by using hasCycle function.
*This function adds the nodes to the exploring list and tests wether the neighboring node is present in the exploring list. If all the neigbours of the current node have
*been visited but are not in the exploring nodes list, then the function returns an acyclic graph, removing all the nodes from the exploring list.
*The function hascycle detects cycles in graphs because cycles can result in algorithms failures or inaccurate results.
*Algorithms like shortest path algorithms and minimum spanning tree algorithms work only on acyclic graphs (graphs without cycles). In case the previously listed algorithms were applied to graphs with cycles, they may cause errors.
*For these reasons, we look for cycles in the graphs of our algorithms, that is to avoid runtime errors.
*************************************************************************/
import java.util.ArrayList; //Calling the ArrayList library
import java.util.List; //Calling the List library from util class
import java.util.*; //Calling the entire util class

public class DFS {
    private static int timeCounter; //timeCounter variable for getting the value of discovery time and finish time

    //This dfs method search a node by using the parameters adjList, node, visitedNode, discoveryTime of node and Finish time of the same node
    private static void dfs(List<List<Integer>> graph, int node, boolean[] visited, int[] discoveryTime, int[] finishTime) {
        visited[node] = true; //Initializing the passed node in visited as true
        timeCounter++; //Increament the count variable
        discoveryTime[node] = timeCounter; //Initializing the node inside the discovery time array into time counter which is the time the node is first visited

        for (int neighbor : graph.get(node)) { //Check every neighbor value for the passed node inside the graph:
            if (!visited[neighbor]) { //If the neighbour inside the visited array is false (not visited) then call the dfs function recursively
                dfs(graph, neighbor, visited, discoveryTime, finishTime); //calling the dfs method itself
            }
        }

        timeCounter++; //Increment counter for the visited node
        finishTime[node] = timeCounter; //Initializing the finishTime for the passed node as all the nodes in its adjecency list has been visited
    }


    private static int[][] computeDFS(List<List<Integer>> adjList) { //Computes DFS using the passed adjacency list in the parameter
        int numNodes = adjList.size(); //Initializing number of nodes as the size of adjacency list
        boolean[] visited = new boolean[numNodes]; //Initializing the visited variable array to the size number of nodes
        int[] discoveryTime = new int[numNodes]; //Initializing the discoveryTime variable array to the size number of nodes
        int[] finishTime = new int[numNodes]; //Initializing the finishTime variable array to the size number of nodes
        timeCounter = 0; //timecounter is assigned as 0

        for (int node = 0; node < numNodes; node++) { //Counting from 0 for every node  less than the total number of nodes the following instructions will execute:
            if (!visited[node]) { //If the the node is not visited execute dfs method
                dfs(adjList, node, visited, discoveryTime, finishTime); //Calling dfs method on the following parameters
            }
        }

        return new int[][]{discoveryTime, finishTime}; //returning two diamensional array with the array of discovery time and finish time
    }

    private static List<List<Integer>> generateAdjacencyList(int numNodes, int numEdges) { //generateAdjacencyList will take the number of Nodes and edges as parameters to return a list containing integer-based lists
        List<List<Integer>> adjList = new ArrayList<>(); //Calling the ArrayList class to set up a list containing int-based lists

        for (int i = 0; i < numNodes; i++) { //Adding lists inside adjacent list for the total number of nodes
            adjList.add(new ArrayList<>());
        }

        Random random = new Random(); //Calling the random class to generate different numbers

        for (int i = 0; i < numEdges; i++) { //Until the number of edges has been satisfied, we create adjacent nodes for the given number of edges
            int source = random.nextInt(numNodes); //Generating random number for the source node
            int destination = random.nextInt(numNodes); //Generating random number for the destination node
            adjList.get(source).add(destination); //Adding the destination node in the adjacency list for the generated souce using the random number
        }

        return adjList; //Returning the two diamensional adjacency list
    }

    public static boolean hasCycle(Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<>(); //We initialize an int-based visited unordered list
        Set<Integer> exploring = new HashSet<>();//We initialize an int-based exploring unordered list

        for (Integer node : graph.keySet()) { //For every node inside the graph, we take a key value and initialize it as a node
            if (!visited.contains(node)) { //However, if the node has not been visisted, we call the dfs function in the loop
                if (dfs(graph, node, visited, exploring)) {//if the node's neighbor is included in the graph's key-value pair data structure
                    return true; //Then we return the true,
                }
            }
        }

        return false; //If the above conditions are not met, we return false, which means that the graph does not contain cycles
    }

    //This dfs function takes graph, node, visited node set and exploring node set as parameter and returns boolean value after checking if the graph contains cycle
    private static boolean dfs(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited, Set<Integer> exploring) {
        visited.add(node); //Adding node (from the parameter) in the visited unordered list
        exploring.add(node); //Adding node (from the parameter) in the exploring unordered list

        Set<Integer> neighbors = graph.getOrDefault(node, new HashSet<>());//Get the neighbour list of the exploring node
        for (int neighbor : neighbors) { //For every neighbour of the exploring node perform the below operations
            if (!visited.contains(neighbor)) { //If the node has not been visited
                if (dfs(graph, neighbor, visited, exploring)) {//Call the dfs function recursively
                    return true;//return true if the condition above has been met
                }
            } else if (exploring.contains(neighbor)) {//Provided that the neighbour has been visited, we test whether the same neighbour is also in the exploring list
                return true;//A true outcome translates into the graph has a cycle
            }
        }

        exploring.remove(node);//Removing all the nodes from the exploring list to repeat the initial test on unexplored nodes
        return false;//Since all the conditions above have not been met, return false, which means the graph does not have cycles
    }

    //Generating cyclic or acyclic graph depending on the boolean parameter hasCycles for the given number of nodes and edges
    public static Map<Integer, Set<Integer>> generateGraph(int numNodes, int numEdges, boolean hasCycles) {
        List<Integer> nodes = new ArrayList<>(); //Calling array list 'nodes' based on the integer data type
        for (int i = 0; i < numNodes; i++) { //From 0 till the total number of nodes, we add nodes to the nodes list
            nodes.add(i);
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>(); // generate edges until we reach the desired number
        Random random = new Random(); //Calling the random class to generate different numbers

        while (graph.size() < numEdges) {
            int node1 = nodes.get(random.nextInt(numNodes));// Select starting node using the random number
            int node2 = nodes.get(random.nextInt(numNodes));// Select ending node using the random number

            //This if block checks if the edge already exists if it has to create a cycle
            if (!graph.getOrDefault(node1, new HashSet<>()).contains(node2) &&
                    (hasCycles || !hasPath(graph, node2, node1))) {
                        // add the edge to the graph if the above condition is true
                graph.computeIfAbsent(node1, k -> new HashSet<>()).add(node2);
            }
        }

        return graph;// return the generated graph
    }

    //This function checks if the end node is in the cyclic graph
    private static boolean hasPath(Map<Integer, Set<Integer>> graph, int start, int end) {
        Set<Integer> visited = new HashSet<>(); // This instruction creates a set to keep track of visited nodes
        Stack<Integer> stack = new Stack<>(); // Next, this instruction will push the node in the satck when stack is empty
        stack.push(start);// push the starting node onto the stack

        while (!stack.isEmpty()) { // As long as the stack is not empty,
            int node = stack.pop(); // pop a node from the stack
            visited.add(node); // then mark the node as visited

            if (node == end) { // if the end node has been reached, then return true
                return true;
            }

            Set<Integer> neighbors = graph.getOrDefault(node, new HashSet<>());// get the set of neighbors for the current node
            for (int neighbor : neighbors) {// For each neighbor inside neighbors,
                if (!visited.contains(neighbor)) {// if the neighbor has not been visited, add it to the stack
                    stack.push(neighbor);
                }
            }
        }

        return false; // if the end node was not reached, return false
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Calling scanner object to fetch integer data type user input
        System.out.print("Enter the number of nodes: "); //Entering number of nodes
        int numNodes = scanner.nextInt(); //Entering number of nodes
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt(); //Entering number of edges

        List<List<Integer>> adjList = generateAdjacencyList(numNodes, numEdges);//Calling the generateAdjacencyList method to create graph with the previously entered nodes and edges
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.println(i + ": " + adjList.get(i)); //This for loop function will print the adjacency list for each node
        }

        long startTime = System.nanoTime(); //We start recording the time of execution of computeDFS algorithm
        int[][] dfsResult = computeDFS(adjList); //computeDFS is passing all the nodes with their list of adjacent nodes into the two dimensional array
        long endTime = System.nanoTime(); //We stop recording the execution time

        // The computeDFS method returns a two diamensional array one with the discovery time of the node and other with the finish time of the same node
        int[] discoveryTime = dfsResult[0]; //We are assigning the discovery time to its respective integer array
        int[] finishTime = dfsResult[1]; //We are assigning the finish time to its respective integer array

        System.out.println("Discovery Time: " + Arrays.toString(discoveryTime)); //Print the Discovery time array
        System.out.println("Finish Time: " + Arrays.toString(finishTime)); //Print the Finish time array
        System.out.println("Running Time: " + (endTime - startTime) + " Nanoseconds"); //Print the Total Running time for DFS
		//extra credit

		int numNodes1 = 1100; //We initialized the number of nodes for generating cyclic and acyclic graphs
        int numEdges2 = 1099; //We initialized the number of edges for generating cyclic and acyclic graphs

        //We are generating the graph by calling the method generateGraph and passing the value for nodes, edges and boolean value.
        //The boolean value determines if the graph is cyclic or not
        Map<Integer, Set<Integer>> graphWithCycles = generateGraph(numNodes1, numEdges2, true); //Since the boolean value is true, it will generate a cyclic graph.
        Map<Integer, Set<Integer>> graphWithoutCycles = generateGraph(numNodes1, numEdges2, false); //Since the boolean value is false, it will generate a acyclic graph.
        //Checking whether the graph is cyclic or acyclic by calling the function hasCycle
        System.out.println("Graph with cycles has cycle: " + hasCycle(graphWithCycles));
        System.out.println("Graph without cycles has cycle: " + hasCycle(graphWithoutCycles));
    }
}
