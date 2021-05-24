/* Binary Search Tree Class
*  A binary search tree of generic type which extends Comparable
*/

import java.util.ArrayList;

public class BST<E extends Comparable<E>> implements Tree<E> {

    private TreeNode root;
    private int size;

    public class TreeNode<E> {
        public E element;
        public TreeNode rightChild;
        public TreeNode leftChild;

        /* TODO: finish this constructor
        *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(E element) {
            this.element = element;
            this.rightChild = null;
            this.leftChild = null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(E item) {
        this();
        insert(item);
    }

    public BST(E[] items) {
        for(Object o: items){
            insert((E) o);
        }
        /* TODO: Insert all of items into this tree */

    }

    /* TODO: finish this method */
    @Override
    public boolean search(E e) {
        TreeNode curr = root;
        while(curr != null){
            if(e == curr.element){
                return true;
            }else if(e.compareTo((E) curr.element) < 0){
                curr = curr.leftChild;
            }else{
                curr = curr.rightChild;
            }
        }
        return false;
    }

    public TreeNode getNode(E e) {
        TreeNode curr = root;
        while(curr != null){
            if(e == curr.element){
                return curr;
            }else if(e.compareTo((E) curr.element) < 0){
                curr = curr.leftChild;
            }else{
                curr = curr.rightChild;
            }
        }
        return curr;
    }

    public TreeNode getNodeParent(E e) {
        TreeNode curr = root;
        TreeNode parent = root;
        while(curr != null){
            if(e == curr.element){
                return parent;
            }else if(e.compareTo((E) curr.element) < 0){
                parent =  curr;
                curr = curr.leftChild;

            }else{
                parent = curr;
                curr = curr.rightChild;
            }
        }
        return parent;
    }

    /* TODO: finish this method */
    @Override
    public boolean insert(E e) {
        if(root == null){
            root = new TreeNode(e);
            size++;
            return true;
        }
        size++;
        return insert(e, root);
    }

    public boolean insert(E item, TreeNode curr){
        if(item.compareTo((E) curr.element) < 0){ //(Integer) curr.element > item
            if(curr.leftChild == null){
                curr.leftChild = new TreeNode(item);
                return true;
            }
            return insert(item, curr.leftChild);
        }else if (item.compareTo((E) curr.element) > 0){ //(Integer) curr.element < item
            if(curr.rightChild == null){
                curr.rightChild = new TreeNode(item);
            }
            return insert(item, curr.rightChild);
        }
        return false;
    }

    /* TODO: finish this method */
    @Override
    public boolean remove(E e) {
        if(search(e)){
            TreeNode treeNode = getNode(e);
            TreeNode parent = getNodeParent(e);
            if(treeNode.leftChild == null && treeNode.rightChild ==  null){
                return isLeaf(parent, treeNode);
            }if(!(treeNode.leftChild == null) && !(treeNode.rightChild ==  null)){
                return hasTwoChild(parent, treeNode);
            }if(treeNode.leftChild == null || treeNode.rightChild ==  null){
                return hasOneChild(parent, treeNode);
            }
        }
        return false;
    }

    public boolean isLeaf(TreeNode parentNode, TreeNode childNode){
        if(parentNode.leftChild.equals(childNode)){
            parentNode.leftChild = null;
        }else{
            parentNode.rightChild = null;
        }
        return true;
    }

    public boolean hasOneChild(TreeNode parentNode, TreeNode childNode){
        if(parentNode.leftChild == childNode){
            if (!(childNode.leftChild == null)){
                parentNode.leftChild = childNode.leftChild;
                return true;
            }
            parentNode.leftChild = childNode.rightChild;
        }else{
            if (!(childNode.leftChild == null)){
                parentNode.rightChild = childNode.leftChild;
                return true;
            }
            parentNode.rightChild = childNode.rightChild;
        }
        return true;
    }

    public boolean hasTwoChild(TreeNode parent, TreeNode treeNode){
        ArrayList inOrder = searchInOrder(root);
        TreeNode successor;
        for(int i = 0; i < inOrder.size() - 1; i++){
            if(inOrder.get(i) == treeNode.element){
                successor = getNode((E) inOrder.get(i + 1));
                TreeNode successorCopy = new TreeNode(successor.element);
                remove((E) successor.element);
                successorCopy.leftChild = treeNode.leftChild;
                successorCopy.rightChild = treeNode.rightChild;
                if(treeNode == root){
                    root = successorCopy;
                }else{
                    if(parent.leftChild == treeNode){
                        parent.leftChild = successorCopy;
                    }else{parent.rightChild = successorCopy;}
                }
                return true;
            }
        }


        return false;
    }

    /* Getter method for the size of the tree
    *  TODO: complete this method
    */
    @Override
    public int size() {
        return size;
    }

    /* Does an inorder traversal of the tree, printing each visited node
    *  TODO: Complete this method
    */
    @Override
    public void inorder() {
        inOrder(root);
    }

    public boolean inOrder(TreeNode curr){
        if(curr == null){
            return true;
        }
        inOrder(curr.leftChild);
        System.out.print(curr.element + " ");
        inOrder(curr.rightChild);
        return true;
    }

    ArrayList <E> inOrderList = new ArrayList<>();
    public ArrayList<E> searchInOrder(TreeNode curr){
        if(curr == null){
            return null;
        }
        searchInOrder(curr.leftChild);
        inOrderList.add((E) curr.element);
        searchInOrder(curr.rightChild);
        return inOrderList;
    }

    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {
        postOrder(root);
    }

    public boolean postOrder(TreeNode curr){
        if(curr == null){
            return true;
        }
        postOrder(curr.leftChild);
        postOrder(curr.rightChild);
        System.out.print(curr.element + " ");
        return true;
    }
    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {
        preOrder(root);
    }

    public boolean preOrder(TreeNode curr){
        if(curr == null){
            return true;
        }
        System.out.print(curr.element + " ");
        preOrder(curr.leftChild);
        preOrder(curr.rightChild);
        return true;
    }
    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /* Returns the root node of the tree */
    public TreeNode getRoot() {
        return root;
    }
}
