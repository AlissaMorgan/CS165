public class QuadraticTable implements ITable{
    String[] table;
    int numItems;

    /**
     * Hash table size must be greater than 7 to use the second hash.
     * @param numSlots
     */
    public QuadraticTable(int numSlots){
        table = new String[numSlots];
        this.numItems = 0;
    }
    /**
     * TODO - Complete This Function
     * This function should insert the key at the index given by the hash.
     * To do this:
     * 1. compute hash() and get index using modulo. insert the element if the slot is empty
     * 2. if the slot is not empty, first check to make sure it's not a duplicate and then
     * insert it if not. We don't want to insert a duplicate.
     * 3. if the slot is full and it's not a duplicate key then find the next index using
     * (hash() + i^2) % numSlots starting with i = 1 until you find an empty spot or until the new index
     * is equal to the original hash then you have checked all other spots.
     *
     * 
     * @param key - item to insert into the table
     * @return True if the item could be inserted or false if it is a duplicate
     */
    @Override
    public boolean insert(String key) {
        boolean isFull = true;
        for (String s: table){
            if(s == null){
                isFull = false;
                break;
            }
        }if(isFull){return false;}
        int index = hash(key) % table.length;
        if (table[index] == null){
            table[index] = key;
            return true;
        }else {
            for (int i = 1; i < table.length; i++) {
                int index1 = (hash(key) + i * i) % table.length;
                if (table[index1] != null && table[index1].equals(key)) {
                    return false;
                } else if (table[index1] == null) {
                    table[index1] = key;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method should return the string or null if there is no matching element
     * To do this following similar steps as insert until you find the key or if you find an empty spot then
     * you know the key is not in the table and you can return false.
     * @param key
     * @return
     */
    @Override
    public boolean search(String key) {
        int index = hash(key) % table.length;
        if (table[index].equals(key)){
            return true;
        }if (table[index] == null){
            return false;
        }else{
            for (int i = index; i < table.length; i++){
                if(table[i] == null){
                    return false;
                }if (table[i].equals(key)){
                    return true;
                }
            }for (int i = 0; i < index; i++){
                if(table[i] == null){
                    return false;
                }if (table[i].equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * a hash function which simply uses Java's built in function for hashing strings.
     * @param key
     * @return
     */
    public int hash(String key){
        return Math.abs(key.hashCode());
    }

    /**
     * Should return a string representation of the table like:
     * slot 1: item or list of items
     * slot 2: item or list of items
     * ...
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < table.length; i++){
            ret.append(String.format("Bucket %d: %s\n", i, table[i]));
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        /* Table tests */
        String[] names = {"Liam", "Noah", "William", "James", "Oliver",
                "Benjamin", "Charlotte", "Mia", "Evelyn", "Harper",
                "Lucas", "Mason", "Lucas"};
        QuadraticTable table = new QuadraticTable(names.length-2);
        for (String name : names) {
            table.insert(name);
        }
        System.out.println(table);
        /* search() tests */
        String name = "Liam";
        boolean search = table.search(name);
        System.out.printf("Testing search(%s)...\n", name);
        if(!search){
            System.out.print("FAILURE -> ");
        }else{
            System.out.print("PASSED -> ");
        }
        System.out.printf("Expected: %b, Actual: %b\n", true, search);

        String name2 = "Joshua";
        boolean search2 = table.search(name2);
        System.out.printf("Testing search(%s)...\n", name2);
        if(search2){
            System.out.print("FAILURE -> ");
        }else{
            System.out.print("PASSED -> ");
        }
        System.out.printf("Expected: %b, Actual: %b\n", false, search2);
    }

}
