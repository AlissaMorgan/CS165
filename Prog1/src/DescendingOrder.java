import java.util.Arrays;
import java.util.Scanner;

public class DescendingOrder {
    // TODO: Write a void method selectionSortDescendTrace() that takes
    //       an integer array and the number of elements in the array as arguments,
    //       and sorts the array into descending order.

    public static void selectionSortDescendTrace(int [] numbers, int numElements) {
        int max;
        for(int j = 0; j < numElements; j++){ //finds first index of array at time
            max = j;
            for(int i = j; i < numElements; i++){
                if(numbers[max] < numbers[i]){
                    max = i;
                }
               // System.out.print(max);
            }
            //System.out.println(max);
            if(j > 0){
              for (int num : numbers){
                  System.out.print(num + " ");
              }
              System.out.println();
            }

            int temp = numbers[max];
            numbers[max] = numbers[j];
            numbers[j] = temp;
        }
    }


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int input = 0, i = 0;
        int numElements = 0;
        int [] numbers = new int[10];

        // TODO: Read in a list of up to 10 positive integers; stop when
        //       -1 is read. Then call selectionSortDescendTrace() method.

        while(input != -1){
            input = (Integer) scnr.nextInt();
            if(input != -1){
                numbers[i] = input;
            }
            i++;
//            System.out.println("input: " + input + " at index: " + i);
        }
        numElements = i - 1;
//        System.out.println(numElements);
        int [] array = new int [numElements];
        for (int j = 0; j < numElements; j++){
            array[j] = numbers[j];
        }
        selectionSortDescendTrace(array, numElements);

    }
}

