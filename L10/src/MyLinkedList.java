import java.util.NoSuchElementException;

/** Linked List Lab
 * Made by Toby Patterson 5/31/2020
 * For CS165 at CSU
 */

public class MyLinkedList<E> implements MiniList<E>{
    /* Private member variables that you need to declare:*/
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        // declare member variables (data, prev and next)
        public E data;
        public Node next;
        public Node prev;
        // finish these constructors
        public E getData(){
            return data;
        }
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        public Node(E data) {
            this(data, null, null);
        } // HINT: use this() with next = prev = null
    }
    // Initialize the head and tail pointer
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(E item) {
        if(head == null){
            Node next = new Node(item);
            head = next;
            tail = head;
            size++;
            return true;
        }else{
            Node prev = getNode(size - 1);
            Node next = new Node(item, prev, null);
            prev.next = next;
            tail = next;
            size++;
            return true;
        }
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }else if(tail == null){
            add(element);
        }else if(index == 0){
            Node curr = getNode(index);
            Node newNode = new Node(element, null, curr);
            head = newNode;
            size++;
        }
        Node prev = getNode(index - 1);
        Node curr = getNode(index);
        Node newNode = new Node(element, prev, curr);
        prev.next = newNode;
        size++;
    }

    @Override
    public E remove() {
        if(head == tail){
            head = null;
            tail = null;
            size = 0;
            return getNode(0).getData();
        }
        head.next = getNode(1);
        head = head.next;
        size--;
        return getNode(0).getData();
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }else if(tail == null){
            throw new NoSuchElementException();
        }else if(index == 0){
            return remove();
        }
        else if(index == size - 1){
            E ret = getNode(index).getData();
            Node prevNode = getNode(index - 1);
            prevNode.next = null;
            tail = prevNode;
            size --;
            return ret;
        }else{
            Node prevNode = getNode(index - 1);
            Node currNode = getNode(index + 1);
            prevNode.next = currNode;
            currNode.prev = prevNode;
            size --;
        }
        return getNode(index).getData();
    }

    @Override
    public boolean remove(E item) {
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
        size = 0;
    }

    @Override
    public boolean contains(E item) {
        for(int i = 0; i < size; i++){
            if (get(i) == item){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
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
    public int indexOf(E item) {
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

    // Uncomment when ready to test
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