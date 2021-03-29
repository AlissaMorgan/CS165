import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PlantArrayListExample {

    public static void printArrayList(List<Plant> objects){
        for(int i = 0; i < objects.size(); i++){
            objects.get(i).printInfo();
            System.out.println();
        }
    }
    // TODO: Define a printArrayList method that prints an ArrayList of plant (or flower) objects

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input;
        List<Plant> myGarden = new ArrayList<Plant>();
        // TODO: Declare an ArrayList called myGarden that can hold object of type plant
        String plantName, colorOfFlowers, plantCost;
        boolean isAnnual;
        // TODO: Declare variables - plantName, plantCost, colorOfFlowers, isAnnual

        input = scnr.next();
        while(!input.equals("-1")){
            if(input.equals("flower")){
                Flower flower = new Flower();
                flower.setPlantName(scnr.next());
                flower.setPlantCost(scnr.next());
                isAnnual = scnr.nextBoolean();
                flower.setPlantType(isAnnual);
                flower.setColorOfFlowers(scnr.next());
                //flower.printInfo();         //TODO
                myGarden.add(flower);
            }else{
                Plant plant = new Plant();
                plant.setPlantName(scnr.next());
                plant.setPlantCost(scnr.next());
                //plant.printInfo();          //TODO
                myGarden.add(plant);
            }
            //plant Spirea 10
            //flower Hydrangea 30 false lilac
            // TODO: Check if input is a plant or flower
            //       Store as a plant object or flower object
            //       Add to the ArrayList myGarden

            input = scnr.next();
        }

        // TODO: Call the method printArrayList to print myGarden
        printArrayList(myGarden);
    }
}

