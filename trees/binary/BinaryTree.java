package DataStructures.trees.binary;

/**
 * Created by IvanLis on 08/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class BinaryTree {

    private Node root;
    private int size;
    private int height;


    public BinaryTree(Node root) {
        initBinaryTree(root);
    }

    public BinaryTree() {
        initBinaryTree();
    }
    
    private void initBinaryTree(Node node){
        root = node;
        size = 0;
        height = 0;
    }

    // init tree with no root
    private void initBinaryTree(){
        root = null;
        size = 0;
        height = 0;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int getHeight() {
        return height;
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }



    public void addLChild(Node child){
        if (isEmpty()){
            root = child;
        }
    }
}
