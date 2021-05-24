// GraphImplementation.java - supplied code for graph assignment

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.*;

public class GraphImplementation extends GraphAbstract {

    // Main entry point
    public static void main(String[] args) {

        // Instantiate code
        GraphImplementation impl = new GraphImplementation();
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine(); //"./resources/MileagesSmall.csv"
        String startCity = input.nextLine(); //"cityName"
        // Read distances chart
        System.out.println("Reading Chart: " + fileName);
        impl.readGraph(fileName);
        System.out.println();

        // Print depth first search
        System.out.println("Depth First Search:");
        impl.depthFirst(startCity);
        System.out.println();

        System.out.println("Breadth First Search:");
        impl.breadthFirst(startCity);
        System.out.println();

    }



    // Reads mileage chart from CSV file
    public void readGraph(String filename) {
        try {
            Scanner scnr = new Scanner(new File(filename));
            String[] cityNames = scnr.nextLine().split(",");
            for (int i = 1; i < cityNames.length; i++){
                GraphNode node = new GraphNode(cityNames[i]);
                cities.add(node);
            }
            int linenumber = 0;
            while(scnr.hasNext()){
                String line = scnr.nextLine();
                String numInProg = "";
                int counter = 0;
                for(int i = 0; i < line.length(); i++){
                    if(line.charAt(i) != ','){
                        if(Character.isDigit(line.charAt(i))){
                            numInProg += line.charAt(i);
                        }
                    }else{
                        if(!numInProg.equals("")){
                            int mileage = Integer.parseInt(numInProg);
                            GraphEdge edge = new GraphEdge(linenumber, counter - 1, mileage);
                            GraphEdge edge1 = new GraphEdge(counter - 1, linenumber, mileage);
                            mileages.add(edge);
                            cities.get(linenumber).edges.add(edge);
                            cities.get(counter - 1).edges.add(edge1);
                            numInProg = "";
                        }
                        counter++;
                    }
                }
                if(!numInProg.equals("")) {
                    int mileage = Integer.parseInt(numInProg);
                    GraphEdge edge = new GraphEdge(linenumber, counter - 1, mileage);
                    GraphEdge edge1 = new GraphEdge(counter - 1, linenumber, mileage);
                    mileages.add(edge);
                    cities.get(linenumber).edges.add(edge);
                    cities.get(counter - 1).edges.add(edge1);
                }
                linenumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void depthFirst(String startCity) {
        ArrayList<Integer> visited = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++){
            if(cities.get(i).name.equals(startCity)){
                depthFirst(i, visited);
                break;
            }
        }
    }

    // Recursive helper method
    public void depthFirst(int index, ArrayList<Integer> visited) {
        visited.add(index);
        GraphNode node = cities.get(index);
        GraphEdge minEdge = nextMinEdge(node, visited);
        System.out.println("Visited " + cities.get(index).name);
        while(minEdge != null){
            depthFirst(minEdge.toIndex, visited);
            minEdge = nextMinEdge(node, visited);
        }
    }

    public GraphEdge nextMinEdge (GraphNode node, ArrayList<Integer> visited){
        GraphEdge minEdge = null;
        for(GraphEdge edge: node.edges){
            if(!(visited.contains(edge.toIndex))){
                if(minEdge == null){minEdge = edge;}
                else if(edge.compareTo(minEdge) < 0){
                    minEdge = edge;
                }
            }
        }
        return minEdge;
    }

    public void breadthFirst(String startCity) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++){
            if(cities.get(i).name.equals(startCity)){
                visited.add(i);
                queue.add(i);
                breadthFirst(visited, queue);
                break;
            }
        }
    }


    public void breadthFirst(ArrayList<Integer> visited, Queue<Integer> queue){
        while (!queue.isEmpty()){
            GraphNode node = cities.get(queue.peek());
            GraphEdge minEdge = nextMinEdge(node, visited);
            while(minEdge != null){
                queue.add(minEdge.toIndex);
                visited.add(minEdge.toIndex);
                minEdge = nextMinEdge(node, visited);
            }
            System.out.println("Visited " + cities.get(queue.poll()).name);
        }
    }

    /**
     * create an empty queue for storing vertices to be visited;
     * add v into the queue;
     * mark v visited;
     * while the queue is not empty {
     * dequeue a vertex, say u, from the queue
     * for each neighbor w of u
     * if w has not been visited {
     * add w into the queue;
     * set u as the parent for w;
     * mark w visited;
     * }
     */

    /**
     * Reads the contents of file to {@code ArrayList}
     * @param filename the file to read from
     * @return an ArrayList of the contents
     */
    static ArrayList<String> readFile(String filename) {
        ArrayList<String> contents = new ArrayList<>();
        try(Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty())
                    contents.add(line);
            }
        } catch (IOException e) {
            System.err.println("Cannot read chart: " + filename);
        }
        return contents;
    }


}
