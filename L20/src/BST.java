/* Binary Search Tree Class
*  Made by Toby Patterson for CS165 at CSU
*  6/25/2020
*  A basic binary search tree of integers, without a remove method.
*/

public class BST implements Tree<Integer> {

    private TreeNode root;
    private int size;

    public class TreeNode<Integer> {
        public Integer element;
        public TreeNode rightChild;
        public TreeNode leftChild;

        /* TODO: finish this constructor
        *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(Integer element) {
            this.element = element;
            this.rightChild = null;
            this.leftChild = null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(Integer item) {
        super();
        insert(item);
    }

    public BST(Integer[] items) {
        for(Integer i: items){
            insert(i);
        }
        /* TODO: Insert all of items into this tree */
    }

    /* Does a binary search.
    *  TODO: complete this method */
    @Override
    public boolean search(Integer item) {
        TreeNode curr = root;
        while(curr != null){
            if(item == curr.element){
                return true;
            }else if(item < (Integer) curr.element){
                curr = curr.leftChild;
            }else{
                curr = curr.rightChild;
            }
        }
        return false;
    }

    /* Inserts item into tree, return false if item is already in tree.
    *  Order of the tree is: root.element > left.element &&
    *                        root.element < right.element
    *  TODO: complete this method
    */
    @Override
    public boolean insert(Integer item) {
        if(root == null){
            root = new TreeNode(item);
            size++;
            return true;
        }
        size++;
        return insert(item, root);
    }

    public boolean insert(Integer item, TreeNode curr){
        if((Integer) curr.element > item){
            if(curr.leftChild == null){
                curr.leftChild = new TreeNode(item);
                return true;
            }
            return insert(item, curr.leftChild);
        }else if ((Integer) curr.element < item){
            if(curr.rightChild == null){
                curr.rightChild = new TreeNode(item);
            }
            return insert(item, curr.rightChild);
        }
        return false;
    }

    // for the next lab
//    @Override
//    public boolean remove(Integer item) {
//        return false;
//    }

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

    /* Does a postorder traversal of the tree, printing each visited node
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

    /* Does a preorder traversal of the tree, printing each visited node
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
