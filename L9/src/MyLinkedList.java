import java.util.NoSuchElementException;

/** Linked List Lab
 * Made by Toby Patterson 5/29/2020
 * For CS165 at CSU
 */

public class MyLinkedList implements MiniList<Integer>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        public int data;
        public Node next;
        // declare member variables (data and next)

        // finish these constructors
        public int getData(){
            return data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(int data) {
            this.data = data;
            this.next = null;
        } // HINT: use this() with next = null
    }

    // Initialize the linked list (set head and tail pointers)
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(Integer item) {
        if(head == null){
            Node next = new Node(item);
            head = next;
            tail = head;
            size++;
            return true;
        }else{
            Node next = new Node(item);
            Node prev = getNode(size - 1);
            prev.next = next;
            //tail.next = next;
            tail = next;
            size++;
            return true;
        }
    }

    @Override
    public void add(int index, Integer element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }else if(tail == null){
            add(element);
        }else if(index == 0){
            Node curr = getNode(index);
            Node newNode = new Node(element, curr);
            head = newNode;
            size++;
        }
        Node prev = getNode(index - 1);
        Node curr = getNode(index);
        Node newNode = new Node(element, curr);
        prev.next = newNode;
        size++;

    }

    @Override
    public Integer remove() {
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return 0;
        }
        head.next = getNode(1);
        head = head.next;
        size--;
        return 0;
    }

    @Override
    public Integer remove(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }else if(tail == null){
            throw new NoSuchElementException();
        }else if(index == 0){
            return remove();
        }
        Node prev = getNode(index - 1);
        prev.next = getNode(index + 1);
        size --;
        return index;
    }

    @Override
    public boolean remove(Integer item) {
        Node n;
        for(int i = 0; i < size; i++){
            n = getNode(i);
            if(n.data == item){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(Integer item) {
        for(int i = 0; i < size; i++){
            if (get(i) == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        return getNode(index).getData();

    }

    public Node getNode(int index) {
        Node n = head;
        for(int i = 0; i < index; i++){
            n = n.next;
        }
        return n;
    }

    @Override
    public int indexOf(Integer item) {
        for(int i = 0; i < size; i++){
            if (get(i) == item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        if(size == 0){return true;}
        return false;
    }

    @Override
    public int size() {
        return size;
    }

//     Uncomment when ready to test
    @Override
    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }
        return ret;
    }

}