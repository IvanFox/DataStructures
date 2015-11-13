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


    private void initBinaryTree(Node node){
        root = node;
        size = 1;
        height = 1;
        node.setParent(null);
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

    public void addRightChild(Node node) {
        Node current = root;
        while(current.hasRight()){
            current = current.getRightChild();
        }
        current.setRightChild(node);
        size++;

    }

    public void addLeftChild(Node node){
        Node current = root;
        while (current.hasLeft()){
            current = current.getLeftChild();
        }
        current.setLeftChild(node);
        size++;
    }


    public void displayNodes(Node root){
        if (root == null){
            return;
        }
        displayNodes(root.getRightChild());
        System.out.println(root.getData().toString());
        displayNodes(root.getLeftChild());
    }
}
