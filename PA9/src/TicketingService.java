import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TicketingService {

    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        String personName = "";
        int counter = 0;
        int youPosition = 0;

        Queue<String> peopleInQueue = new LinkedList<String>();

        personName = scnr.nextLine();
        while (!personName.equals("-1")) {
            counter++;
            if(personName.equals("You")){
                youPosition = counter;
            }
            peopleInQueue.add(personName);
            // TODO: Add personName to peopleInQueue and 
            //       determine position of "You" (youPosition)                                              

            personName = scnr.nextLine();
        }

        System.out.println("Welcome to the ticketing service... ");
        System.out.println("You are number " + youPosition + " in the queue.");

        for(int i = youPosition - 1; i > 0; i--){
            System.out.println(peopleInQueue.poll() + " has purchased a ticket.\n" +
                    "You are now number " + i);
        }
        System.out.println("You can now purchase your ticket!");
        // TODO: In a loop, remove head person from peopleInQueue,                                    
        //       output their name and that they have purchased a ticket,                             
        //       then output your position in the queue. When you are at                              
        //       the head, output that you can purchase your ticket.                                  


    }
}
