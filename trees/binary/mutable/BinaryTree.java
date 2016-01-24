package dataStructures.trees.binary.mutable;

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

    public Node traverseTree(Node current, Node previous){
        previous = current;
        current = current.getRightChild();
        current.setParent(previous);
        return current;
    }

    public void addRightChild(Node node) {
        Node current = root;
        Node previous = null;
        while(current.hasRight()){
            current = traverseTree(current, previous);
        }
        current.setRightChild(node);
        size++;

    }

    public void addLeftChild(Node node){
        Node current = root;
        Node previous = null;
        while (current.hasLeft()){
            current = traverseTree(current, previous);
        }
        current.setLeftChild(node);
        size++;
    }


    public void traverseInOrder(Node root){
        if (root == null){
            return;
        }
        traverseInOrder(root.getRightChild());
        System.out.println(root.getData().toString());
        traverseInOrder(root.getLeftChild());
    }
}
