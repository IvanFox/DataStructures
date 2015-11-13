package DataStructures.trees.binary;

/**
 * Created by IvanLis on 08/11/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Node <T>  implements Comparable<Node>{

    private T data;
    private Node parent;
    private Node leftChild;
    private Node rightChild;


    public Node(T data) {
        this.data = data;
        initChildNodes();
    }

    private void initChildNodes(){
        leftChild = null;
        rightChild = null;
    }

    public T getData() {
        return this.data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }


    public Node getParent() {
        return parent;
    }

    // returns true if node is a non leaf
    public boolean isInternal(){
        return !isLeaf();
    }

    public boolean isRoot(){
        return parent == null;
    }

    public boolean hasLeft(){
        return this.getLeftChild() != null;
    }

    public boolean hasRight(){
        return this.getRightChild() != null;
    }

    public boolean isLeaf(){
        return !hasLeft() && !hasRight();
    }

    @Override
    public int compareTo(Node o) {
        return this.getData() != o.getData() ? 0 : 1;
    }
}
