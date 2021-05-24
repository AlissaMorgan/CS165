/* Graph class
* Template made by Toby Patterson
* With the help of: https://www.cs.colostate.edu/~cs165/.Spring20/assignments/P8/doc/
* Completed by: your name here
* 6/2/2020
* For cs165 at CSU
*
* A basic graph which has a depth first search print method. It uses
* link references to keep track of edges.
* */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Graph<E extends Comparable<E>> extends GraphAbstract<E> {
    public Graph() {
        nodes = new ArrayList<GraphNode>();
    }

    /* addEdge
    * Params: data1 & data2, both data items to be added and connected
    * If the either of the data items are not in the nodes ArrayList,
    * add them as new nodes. Otherwise, find the nodes in the ArrayList so
    * you can make them point to each other. Implement so there are no duplicates
    * added to either of the nodes neighbors ArrayList.
    * TODO: implement this method.
    * */
    @Override
    public void addEdge(E data1, E data2) {
        GraphNode dataOne = null;
        GraphNode dataTwo = null;
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).data.equals(data1)){
                dataOne = nodes.get(i);
            }if(nodes.get(i).data.equals(data2)){
                dataTwo = nodes.get(i);
            }
        }
        if(dataOne == null && dataTwo == null){
            dataOne = new GraphNode(data1);
            dataTwo = new GraphNode(data2);
            dataOne.neighbors.add(dataTwo);
            dataTwo.neighbors.add(dataOne);
            nodes.add(dataOne);
            nodes.add(dataTwo);

        }else if(dataOne == null){
            dataOne = new GraphNode(data1);
            dataOne.neighbors.add(dataTwo);
            dataTwo.neighbors.add(dataOne);
            nodes.add(dataOne);
        }else if(dataTwo == null){
            dataTwo = new GraphNode(data2);
            dataOne.neighbors.add(dataTwo);
            dataTwo.neighbors.add(dataOne);
            nodes.add(dataTwo);
        }else{
            if(!dataOne.neighbors.contains(dataTwo)){
                dataOne.neighbors.add(dataTwo);
            }if(!dataTwo.neighbors.contains(dataOne)){
                dataTwo.neighbors.add(dataOne);
            }
        }
    	//YOUR CODE HERE
    }
    

    

    /* depthFirst
     * Param: startNode, the node to start the traversal at
     *
     * First, find the startNode based off of startItem (hint: indexOf())
     * I recommend having an ArrayList of GraphNodes called visisted to keep
     * track of the nodes you've visited.
     *
     * Prints all of the nodes in the graph in depth first order (with a space between nodes)
     * TODO: implement this method.
     * */
    @Override
    public void depthFirst(E startItem) {
        ArrayList<GraphNode> visited = new ArrayList<>();
        for(GraphNode node: nodes){
            if(node.data.equals(startItem)){
                visited.add(node);
                depthFirst(node, visited);
                break;
            }
        }

    	//YOUR CODE HERE
    }

    // Recursive helper method for depthFirst
    private void depthFirst(GraphNode curr, ArrayList<GraphNode> visited) {
        GraphNode nextNode = null;
        for (GraphNode node: curr.neighbors){
            if (!(visited.contains(node))){
                nextNode = node;
                visited.add(node);
                break;
            }
        }
        System.out.print(curr.data + " ");
        if (nextNode != null){
            depthFirst(nextNode, visited);
        }

    	//YOUR CODE HERE
    }

    
}
