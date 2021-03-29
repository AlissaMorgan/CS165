import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

    // TODO: Write method to create and output all permutations of the list of names.
    public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
        if(permList.size() == 0){
            for (int i = 0; i < nameList.size(); i++){
                System.out.print(nameList.get(i) + " ");
            }
            System.out.println();
        }else{
            for (int i = 0; i < permList.size(); i++) {
                String temp = permList.get(i);
                permList.remove(i);
                nameList.add(temp);
                allPermutations(permList, nameList);

                permList.add(i, temp);
                nameList.remove(nameList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> permList = new ArrayList<String>();
        String input = scnr.next();
        while(!input.equals("-1")){
            permList.add(input);
            input = scnr.next();
        }
        allPermutations(permList, nameList);
        // TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
    }
}
